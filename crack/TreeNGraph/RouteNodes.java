import java.util.*;

class Graph{ //directed graph.
  HashMap<Integer, ArrayList<Integer>> graph;
  HashSet<Integer> seen;
  Graph(){
    graph = new HashMap<>();
    seen = new HashSet<>();
  }

  void addNode(int parent, int child){
    if(graph.containsKey(parent)){
      graph.get(parent).add(child);
    }
    else{
      ArrayList<Integer> clist = new ArrayList<>();
      clist.add(child);
      graph.put(parent, clist);
    }
  }
}

class Solution extends Graph{
  boolean search(Graph grp, int prnt, int chld){
    Queue<Integer> qu = new LinkedList<>();
    qu.add(prnt);
    seen.add(prnt);

    while(!qu.isEmpty()){
      int pval = qu.pop();
      List<Integer> clist = graph.getOrDefault(pval, null);
      if(clist != null){
        for(int cval : clist){
          if(cval == chld)
            return true;
          else if(!seen.contains(cval)){
              qu.add(cval);
              seen.add(cval);
          }
        }
      }
    }
    return false;
  }
}

class RouteNodes{
  public static void main(String[] args) {

  }
}
