import java.util.*;
import java.lang.*;

class Node{
  int val;
  Node right;
  Node left;

  Node(int val){
    this.val = val;
    this.right = null;
    this.left = null;
  }

  @Override
  public String toString(){
    return String.valueOf(this.val);
  }
}
class Solution{
  Node root;

  Solution(){
    root = null;
  }

  Node createNode(int val){
    return new Node(val);
  }

  Node add(Node node, int val){
    if(node == null){
      return createNode(val);
    }

    if(val > node.val){
      node.right = add(node.right, val);
    }
    else{
      node.left = add(node.left, val);
    }
    return node;
  }

  void add(int val){
    root = add(root, val);
  }

  void levelLLBFS(){
    LinkedList<LinkedList<Node>> retList = new LinkedList<>();
    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    retList.add(new LinkedList<>(Arrays.asList(root)));
    while(!qu.isEmpty()){
      LinkedList<Node> clist = new LinkedList<>();

      while(!qu.isEmpty()){
        Node pnode = qu.poll();
        if(pnode.left != null)
          clist.add(pnode.left);
        if(pnode.right != null)
          clist.add(pnode.right);
      }

      if(!clist.isEmpty()){
        qu.addAll(clist);
        retList.add(clist);
      }
    }

    for(LinkedList<Node> clist : retList){
      System.out.println(clist);
    }
  }

  void levelDFS(Node node, TreeMap<Integer, LinkedList<Node>> ret, int lvl){
    if(node == null){
      return;
    }

    LinkedList<Node> lvlList = ret.getOrDefault(lvl, new LinkedList<>());
    lvlList.add(node);
    ret.put(lvl, lvlList);

    levelDFS(node.left, ret, lvl+1);
    levelDFS(node.right, ret, lvl+1);
  }

  void levelLLDFS(){
    TreeMap<Integer, LinkedList<Node>> retList = new TreeMap<>();
    levelDFS(root, retList, 0);
    for(int key : retList.keySet()){
      System.out.println(retList.get(key));
    }
  }
}

class LevelDepthList{
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.add(5);
    sol.add(8);
    sol.add(3);
    sol.add(2);
    sol.add(4);
    sol.add(7);
    sol.add(9);
    sol.add(6);

    int strt = (int)System.nanoTime();
    sol.levelLLBFS();
    int end = (int)System.nanoTime();
    System.out.println("BFS Time: "+(end-strt));

    strt = (int)System.nanoTime();
    sol.levelLLDFS();
    end = (int)System.nanoTime();
    System.out.println("DFS Time: "+(end-strt));

  }
}
