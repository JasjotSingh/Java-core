import java.util.*;
import java.lang.*;

class Node{
  int val;
  int dist;
  Node(int preval, int dist){
    this.val = preval;
    this.dist = dist;
  }

  void setval(int val){
    this.val = val;
  }
  void setDist(int dist){
    this.dist = dist;
  }

  int getval(){
    return this.val;
  }
  int getDist(){
    return this.dist;
  }
  @Override
  public String toString(){
    return String.valueOf("val: "+this.val+" dist: "+this.dist);
  }
}
class Dijk{
  HashMap<Integer,LinkedList<Node>> grp ;
  HashSet<Integer> seen;
  HashMap<Integer,Node> dlist;  //dijk and bell.
  HashMap<Integer,Integer> id; //find bridge and artuclation point.
  HashMap<Integer,Integer> lowlink;//find bridge and artuclation point.
  int orid ; //find bridge and artuclation point. HAS TO BE GLOBAL.

  Dijk(){
    grp = new HashMap<>();
    seen = new HashSet<>();
    dlist = new HashMap<>();
    id = new HashMap<>();
    lowlink = new HashMap<>();
    orid = 0;
  }

  void addEdge(int v1, int v2, int we){
    if(grp.containsKey(v1)){
      grp.get(v1).add(new Node(v2,we));
    }
    else{
      LinkedList<Node> nel = new LinkedList<>();
      nel.add(new Node(v2,we));
      grp.put(v1,nel);
    }

    dlist.put(v1, new Node(-999, Integer.MAX_VALUE));
    dlist.put(v2, new Node(-999, Integer.MAX_VALUE));
  }

  void addEdgeDouble(int v1, int v2, int we){
    if(grp.containsKey(v1)){
      grp.get(v1).add(new Node(v2,we));
    }
    else{
      LinkedList<Node> nel = new LinkedList<>();
      nel.add(new Node(v2,we));
      grp.put(v1,nel);
    }

    if(grp.containsKey(v2)){
      grp.get(v2).add(new Node(v1,we));
    }
    else{
      LinkedList<Node> nel = new LinkedList<>();
      nel.add(new Node(v1,we));
      grp.put(v2,nel);
    }

  }

  void findBridge(LinkedList<ArrayList<Integer>> bridge, int nval, int parent){
    id.put(nval, orid);
    lowlink.put(nval, orid++);
    seen.add(nval);
    LinkedList<Node> alist = grp.get(nval);
    for(Node node: alist){
      if(node.getval() == parent)//not needed in directed graph.
        continue;
      if(!seen.contains(node.getval())){
        findBridge(bridge, node.getval(), nval);//increment orid, for each new node.
        //here change lowlink val of nval, in case lowlink (not id) of unseen node is less.
        lowlink.put(nval, Math.min(lowlink.get(nval), lowlink.get(node.getval())));
        if(lowlink.get(node.getval()) > id.get(nval)){
          //if lowlink of node > than id of nval, then its a bridge.
          ArrayList<Integer> pair = new ArrayList<>();
          pair.add(node.getval());
          pair.add(nval);
          bridge.add(pair);
        }
      }
      else{
        //if node seen, change lowlink val for nval, if id(not lowlink) of node lower.
        lowlink.put(nval, Math.min(lowlink.get(nval), id.get(node.getval())));
      }
    }
  }

  void findBridge(){
    LinkedList<ArrayList<Integer>> bridge = new LinkedList<>();

    for(int key : grp.keySet()){
      if(!seen.contains(key)){
        findBridge(bridge, key, -1);
      }
    }
    if(bridge.size() == 0){
      System.out.println("No bridges.");
    }
    for(ArrayList<Integer> brid : bridge){
      System.out.println(brid.get(0)+" "+brid.get(1));
    }
    System.out.println("id: "+id);
    System.out.println("lowlink: "+lowlink);
  }

  void display(){
    for(int key: grp.keySet()){
      System.out.println(key+": "+grp.get(key));
    }
  }

