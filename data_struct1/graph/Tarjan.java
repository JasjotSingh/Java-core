import java.util.*;

class Node<T>{
  T val;
  int weight;

  Node(T val, int weight){
    this.val = val;
    this.weight = weight;
  }

  @Override
  public String toString(){
    return "Val: "+this.val+", Weight: "+this.weight;
  }
}

class Solution <T>{
  HashMap<T, List< Node<T> > > graph;
  HashSet<T> seen;
  HashMap<T, Integer> nodeIds;
  HashMap<T, Integer> nodeLinkVals;
  int initId;

  Solution(){
    graph = new HashMap<>();
    seen = new HashSet<>();
    nodeIds = new HashMap<>();
    nodeLinkVals = new HashMap<>();
    initId = 0;

  }

  public void addEdge (T v1, T v2, int weight){
    List< Node<T> > alist = graph.getOrDefault(v1, null);

    if(alist == null){
      alist = new ArrayList<>();
      alist.add(new Node<T>(v2, weight));
      graph.put(v1, alist);
    }
    else{
      alist.add(new Node<T>(v2, weight));
    }
  }

  public void display(){
    System.out.println(graph);
  }

  private void dfs(Stack<T> stk, T key){
    seen.add(key);
    stk.push(key);
    nodeIds.put(key, initId);
    //increment init id after adding lowlink val,
    //so that next key gets new value.
    nodeLinkVals.put(key, initId++);

    List<Node<T>> alist = graph.getOrDefault(key, null);

    if(alist != null){
      for(Node<T> childNode : alist){
        //IMP vvvvvvvvvvvv
        //in case of a undirected graph. need to do following, other wise,
        //whole graph will end up having same lowlink value.
        //since all nodes can reach anyother node in undirected graph.
        //CODE NOTE = will need to send parent in each dfs iteration.
        // if(childNode.val == parent)
        //   continue;

        if(!seen.contains(childNode.val)){
          dfs(stk, childNode.val);
        }
        //if child is on stk and
        //if childs lowlink is lower, update parents lowlink to be same.
        if(stk.contains(childNode.val) &&  nodeLinkVals.get(key) > nodeLinkVals.get(childNode.val)){
          nodeLinkVals.put(key, nodeLinkVals.get(childNode.val));
        }
      }
    }
    //if parents id and lowlink are same, means we are at root of
    //strongly connected component. remove all comp above key in stk.
    //since they should be added in stk after key and have lowlink val of key.
    //if no circle was found, then key should already be top value , so only
    //key gets removed, all other nodes after key would have been removed,
    //since there lowlink val will be same as there id.
    if(nodeIds.get(key) == nodeLinkVals.get(key)){
      while(stk.size() > 0 && stk.pop() != key){
        continue;
      }
    }
  }

  public void Tarjans(){
    //create stack of ids to keep track of weather lowlink val should be updated.
    Stack<T>  stk = new Stack<>();

    // //optional step create a graph with llink : list<nodes>
    // // all nodes associated with one lolink val, i.e strongly connected.
    // HashMap<Integer, List>

    for(T key: graph.keySet()){
      if(!seen.contains(key)){
        dfs(stk, key);
      }
    }

    System.out.println("\nLowLink: ");
    System.out.println(nodeLinkVals);
    System.out.println("\nIDS: ");
    System.out.println(nodeIds);
  }
}

class Tarjan{
  public static void main(String[] args) {
    Solution<Integer> g = new Solution<>();
    g.addEdge(10,11,0);
    g.addEdge(11,12,0);
    g.addEdge(12,10,0);
    g.addEdge(16,10,0);
    g.addEdge(16,12,0);
    g.addEdge(16,14,0);
    g.addEdge(15,10,0);
    g.addEdge(13,14,0);
    g.addEdge(13,17,0);
    g.addEdge(15,16,0);
    g.addEdge(14,15,0);
    g.addEdge(17,15,0);
    g.addEdge(17,13,0);
    //g.addEdgeDouble(17,18,0);

    System.out.println("\nTarjans Algo :");
    g.display();
    g.Tarjans();
  }
}
