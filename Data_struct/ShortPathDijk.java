import java.util.*;

class Node{
  int node;
  int weight;

  Node(int node, int weight){
    this.node = node;
    this.weight = weight;
  }

  void setNode(int node){
    this.node = node;
  }
  void setWeight(int weight){
    this.weight = weight;
  }

  int getNode(){
    return this.node;
  }
  int getWeight(){
    return this.weight;
  }
}


class SPgraph{
  HashMap<Integer, HashSet<Integer>> grp;
  HashMap<Integer, Node> dlist;
  HashSet<Integer> seen;

  SPgraph(){
    grp = new HashMap<>();
    dlist = new HashMap<>();
    seen = new HashSet<>();

    seen.clear();
  }

  public void dijk(int strt_node){
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      @Override
      public int compare(Integer i1, Integer i2){
        Node ne1 = dlist.get(i1);
        Node ne2 = dlist.get(i2);

        if(ne1.getWeight() == ne2.getWeight())
          return 0;
        else if(ne1.getWeight() > ne2.getWeight())
          return 1;
        return -1;
      }
    });

    pq.add(strt_node);
    Node ne = dlist.get(strt_node);
    ne.setNode(strt_node);
    ne.setWeight(0);
    seen.add(strt_node);

    while(!pq.isEmpty()){
      int node = pq.poll();
      ne = dlist.get(node);

      HashSet<Integer> alist = grp.get(node);
      for(int lnode: alist){
        if(ne.getWeight() + 1 < dlist.get(lnode).getWeight()){
          Node no = dlist.get(lnode);
          no.setWeight(ne.getWeight() + 1);
          no.setNode(node);
        }
        if(!seen.contains(lnode)){
          seen.add(lnode);
          pq.add(lnode);
        }
      }
    }

    System.out.println("\ndistance list :");
    for(int knode: dlist.keySet()){
      Node no = dlist.get(knode);
      System.out.println(knode+" W:"+no.getWeight()+" PN:"+no.getNode());
    }
  }

  public void addEdge(int src, int dest){
    if(grp.containsKey(src)){
      grp.get(src).add(dest);
    }
    else{
      HashSet<Integer> hset = new HashSet<>();
      hset.add(dest);
      grp.put(src,hset);
    }
    if(grp.containsKey(dest)){
      grp.get(dest).add(src);
    }
    else{
      HashSet<Integer> hset = new HashSet<>();
      hset.add(src);
      grp.put(dest,hset);
    }

    if(!dlist.containsKey(src))
      dlist.put(src, new Node(-1, Integer.MAX_VALUE));
    if(!dlist.containsKey(dest))
      dlist.put(dest, new Node(-1, Integer.MAX_VALUE));
  }
}

class ShortPathDijk{
  public static void main(String args[]){
    System.out.println("using dijk to find shortest pths in unweighted undirected graph :");
    SPgraph g = new SPgraph();
    g.addEdge(0,1);//4);
    g.addEdge(0,7);//8);
    g.addEdge(7,1);//11);
    g.addEdge(7,8);//7);
    g.addEdge(7,6);//1);
    g.addEdge(1,2);//8);
    g.addEdge(2,8);//2);
    g.addEdge(2,3);//7);
    g.addEdge(2,5);//4);
    g.addEdge(8,6);//6);
    g.addEdge(6,5);//2);
    g.addEdge(5,3);//14);
    g.addEdge(5,4);//10);
    g.addEdge(3,4);

    g.dijk(0);
  }
}
