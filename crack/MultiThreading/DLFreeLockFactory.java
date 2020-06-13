import java.util.*;


//below is better implementation than leetcode.

class DLFreeLockFactory1<T, N>{


  DependencyGraph<N> dgraph;

  DLFreeLockFactory1(){
    dgraph = new DependencyGraph<>();
  }
  //function, where use declares the locks it needs.
  public Boolean requestResource(T reqId, N[] reqLock){
    //possible set of inputs.
    // thread_1 = {11,12,13,14}
    // thread_2 = {11,13,15}
    // thread_3 = {17,15,19,12}
    //11 -> 12, 13
    //12 -> 13
    //13 -> 14, 15
    //15 -> 19
    //17 -> 15
    //19 -> 12
    //reqId only needed for later purposes, reqLock needed for deadlock check.

    //mark all nodes unvisited in dgraph.
    dgraph.markAllUnvisited();

    //go over reqLock to create dependencygraph.
    //dont have to worry about red with just one dependency, can not cause dl.
    for(int i = 0 ; i < reqLock.length -1; i++){
      N parent = reqLock[i];
      N child = reqLock[i+1];
      dgraph.addEdge(parent, child);
    }

    dgraph.display();

    //look for deadlock.
    if(dgraph.hasDeadLock()){
      //if dl return false.
      //can write a remove loop here.
      //since we have list in graph, in case 11 -> 22 comes in tice.
      //graph will have 11 : [22,22], so we can remove exact same values from it.
      //in case there is a dl.
      //issue - duplicate child for a preant :
      //we can change list to hashset, but then we can nor perform remove operation.
      //instead we can may be make a copy of graph in begning.
      //if no dl, replace the actual graph with temp graph with new values.
      //else disregard the temp graph.
      System.out.println("False");
      return false;
    }
    else{
      //else true.
      System.out.println("True");
      return true;
    }


  }
}

class DependencyGraph<N>{
  enum state{VISITED, UNVISITED, WALKING};
  HashMap<N , List<N>> dependencyGraph;
  HashMap<N, state> nodeState;

  DependencyGraph(){
    dependencyGraph = new HashMap<>();
    nodeState = new HashMap<>();
  }



  public void addEdge(N node1, N node2){
    List<N> alist = dependencyGraph.getOrDefault(node1, null);
    if(alist == null){
      alist = new ArrayList<>();
      alist.add(node2);
      dependencyGraph.put(node1,alist);
    }
    else{
      alist.add(node2);
    }
    nodeState.put(node1, state.UNVISITED);
    nodeState.put(node2, state.UNVISITED);
  }

  public void markAllUnvisited(){
    for(N node : nodeState.keySet()){
      nodeState.put(node, state.UNVISITED);
    }
  }

  public Boolean hasDeadLock(){
    for(N pNode : dependencyGraph.keySet()){
      if(nodeState.get(pNode) == state.UNVISITED && dfsDL(pNode)){
        return true;
      }
    }
    return false;
  }

  private Boolean dfsDL( N pNode){
    if(nodeState.get(pNode) == state.WALKING){
      return true;
    }
    else if(nodeState.get(pNode) == state.VISITED){
      return false;
    }

    nodeState.put(pNode, state.WALKING);
    List<N> alist = dependencyGraph.getOrDefault(pNode, null);
    if(alist != null){
      for(N childNode : alist){
        if(dfsDL(childNode)){
          return true;
        }
      }
    }
    nodeState.put(pNode, state.VISITED);
    return false;
  }

  public void display(){
    System.out.println(dependencyGraph);
  }

}

class DLFreeLockFactory{
  public static void main(String[] args) {
    DLFreeLockFactory1<String, Integer> df = new DLFreeLockFactory1<>();
    Integer ar[] = {11,12,13,14};
    df.requestResource("Thread1", ar);
    // Integer ar1[] = {11,13,15};
    // df.requestResource("Thread1", ar1);
    Integer ar1[] = {11,13,12};
    df.requestResource("Thread1", ar1);
    // Integer ar2[] = {17,15,19,12};
    // df.requestResource("Thread1", ar2);

  }
}