  void dijkstra(int strtval){
    //look at NEW NOTE below.
    //NEW NOTE look for new implementation in Java/crack/GraphPract1.
    //simillar as below implitaation, but adds three states in seen,
    //to make it more like actual dijkstra.
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      @Override
      public int compare(Integer i1, Integer i2){
        Node n1 = dlist.get(i1);
        Node n2 = dlist.get(i2);
        return n1.getDist() > n2.getDist()?1 : n1.getDist() < n2.getDist()? -1:0;
      }
    });

    Node stnode = dlist.get(strtval);
    stnode.setval(strtval);
    stnode.setDist(0);
    seen.add(strtval);
    pq.add(strtval);
    while(!pq.isEmpty()){
      strtval = pq.poll();
      LinkedList<Node> alist = grp.getOrDefault(strtval, null);
      if(alist != null){
        for(Node node : alist){
          //see distance and then decide if needs to be added to qu is not seen.
          int nval = node.getval();
          int nweg = node.getDist();
          int ddist = dlist.get(nval).getDist();
          int odist = dlist.get(strtval).getDist();
          if(ddist > odist+nweg){
            dlist.get(nval).setval(strtval);
            dlist.get(nval).setDist(odist+nweg);
          }
          //if alerady seen do not cal the distance again.
          if(!seen.contains(nval)){
            seen.add(nval);
            pq.add(nval);
          }
        }
      }
    }
    //print here:
    for(int key: dlist.keySet()){
      System.out.println(key+" dist:"+dlist.get(key).getDist()+" prev:"+dlist.get(key).getval());
    }
  }

  //issues in bell, check data_struct1 for correct.
  void bellford(ArrayList<Integer> nlist){

    int stval = nlist.get(0);
    dlist.get(stval).setval(stval);
    dlist.get(stval).setDist(0);

    for(int i = 0; i < nlist.size()-1; i++){
      for(int key: nlist){
        LinkedList<Node> alist = grp.getOrDefault(key, null);
        if(alist != null){
          for(Node node: alist){
            int val = node.getval();
            int we = node.getDist();
            int ddist = dlist.get(val).getDist();
            int odist = dlist.get(key).getDist();
            if(odist != Integer.MAX_VALUE && ddist > odist+we){
              dlist.get(val).setval(key);
              dlist.get(val).setDist(odist+we);
            }
          }
        }
      }
    }
    for(int key: dlist.keySet()){
      System.out.println(key+" dist:"+dlist.get(key).getDist()+" prev:"+dlist.get(key).getval());
    }
    System.out.println("Negative cycles at:");
    //iisue should run n-1 times:
    for(int key: nlist){
      LinkedList<Node> alist = grp.getOrDefault(key, null);
      if(alist != null){
        for(Node node: alist){
          int val = node.getval();
          int we = node.getDist();
          int ddist = dlist.get(val).getDist();
          int odist = dlist.get(key).getDist();
          if(odist != Integer.MAX_VALUE && ddist > odist+we){
            dlist.get(val).setval(-999);
            dlist.get(val).setDist(odist+we);
            System.out.println(val);
          }
        }
      }
    }
  }

  void Tarjans(Stack<Integer> stk, int nval, int par){
    seen.add(nval);
    stk.push(nval);
    id.put(nval, orid);
    lowlink.put(nval, orid++);
    LinkedList<Node> alist = grp.get(nval);

    for(Node node: alist){
      // if(node.getval() == par) //only needed in undirected graph.
      //   continue;
      if(!seen.contains(node.getval())){
        Tarjans(stk,node.getval(),nval);
      }
      if(stk.contains(node.getval()) &&
        lowlink.get(node.getval()) < lowlink.get(nval)){

        lowlink.put(nval,lowlink.get(node.val) );
      }
    }

    if(lowlink.get(nval) == id.get(nval)){
      while(stk.size() > 0 && stk.pop() != nval){
        continue;
      }
    }
  }

  void Tarjans(){
    Stack<Integer> stk = new Stack<>();
    for(int key: grp.keySet()){
      if(!seen.contains(key)){
        System.out.println(key);
        Tarjans(stk, key, -1);
      }
    }
    System.out.println("id: "+id);
    System.out.println("lowlink: "+lowlink);
  }
}

