import java.util.*;

//will only work for directed cycllic graphs, common sense.
class Solution extends Graph{

  boolean dfs(int node){
    if(cySeen.get(node) == 1){
      System.out.println("Dead lock strt: "+node);
      return false;
    }
    cySeen.put(node, 1);
    List<Integer> clist = graph.getOrDefault(node, null);
    if(clist != null){
      for(int cnode: clist){
        if(cySeen.get(cnode) != 2 && !dfs(cnode)){
          System.out.println("Dead lock end: "+node);
          return false;
        }
      }
    }
    cySeen.put(node, 2);
    return true;
  }

  void dlockDFS(){
    for(int pnode: graph.keySet()){
      if(cySeen.get(pnode) == 0 ){
        if(!dfs(pnode)){
          return;
        }
      }
    }
    System.out.println("no deadlocks");
  }
}

class DlockDFS{
  public static void main(String[] args) {
    //will only work for directed cycllic graphs, common sense.
    Solution sol = new Solution();
    sol.addNodeDirected(10,11);
    sol.addNodeDirected(10,12);
    sol.addNodeDirected(12,11);
    sol.addNodeDirected(12,13);
    sol.addNodeDirected(11,15);
    sol.addNodeDirected(16,17);
    sol.addNodeDirected(17,14);
    sol.addNodeDirected(14,13);
    sol.addNodeDirected(14,11);
    sol.addNodeDirected(15,14);
    sol.addNodeDirected(11,13);

    sol.dlockDFS();
  }
}
