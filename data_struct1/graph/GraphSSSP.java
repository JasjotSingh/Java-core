import java.util.*;
class Node{
  String node;
  int weight;

  Node(String node, int weight){
    this.node = node;
    this.weight = weight;
  }

  @Override
  public String toString(){
    return "{node: "+this.node+", weight: "+this.weight+"}";
  }
}

class GraphUtil{
  HashMap<String, List<Node>> graph;
  HashMap<String, Integer> dist;
  HashSet<String> seen;

  GraphUtil(){
    graph = new HashMap<>();
    dist = new HashMap<>();
    seen = new HashSet<>();
  }

  public void display(){
    System.out.println(graph);
  }
  public void addEdge(String v1, String v2, int weight){
    if(graph.containsKey(v1)){
      List<Node> alist = graph.get(v1);
      Node newNode = new Node(v2, weight);
      alist.add(newNode);
    }
    else{
      List<Node> alist = new ArrayList<>();
      Node newNode = new Node(v2, weight);
      alist.add(newNode);
      graph.put(v1, alist);
    }

    dist.put(v1, Integer.MAX_VALUE);
    dist.put(v2, Integer.MAX_VALUE);
  }

  private void clearSeen(){
    seen.clear();
  }

  private void DFS(String key, List<String> topo){
    seen.add(key);
    List<Node> alist = graph.get(key);
    if(alist != null){
      for(Node node: alist){
        if(!seen.contains(node.node)){
          DFS(node.node, topo);
        }
      }
    }
    topo.add(key);
  }

  public List<String> getTopo(){
      List<String> topo = new ArrayList<>();
      clearSeen();

      for(String key : graph.keySet()){
        if(!seen.contains(key)){
          DFS(key, topo);
        }
      }
      Collections.reverse(topo);
      return topo;
  }

  public void SSSPAlgo(String strtNode){
    //get topological sort order.
    List<String> topo = getTopo();
    System.out.println(topo);

    //set the distan ce of strt node to 0, since it will be 0 from itself.
    dist.put(strtNode , 0);

    //now walk over the elements in topological order.
    //becase we can only reach elemts after the strt element in topological ordering.
    for(String key : topo){
      if(dist.get(key) != Integer.MAX_VALUE){
        List<Node> alist = graph.get(key);
        if(alist != null){
          for(Node node: alist){
            int newdist = dist.get(key) + node.weight;
            if(newdist < dist.get(node.node))
              dist.put(node.node, newdist);
          }
        }
      }
    }

    for(String nodeVal : dist.keySet()){
      System.out.println(nodeVal + " "+dist.get(nodeVal));
    }
  }
}

class GraphSSSP{
  //
  public static void main(String[] args) {
    GraphUtil gra = new GraphUtil();
    gra.addEdge("a", "b", 3);
    gra.addEdge("a", "c", 6);
    gra.addEdge("b", "c", 4);
    gra.addEdge("b", "d", 4);
    gra.addEdge("b", "e", 11);
    gra.addEdge("c", "d", 8);
    gra.addEdge("c", "g", 11);
    gra.addEdge("d", "e", -4);
    gra.addEdge("d", "f", 5);
    gra.addEdge("d", "g", 2);
    gra.addEdge("e", "h", 9);
    gra.addEdge("f", "h", 1);
    gra.addEdge("g", "h", 2);

    gra.display();

    gra.SSSPAlgo("d");
  }
}
