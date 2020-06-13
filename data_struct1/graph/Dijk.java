import java.util.*;

class Node{
  int val;
  int cost;

  Node(int val, int cost){
    this.val = val;
    this.cost = cost;
  }

  @Override
  public String toString(){
    return "{val : "+this.val+", cost :"+this.cost+"}";
  }
}

class Solution{
  enum state{
    VISITED,
    UNVISITED,
    ADDED
  }
  HashMap<Integer, List<Node>> graph;
  HashMap<Integer, Node> dlist;
  HashMap<Integer, state> seen;

  Solution(){
    graph = new HashMap<>();
    dlist = new HashMap<>();
    seen = new HashMap<>();
  }

  class distComparator implements Comparator<Integer>{
      @Override
      public int compare(Integer node1, Integer node2){
        return dlist.get(node1).cost - dlist.get(node2).cost;
      }
  }

  public void addEdgeD(int from, int to, int cost){
    if(graph.containsKey(from)){
      graph.get(from).add(new Node(to, cost));
    }
    else{
      List<Node> alist = new ArrayList<>();
      alist.add(new Node(to, cost));
      graph.put(from, alist);
    }
    seen.put(from, state.UNVISITED);
    seen.put(to, state.UNVISITED);
    dlist.put(from, new Node(to, Integer.MAX_VALUE));
    dlist.put(to, new Node(from, Integer.MAX_VALUE));
  }

  public void display(){
    System.out.println(graph);
  }

  public void dijk(int strtNode){
    PriorityQueue<Integer> pq = new PriorityQueue<>(new distComparator());
    pq.offer(strtNode);
    dlist.put(strtNode, new Node(strtNode, 0));

    while(!pq.isEmpty()){
      int keyNode = pq.poll();
      seen.put(keyNode, state.VISITED);
      List<Node> alist = graph.getOrDefault(keyNode, null);
      if(alist != null){
        for(Node childNode : alist){

            if(seen.get(childNode) != state.VISITED){
              int edgeCost = childNode.cost;
              int parentCost = dlist.get(keyNode).cost;
              int newDist = edgeCost+parentCost;
              int pathDist = dlist.get(childNode.val).cost;
              //can do as below, and remove dlist from addEdgeD. and above line.
              // int pathDist = Integer.MAX_VALUE;
              // if(dlist.containsKey(childNode.val))
              //   pathDist = dlist.get(childNode.val).cost;
              // else
              //   dlist.put(childNode.val, new Node(keyNode, Integer.MAX_VALUE));//using keyNode, can use an ything here.

              if(pathDist > newDist){
                Node dlistNode = dlist.get(childNode.val);
                dlistNode.cost = newDist;
                dlistNode.val = keyNode;
              }

              if(seen.get(childNode.val) == state.UNVISITED){
                seen.put(childNode.val, state.ADDED);
                pq.offer(childNode.val);
              }
          }
        }
      }
    }
    System.out.println(dlist);
  }
}


class Dijk{
  public static void main(String[] args) {
    Solution g = new Solution();
    g.addEdgeD(0,1,4);
    g.addEdgeD(0,7,8);
    g.addEdgeD(7,1,11);
    g.addEdgeD(7,8,7);
    g.addEdgeD(7,6,1);
    g.addEdgeD(1,2,8);
    g.addEdgeD(2,8,2);
    g.addEdgeD(2,3,7);
    g.addEdgeD(2,5,4);
    g.addEdgeD(8,6,6);
    g.addEdgeD(6,5,2);
    g.addEdgeD(5,3,14);
    g.addEdgeD(5,4,10);
    g.addEdgeD(3,4,9);

    g.display();
    System.out.println("\nShortest Paths DIJK: ");
    g.dijk(0);
  }
}
