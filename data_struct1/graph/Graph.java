import java.util.*;

class GraphUtil{

  enum state{
    UNVISITED, VISITED, WALKING;
  }

  HashMap<Integer, List<Integer>> graph;
  HashMap<Integer, state> nodeState;  //for DL detection.
  HashSet<Integer> seenState; //for DFS, BFS topo.

  GraphUtil(){
    graph = new HashMap<>();
    nodeState = new HashMap<>();
    seenState = new HashSet<>();
  }

  //for DL need to create a DAC (directed acyclic graph) graph
  public void addEdge(int v1, int v2){
    if(graph.containsKey(v1)){
      //contains key.
      List<Integer> alist= graph.get(v1);
      alist.add(v2);
    }
    else{
      //does not contain key.
      List<Integer> alist = new ArrayList<>();
      alist.add(v2);
      graph.put(v1, alist);
    }

    nodeState.put(v1, state.UNVISITED);
    nodeState.put(v2, state.UNVISITED);
  }

  public void display(){
    System.out.println(graph);
    System.out.println(nodeState);
  }

  public void markUnvisited(){
    //mark all nodes as unvisited.
    //used to detect dl.
    for(int key: nodeState.keySet()){
      nodeState.put(key, state.UNVISITED);
    }

    //clear out seenstate hashset.
    //used to find topo sort DFS, BFS.
    seenState.clear();
  }

  private boolean dfsDL(int key){
      if(nodeState.get(key) == state.WALKING){
        System.out.println("deadlock found at : "+key);
        return true;
      }

      nodeState.put(key, state.WALKING);
      List<Integer> alist = graph.get(key);
      if(alist != null){
        for(int cnode: alist){
          if(nodeState.get(cnode) != state.VISITED && dfsDL(cnode)){
            System.out.println("deadlock begin at : "+key);
            return true;
          }
        }
      }

      nodeState.put(key, state.VISITED);
      return false;
  }

  public void findDL(){
    markUnvisited();

    for(int key: graph.keySet()){
      if(nodeState.get(key) == state.UNVISITED && dfsDL(key)){
        System.out.println("dead lock exists. starting node: "+key);
        return;
      }
    }
    System.out.println("no dead lock found");
    return;
  }

  private void DFS(int key, List<Integer> topo){
    seenState.add(key);
    List<Integer> alist = graph.get(key);
    if(alist != null){
      for(int cnode: alist){
        if(!seenState.contains(cnode)){
          DFS(cnode, topo);
        }
      }
    }
    topo.add(key);
    return;
  }

  public void getDFS(){
    markUnvisited();

    //list to get topoloical order.
    List<Integer> topo = new ArrayList<>();
    for(int key: graph.keySet()){
      if(!seenState.contains(key)){
        DFS(key, topo);
      }
    }

    Collections.reverse(topo);
    System.out.println("Topo : "+topo);
    return;
  }

  private void BFS(int key, List<Integer> topo){

    Queue<Integer> qu = new LinkedList<>();
    qu.offer(key);
    seenState.add(key);
    topo.add(key);

    while(!qu.isEmpty()){
      int pnode = qu.poll();
      List<Integer> alist = graph.get(pnode);
      if(alist != null){
        for(int cnode: alist){
          if(!seenState.contains(cnode)){
            qu.offer(cnode);
            seenState.add(cnode);
            topo.add(cnode);
          }
        }
      }
    }
  }

  public void getBFS(){
    //can not get a valid topoloical order with BFS.
    markUnvisited();

    //list to get BFS display.
    List<Integer> topo = new ArrayList<>();

    for(int key: graph.keySet()){
      if(!seenState.contains(key)){
        BFS(key, topo);
      }
    }

    System.out.println("BFS Topo : "+topo);
    return;
  }

  private void DFS(int key){
      //seenState.add(key);
      nodeState.put(key, state.VISITED);
      List<Integer> alist = graph.get(key);
      if(alist != null){
        for(int cnode: alist){
          if(nodeState.get(cnode) != state.VISITED)
            DFS(cnode);
        }
      }
  }

  //+++++IMP+++++++
  //there can be multiple mother nodes.
  public void getMother(){
    //++++++++IMP++++++++++++//
    //can not use seenState, since graph may contain some node that are only child and not parents.
    //so seenSatate will have greater size. rather use nodeState hashmap to make sure all nodes have
    //seen state.
    markUnvisited();

    int motherNode = 999;

    for(int key: graph.keySet()){
      if(nodeState.get(key) != state.VISITED){
        DFS(key);
        motherNode = key;
      }
    }

    //last key to finish can be a mother node.
    //checl to make sure that all nodes can be reached from this node.
    markUnvisited();
    System.out.println(motherNode);
    DFS(motherNode);

    //++++++++IMP++++++++++++//
    //can not do this. since graph may contain some node that are only child and not parents.
    //so seenSatate will have greater size. rather use nodeState hashmap to make sure all nodes have
    //seen state.
    // if(seenState.size() == graph.size()){
    //   //all grpah nodes were seen so this is a mother node.
    //   System.out.println(motherNode+" is mother node.");
    // }
    // else{
    //   //if lengths are not same, then some nodes were not reached.
    //   System.out.println("no mother node exists.");
    // }

    for(int key: nodeState.keySet()){
      if(nodeState.get(key) != state.VISITED){
        System.out.println("no mother node exists.");
        return;
      }
    }
    System.out.println(motherNode+" is mother node.");
  }
}


class Graph{
  public static void main(String args[]){
    GraphUtil gra = new GraphUtil();
    gra.addEdge(0, 1);
    gra.addEdge(0, 4);
    gra.addEdge(1, 2);
    gra.addEdge(1, 3);
    gra.addEdge(1, 4);
    // gra.addEdge(2, 1);
    gra.addEdge(2, 3);
    //gra.addEdge(3, 2);
    gra.addEdge(3, 4);
    gra.addEdge(4, 0);
    gra.addEdge(4, 1);
    // gra.addEdge(9,6);
    // gra.addEdge(9,8);
    // gra.addEdge(8,10);


    gra.display();

    gra.findDL();
    gra.getDFS();
    gra.getBFS();
    gra.getMother();
  }
}
