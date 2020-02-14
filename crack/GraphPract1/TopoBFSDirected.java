import java.util.*;

//topological sort with BFS is complex (just made up code), rather just do normal bfs to walk the tree.
//walk can be done with directed nd undirected graph, so cyclic and acyclic graphs.
//leave topo to DFS.
class Solution extends Graph{
  void bfs(HashMap<Integer, Integer> inedge,List<Integer> topo, int node){
    Queue<Integer> qu = new LinkedList<>();


    qu.add(node);
    acySeen.add(node);
    if(!inedge.containsKey(node))
      topo.add(node);
    while(!qu.isEmpty()){
      int pnode = qu.poll();
      List<Integer> clist = graph.getOrDefault(pnode, null);
      if(clist != null){
        for(int cnode: clist){
          if(!acySeen.contains(cnode) && inedge.get(cnode) <= 1){
            acySeen.add(cnode);
            qu.add(cnode);
          }
          inedge.put(cnode, inedge.get(cnode)-1);
          if(inedge.get(cnode) <= 0){
            topo.add(cnode);
          }
        }
      }
    }

  }

  void bfsinEdge(HashMap<Integer, Integer> inedge, int node){
    Queue<Integer> qu = new LinkedList<>();
    qu.add(node);
    acySeen.add(node);
    while(!qu.isEmpty()){
      int pnode = qu.poll();
      List<Integer> clist = graph.getOrDefault(pnode, null);
      if(clist != null){
        for(int cnode: clist){
          if(!acySeen.contains(cnode)){
            acySeen.add(cnode);
            qu.add(cnode);
          }
          inedge.put(cnode, inedge.getOrDefault(cnode,0)+1);
        }
      }
    }
  }

  void bfsTopo(){
    HashMap<Integer, Integer> inedge = new HashMap<>();
    for(int node: graph.keySet()){
      if(!acySeen.contains(node)){
        bfsinEdge(inedge, node);
      }
    }
    //System.out.println("\nIn Edge: \n"+inedge);
    clearSeen();

    List<Integer> topo = new ArrayList<>();
    for(int node: graph.keySet()){
      if(!acySeen.contains(node)){
        bfs(inedge,topo, node);
      }
    }
    //System.out.println("\nIn Edge: \n"+inedge);

    System.out.println("\ntopo: \n"+topo);

  }
}

class TopoBFSDirected{
  public static void main(String[] args) {
    Solution sol = new Solution();

    //topological sort with BFS is complex (just made up code), rather just do normal bfs to walk the tree.
    //walk can be done with directed nd undirected graph, so cyclic and acyclic graphs.
    //leave topo to DFS.
    sol.addNodeDirected(10,11);
    sol.addNodeDirected(10,12);
    sol.addNodeDirected(12,11);
    sol.addNodeDirected(12,13);
    sol.addNodeDirected(11,15);
    sol.addNodeDirected(16,17);
    sol.addNodeDirected(17,14);
    sol.addNodeDirected(14,13);
    sol.addNodeDirected(14,11);
    sol.addNodeDirected(14,15);
    sol.addNodeDirected(11,13);

    sol.displayGraph();
    sol.displaySeen();

    int strt = (int)System.nanoTime();
    sol.bfsTopo();
    int end = (int)System.nanoTime();
    System.out.println("total time: "+ (end-strt));
  }
}