class Graph2{
  public static void main(String args[]){
    Dijk g = new Dijk();
    //directed, to make undirected changes addEdge.
    g.addEdge(0,1,4);
    g.addEdge(0,7,8);
    g.addEdge(7,1,11);
    g.addEdge(7,8,7);
    g.addEdge(7,6,1);
    g.addEdge(1,2,8);
    g.addEdge(2,8,2);
    g.addEdge(2,3,7);
    g.addEdge(2,5,4);
    g.addEdge(8,6,6);
    g.addEdge(6,5,2);
    g.addEdge(5,3,14);
    g.addEdge(5,4,10);
    g.addEdge(3,4,9);

    System.out.println("\nShortest Paths DIJK: ");
    g.display();
    g.dijkstra(0);

    g = new Dijk();
    g.addEdge(0,1,5);
    g.addEdge(1,2,20);
    g.addEdge(1,5,30);
    g.addEdge(1,6,60);
    g.addEdge(2,3,10);
    g.addEdge(3,2,-15);
    g.addEdge(2,4,75);
    g.addEdge(4,9,100);
    g.addEdge(5,4,25);
    g.addEdge(5,8,50);
    g.addEdge(5,6,5);
    g.addEdge(6,7,-50);
    g.addEdge(7,8,-10);

    System.out.println("\nShortest Paths BELL: ");
    g.display();
    ArrayList<Integer> nlist = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    g.bellford(nlist);

    g = new Dijk(); //adding weight to keep grp Node happy, not needed.
    g.addEdgeDouble(10,11,0);
    g.addEdgeDouble(11,12,0);
    g.addEdgeDouble(12,15,0);
    g.addEdgeDouble(12,13,0);
    g.addEdgeDouble(12,10,0);
    g.addEdgeDouble(13,14,0);
    g.addEdgeDouble(15,16,0);
    g.addEdgeDouble(15,18,0);
    g.addEdgeDouble(16,17,0);
    g.addEdgeDouble(17,18,0);
    // g.addEdgeDouble(10,11,0);
    // g.addEdgeDouble(11,12,0);
    // g.addEdgeDouble(12,13,0);
    // g.addEdgeDouble(12,10,0);
    // g.addEdgeDouble(12,14,0);
    // g.addEdgeDouble(13,14,0);

    System.out.println("\nBridges in map: ");
    g.display();
    g.findBridge();

    g = new Dijk(); //adding weight to keep grp Node happy, not needed.
    // g.addEdgeDouble(10,11,0);
    // g.addEdgeDouble(11,12,0);
    // g.addEdgeDouble(12,15,0);
    // g.addEdgeDouble(12,13,0);
    // g.addEdgeDouble(12,10,0);
    // g.addEdgeDouble(13,14,0);
    // g.addEdgeDouble(15,16,0);
    // g.addEdgeDouble(15,18,0);
    // g.addEdgeDouble(16,17,0);
    // g.addEdgeDouble(17,18,0);

    g.addEdge(10,11,0);
    g.addEdge(11,12,0);
    g.addEdge(12,10,0);
    g.addEdge(16,10,0);
    g.addEdge(16,12,0);
    g.addEdge(16,14,0);
    g.addEdge(15,10,0);
    g.addEdge(13,14,0);
    g.addEdge(13,17,0);
    g.addEdge(15,16,0);
    g.addEdge(14,15,0);
    g.addEdge(17,15,0);
    g.addEdge(17,13,0);
    //g.addEdgeDouble(17,18,0);

    System.out.println("\nTarjans Algo :");
    g.display();
    g.Tarjans();

  }
}
