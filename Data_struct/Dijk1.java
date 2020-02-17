import java.util.*;

class Node{
  int vtx;
  int weight;
  Node(int vtx, int weight){
    this.vtx = vtx;
    this.weight = weight;
  }

  void setWeight(int weight){
    this.weight = weight;
  }
  void setVertix(int vtx){
    this.vtx = vtx;
  }
  int getVertix(){
    return this.vtx;
  }
  int getWeight(){
    return this.weight;
  }

  void setWeightAndVertix(int we, int vt){
    setWeight(we);
    setVertix(vt);
  }

  @Override
  public String toString(){
    return String.valueOf("we: "+this.weight+" prev: "+this.vtx);
  }
}

class Dijk{
  HashMap<Integer, LinkedList<Node>> grph;
  HashSet<Integer> seen ;
  HashMap<Integer, Node> dist;

  Dijk(){
    grph = new HashMap<>();
    seen = new HashSet<>();
    dist = new HashMap<>();
  }

  void addEdge(int v, int u, int we){
    if(grph.containsKey(v)){
      grph.get(v).add(new Node(u, we));
    }
    else{
      LinkedList<Node> alist = new LinkedList<>();
      alist.add(new Node(u,we));
      grph.put(v,alist);
    }

    // if(grph.containsKey(u)){
    //   grph.get(u).add(new Node(v, we));
    // }
    // else{
    //   LinkedList<Node> alist = new LinkedList<>();
    //   alist.add(new Node(v,we));
    //   grph.put(u,alist);
    // }

    dist.put(v,new Node(-999,Integer.MAX_VALUE));
    dist.put(u,new Node(-999,Integer.MAX_VALUE));
  }

  void display(){
    for(int key: grph.keySet()){
      System.out.println(key+"->"+grph.get(key));
    }
  }

  void dijkstra(int sv){
    PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>(){
      @Override
      public int compare(Integer v1, Integer v2){
        Node n1 = dist.get(v1);
        Node n2 = dist.get(v2);
        return n1.getWeight() > n2.getWeight()? 1 : n1.getWeight() < n2.getWeight()? -1 : 0;
      }
    });

    Node snode = dist.get(sv);
    snode.setVertix(sv);
    snode.setWeight(0);
    pq.add(sv);
    seen.add(sv);
    while( !pq.isEmpty() ){
      sv = pq.poll();
      // if(seen.contains(sv))
      //   continue;
      // seen.add(sv);

      //look at NEW NOTE below.
      //NEW NOTE look for new implementation in Java/crack/GraphPract1.
      //resolves the above issues.

      LinkedList<Node> alist = grph.getOrDefault(sv, null);
      if(alist != null){
        for(Node node : alist){
          int vtx = node.getVertix();
          int weht = node.getWeight();
          if(dist.get(vtx).getWeight() > (dist.get(sv).getWeight() + weht)){
            dist.get(vtx).setWeight(dist.get(sv).getWeight() + weht);
            dist.get(vtx).setVertix(sv);
            //works if kepts as BFS working.
            //is also right.
            if(!seen.contains(vtx)){
              pq.add(vtx);
              seen.add(vtx);
            }
          }
        }
      }
    }

    for(int key: dist.keySet()){
      System.out.println(key+" : "+dist.get(key));
    }
  }

  void bellford(ArrayList<Integer> nlist){
    seen.clear();
    for(int k : nlist){
      dist.get(k).setWeightAndVertix(Integer.MAX_VALUE, -999);
    }

    dist.get(nlist.get(0)).setWeightAndVertix(0,nlist.get(0));

    for(int i = 0 ; i < (nlist.size()-1); i++){
      for(int key : nlist){
        LinkedList<Node> alist = grph.get(key);
        if(alist != null){
          for(Node node: alist){
            int dis = dist.get(node.getVertix()).getWeight();
            int we = node.getWeight();
            int selfdis = dist.get(key).getWeight();
            if(selfdis != Integer.MAX_VALUE && dis > we+selfdis){
              dist.get(node.getVertix()).setWeightAndVertix( we+selfdis, key);
            }
          }
        }
      }
    }
    for(int key: dist.keySet()){
      System.out.println(key+" : "+dist.get(key));
    }

    System.out.println("negative cycle at: ");
    //to get negative cycle do one more iteration, iin case,
    // any score improves, that means we have a negative cycle.
    for(int key : nlist){
      LinkedList<Node> alist = grph.get(key);
      if(alist != null){
        for(Node node: alist){
          int dis = dist.get(node.getVertix()).getWeight();
          int we = node.getWeight();
          int selfdis = dist.get(key).getWeight();
          if(selfdis != Integer.MAX_VALUE && dis > we+selfdis){
            dist.get(node.getVertix()).setWeightAndVertix( we+selfdis, key);
            System.out.println(node.getVertix());
          }
        }
      }
    }
  }
}
class DijkMain{
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

    g.display();

    System.out.println("\nShortest Paths DIJK: ");
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
    ArrayList<Integer> nlist = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    g.bellford(nlist);
  }
}
