import java.util.*;
class Node{
  int node;
  int weight;
  Node(int node, int weight){
    this.node = node;
    this.weight = weight;
  }

  int getNode(){
    return this.node;
  }
  int getWeight(){
    return this.weight;
  }
  void setNode(int node){
    this.node = node;
  }
  void setWeight(int weight){
    this.weight = weight;
  }
}
class graph{
  HashMap<Integer,HashSet<Node>> grph;
  HashMap<Integer,Node> dlist;
  HashSet<Integer> seen;
  graph(){
    grph = new HashMap<>();
    seen = new HashSet<>();
    dlist = new HashMap<>();
    seen.clear();
  }
  public void dijkstra(int node){
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      @Override
      public int compare(Integer n1, Integer n2){
        Node N1 = dlist.get(n1);
        Node N2 = dlist.get(n2);
        return N1.getWeight() > N2.getWeight() ? 1 : N1.getWeight() < N2.getWeight()? -1 : 0;
      }
    });
    Node ne = dlist.get(node);
    ne.setNode(node);
    ne.setWeight(0);
    seen.add(node);
    pq.add(node);

    while(!pq.isEmpty()){
      node = pq.poll();
      HashSet<Node> hset = grph.get(node);
      if(hset != null){
      for( Node n: hset){
        if(dlist.get(node).getWeight() + n.getWeight() < dlist.get(n.getNode()).getWeight()){
          //dlist.put(n.getNode(), );
          ne = dlist.get(n.getNode());
          ne.setWeight(dlist.get(node).getWeight() + n.getWeight());
          ne.setNode(node);
        }
        //doing this check here is wrong (but gives right answers), since we are
        //updating the distance above then deciding not to
        //add the new distance to pq, since it was already seen.
        //as per dijk algo, check to see if seen should be made before weight update above.
        //OR
        //look at dijk1.java comment in dijk algo.
        if(!seen.contains(n.getNode())){
          seen.add(n.getNode());
          pq.add(n.getNode());
        }
      }
    }
    }

    Set<Integer> k = dlist.keySet();
    for(int kval: k){
      Node no = dlist.get(kval);
      System.out.println(kval+" w:"+no.getWeight()+" N:"+no.getNode());
    }
  }

  public void addEdge(int src, int dest, int weg){
    if(!grph.containsKey(src)){
      HashSet<Node> alist = new HashSet<>();
      alist.add(new Node(dest,weg));
      grph.put(src,alist);
    }
    else{
      grph.get(src).add(new Node(dest, weg));
    }

    // if(!grph.containsKey(dest)){
    //   HashSet<Node> alist = new HashSet<>();
    //   alist.add(new Node(src,weg));
    //   grph.put(dest,alist);
    // }
    // else{
    //   grph.get(dest).add(new Node(src, weg));
    // }

    if(!dlist.containsKey(src))
      dlist.put(src,new Node(-1,Integer.MAX_VALUE));
    if(!dlist.containsKey(dest))
      dlist.put(dest, new Node(-1,Integer.MAX_VALUE));
  }


  public void display(){
    Set<Integer> kset = grph.keySet();
    for(int knode : kset){
      HashSet<Node> hset = grph.get(knode);
      System.out.print(knode+": ");
      for(Node n: hset){
        System.out.print("[ d:"+n.getNode()+" w:"+n.getWeight()+" ] ");
      }
      System.out.println("");
    }
  }
}
class Dijk{
  public static void main(String args[]){
    graph g = new graph();
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

    System.out.println("\nShortest Paths: ");
    g.dijkstra(0);

  }
}
