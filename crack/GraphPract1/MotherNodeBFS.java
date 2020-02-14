//is acyclic then mother node will be the one that is not present in any of the child lists.
//in cyclic grph , above is not always true;

import java.util.*;

class Solution extends Graph{
  void bfs(int node){
      Queue<Integer> qu = new LinkedList<>();
      qu.add(node);
      cySeen.put(node, 2);
      while(!qu.isEmpty()){
        int pnode = qu.poll();
        List<Integer> clist = graph.getOrDefault(pnode, null);
        if(clist != null){
          for(int child: clist){
            if(cySeen.get(child) == 0){
              cySeen.put(child,2);
              qu.add(child);
            }
          }
        }
      }
  }

  void motherNodeBFS(){
    int motherNode = 0;
    for(int pnode: graph.keySet()){
      if(cySeen.get(pnode) == 0){
        bfs(pnode);
        motherNode = pnode;
      }
    }
    clearSeen();
    bfs(motherNode);
    for(int seenValue: cySeen.values()){
      if(seenValue != 2){
        System.out.println("no Mother node exists.");
        return;
      }
    }
    System.out.println(motherNode+" is a Mother node.");
    return;
  }
}

class MotherNodeBFS{
  //is acyclic then mother node will be the one that is not present in any of the child lists.
  //in cyclic grph , above is not always true;
  public static void main(String[] args) {
    Solution sol = new Solution();

    //complex directed acyclic graph
    sol.addNodeDirected(11,10);
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
    sol.motherNodeBFS();
    int end = (int)System.nanoTime();
    System.out.println("tiem taken: "+(end-strt));
  }
}
