import java.util.*;

public class Graph{
  HashMap<Integer, ArrayList<Integer>> graph;
  HashSet<Integer> acySeen;
  HashMap<Integer,Integer> cySeen;

  Graph(){
    graph = new HashMap<>();
    acySeen = new HashSet<>();
    cySeen = new HashMap<>();
  }

  void addNodeDirected(int v1, int v2){
    if(graph.containsKey(v1)){
      graph.get(v1).add(v2);
    }
    else{
      graph.put(v1, new ArrayList<>(Arrays.asList(v2)));
    }

    cySeen.put(v1, 0);
    cySeen.put(v2, 0);
  }

  void addNodeUndirected(int v1, int v2){
    if(graph.containsKey(v1)){
      graph.get(v1).add(v2);
    }
    else{
      graph.put(v1, new ArrayList<>(Arrays.asList(v2)));
    }

    if(graph.containsKey(v2)){
      graph.get(v2).add(v1);
    }
    else{
      graph.put(v2, new ArrayList<>(Arrays.asList(v1)));
    }

    cySeen.put(v1, 0);
    cySeen.put(v2, 0);
  }

  void displayGraph(){
    System.out.println("\nGraph :\n"+graph);
  }

  void displaySeen(){
    System.out.println("\nAcyclic seen :\n"+acySeen);
    System.out.println("\nCyclic seen :\n"+cySeen);
  }

  void clearSeen(){
    acySeen.clear();

    if(graph.size() > 0){
      for(int key: graph.keySet()){
        cySeen.put(key, 0);
      }
    }
    else{
      cySeen.clear();
    }
  }
}
