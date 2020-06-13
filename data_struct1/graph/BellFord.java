import java.util.*;

//class Node in Dijk.java.

class Solution{
  HashMap<Integer, List<Node>> graph;
  HashMap<Integer, Node> dlist;

  Solution(){
    graph = new HashMap<>();
    dlist = new HashMap<>();
  }
  public void addEdge(int from, int to, int cost){
    if(graph.containsKey(from)){
      graph.get(from).add(new Node(to, cost));
    }
    else{
      List<Node> alist = new ArrayList<>();
      alist.add(new Node(to, cost));
      graph.put(from, alist);
    }
    dlist.put(from, new Node(to, Integer.MAX_VALUE));
    dlist.put(to, new Node(from, Integer.MAX_VALUE));
  }

  public void display(){
    System.out.println(graph);
  }

  public void bellford(List<Integer> nlist, int strt){

    //set strt node dist to 0.
    dlist.put(strt, new Node(strt, 0));

    // iterate over all edges nlist.size() -1 times (8 times 0-7 = 8). and relax edges.
    for(int i =1 ; i < nlist.size(); i++){
      for(int key : nlist){
        //same as SSSP vvvvvvvv///
        int pcost = dlist.get(key).cost;
        if(pcost != Integer.MAX_VALUE){
          List<Node> alist = graph.get(key);
          if(alist != null){
            for(Node cnode: alist){
              int edgeCost = cnode.cost;
              int dist = dlist.get(cnode.val).cost;
              if(dist > pcost+edgeCost){
                Node node = dlist.get(cnode.val);
                node.val = key;
                node.cost = pcost+edgeCost;
              }
            }
          }
        }
        //same as SSSP ^^^^^^^^^^///
      }
    }
    for(int key: dlist.keySet()){
      System.out.println(key+" : "+dlist.get(key));
    }
    for(int i =1 ; i < nlist.size(); i++){
      for(int key : nlist){
        List<Node> alist = graph.get(key);
        if(alist != null){
          for(Node cnode: alist){
            int edgeCost = cnode.cost;
            int pcost = dlist.get(key).cost;
            int dist = dlist.get(cnode.val).cost;
            if(pcost != Integer.MAX_VALUE && dist > pcost+edgeCost){
              Node node = dlist.get(cnode.val);
              node.val = key;
              node.cost = -9999;
            }
          }
        }
      }
    }
    System.out.println("\n\nNegative cycle:");
    for(int key: dlist.keySet()){
      System.out.println(key+" : "+dlist.get(key));
    }
  }
}


class BellFord{
  public static void main(String[] args) {
    Solution g = new Solution();

    g.addEdge(0,1,5);
    g.addEdge(1,2,20);
    g.addEdge(1,5,30);
    g.addEdge(1,6,60);
    g.addEdge(2,3,10);
    g.addEdge(3,2,-15);
    g.addEdge(2,4,75);
    g.addEdge(4,9,100);
    g.addEdge(5,4,25);
    g.addEdge(5,8,50);
    g.addEdge(5,6,5);
    g.addEdge(6,7,-50);
    g.addEdge(7,8,-10);

    g.display();

    System.out.println("\nShortest Paths BELL: ");
    ArrayList<Integer> nlist = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    //can also pass in topological order. instead of nlist.
    g.bellford(nlist, 0);
  }
}
