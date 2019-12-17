import java.util.*;

class Grprbn{
  HashMap<Integer, HashSet<Integer>> grp;
  HashMap<Integer, state> seen;
  enum state {visited, unvisited;}
  Grprbn(){
    grp = new HashMap<>();
    seen = new HashMap<>();
  }

  private Boolean dfs(int val1, int val2){
    if(val1 == val2){
      return true;
    }
    else if( seen.get(val1) == state.visited){
      return false;
    }

    seen.put(val1,state.visited);
    HashSet<Integer> llist = grp.get(val1);
    if(llist != null){
      for(int k: llist){
        if(dfs(k, val2)){
          return true;
        }
      }
    }
    return false;
  }

  public void getRoute(int val1, int val2){
    Boolean route = false;
    Set<Integer> sset = seen.keySet();
    for(int key: sset){
      seen.put(key,state.unvisited);
    }
    route = dfs(val1, val2);
    if(route){
      System.out.println("Route Exists");
    }
    else{
      System.out.println("No Route");
    }
  }

  public void addEdge(int val1, int val2){
    if(grp.containsKey(val1)){
      grp.get(val1).add(val2);
    }
    else{
      HashSet<Integer> hs =  new HashSet<>();
      hs.add(val2);
      grp.put(val1,hs);
    }
    seen.put(val1,state.unvisited);
    seen.put(val2,state.unvisited);
  }

}
class RoutbNodes{
  public static void main(String args[]){
    Grprbn gp = new Grprbn();
    gp.addEdge(1,2);
    gp.addEdge(1,3);
    gp.addEdge(2,4);
    gp.addEdge(2,5);
    gp.addEdge(5,6);
    gp.addEdge(6,3);
    gp.addEdge(6,1);

    gp.getRoute(2,3);
  }
}
