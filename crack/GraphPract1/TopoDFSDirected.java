import java.util.*;

//topological sort is only valid for acyclic graphs.
class Solution extends Graph{
  void dfsTopo(){

    List<Integer> topsort = new ArrayList<>();

    for(int node: graph.keySet()){
      if(!acySeen.contains(node)){
        dfs(node, topsort);
      }
    }
    Collections.reverse(topsort);
    System.out.println(topsort);
  }

  void dfs(int node, List<Integer> topo){

    acySeen.add(node);
    List<Integer> clist = graph.getOrDefault(node, null);
    if(clist != null){
      for(int child: clist){
        if(!acySeen.contains(child)){
          dfs(child, topo);
        }
      }
    }
    topo.add(node);
  }
}

class TopoDFSDirected{
  public static void main(String[] args) {
    Solution sol = new Solution();

    //complex directed acyclic graph
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
    sol.dfsTopo();
    int end = (int)System.nanoTime();
    System.out.println("total time: "+ (end-strt));
  }
}
