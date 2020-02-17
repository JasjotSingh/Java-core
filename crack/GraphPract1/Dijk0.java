import java.util.*;

class Node{
  int val;
  int dist;

  Node(int val, int dist){
    this.val = val;
    this.dist = dist;
  }

  int getVal(){
    return this.val;
  }
  int getDist(){
    return this.dist;
  }
  void setVal(int val){
    this.val = val;
  }
  void setDist(int dist){
    this.dist = dist;
  }
  @Override
  public String toString(){
    return "{val:"+this.val+", dist:"+this.dist+"}";
  }
}

class DGraph{
  enum visit{UNVISITED, ADDED, VISITED};
  HashMap<Integer, LinkedList<Node>> dgrp;
  HashMap<Integer, visit> visited;
  HashMap<Integer, Node> distList;

  DGraph(){
    dgrp = new HashMap<>();
    visited = new HashMap<>();
    distList = new HashMap<>();
  }

  void addEdge(int v1, int v2, int wt){
      if(!dgrp.containsKey(v1)){
        dgrp.put(v1, new LinkedList<>(Arrays.asList(new Node(v2,wt))));
      }
      else{
        dgrp.get(v1).add(new Node(v2,wt));
      }
      //set all nodes to unvisited
      visited.put(v1, visit.UNVISITED);
      visited.put(v2, visit.UNVISITED);

      //set distance of all nodes to infinity from infinity node(or a dummy value).
      distList.put(v1, new Node(Integer.MAX_VALUE, Integer.MAX_VALUE));
      distList.put(v2, new Node(Integer.MAX_VALUE, Integer.MAX_VALUE));
  }

  void addEdgeD(int v1, int v2, int wt){
      if(!dgrp.containsKey(v1)){
        dgrp.put(v1, new LinkedList<>(Arrays.asList(new Node(v2,wt))));
      }
      else{
        dgrp.get(v1).add(new Node(v2,wt));
      }
      if(!dgrp.containsKey(v2)){
        dgrp.put(v2, new LinkedList<>(Arrays.asList(new Node(v1,wt))));
      }
      else{
        dgrp.get(v2).add(new Node(v1,wt));
      }
      //set all nodes to unvisited
      visited.put(v1, visit.UNVISITED);
      visited.put(v2, visit.UNVISITED);

      //set distance of all nodes to infinity from infinity node(or a dummy value).
      distList.put(v1, new Node(Integer.MAX_VALUE, Integer.MAX_VALUE));
      distList.put(v2, new Node(Integer.MAX_VALUE, Integer.MAX_VALUE));
  }

}

class Solution extends DGraph{

  //if placed here as in iternal class makes sense, since
  //it needs to access updated values of distList hashmap.
  //if placed outside as a seprate class not nested class,
  //then will be complex.
  class dpq implements Comparator<Integer>{
    @Override
    public int compare(Integer i1, Integer i2){
      int dist1 = distList.get(i1).getDist();
      int dist2 = distList.get(i2).getDist();
      return dist1-dist2;
    }
  }

  void dijk(int strtval){
    //indexed priority queue.
    PriorityQueue<Integer> pq = new PriorityQueue<>(new dpq());
    pq.add(strtval);
    visited.put(strtval, visit.ADDED);

    //set distance of strt node to itself as 0.
    distList.get(strtval).setVal(strtval);
    distList.get(strtval).setDist(0);

    while(!pq.isEmpty()){
      int pnodeVal = pq.poll();
      int pnodeDist = distList.get(pnodeVal).getDist();
      visited.put(pnodeVal, visit.VISITED);

      //get child list.
      LinkedList<Node> clist = dgrp.getOrDefault(pnodeVal, null);
      if(clist  != null){
        for(Node cnode: clist){
          int childVal = cnode.getVal();
          int childDist = cnode.getDist();
          //if shortest path has already been calculated, skip.
          //solution to erlier dijk implementations(self).
          if(visited.get(childVal) == visit.VISITED)
            continue;

          int dlistChildDist = distList.get(childVal).getDist();
          int dlistChildPrev = distList.get(childVal).getVal();

          //relax distance if less, does not matter if child node is in pq or not,
          //if already in pq, dlist dist will be updated, if not in pq,
          //then added in if clause below this one.
          if(dlistChildDist > childDist+pnodeDist){
            dlistChildDist = childDist+pnodeDist;
            distList.get(childVal).setVal(pnodeVal);
            distList.get(childVal).setDist(dlistChildDist);
          }

          if(visited.get(childVal) == visit.UNVISITED){
            visited.put(childVal, visit.ADDED);
            pq.add(childVal);
          }

        }
      }
    }

    for(int key: distList.keySet()){
      System.out.println(key+" : "+distList.get(key));
    }
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

    System.out.println("\nShortest Paths DIJK: ");
    g.dijk(0);
  }

}
