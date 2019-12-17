import java.util.*;
import java.lang.*;

class btree2{
  class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
      this.val = val;
      this.left = null;
      this.right = null;
    }
    @Override
    public String toString(){
      return String.valueOf(this.val);
    }
  }
  Node root;
  btree2(){
    root = null;
  }

  //get inorder arraylist
  void inorder(Node node, List<Integer> ar){
    if(node == null)
      return;
    inorder(node.left,ar);
    ar.add(node.val);
    inorder(node.right,ar);
  }
  //get inorder arraylist
  List<Integer> inorder(){
    List<Integer> ar = new ArrayList<>();
    inorder(root,ar);
    return ar;
  }

  //add node to tree.
  Node add(Node node, int val){
    if(node == null){
      return new Node(val);
    }
    if(val > node.val){
      node.right = add(node.right, val);
    }
    else{
      node.left = add(node.left, val);
    }
    return node;
  }
  //add node to tree.
  void addNode(int val){
    root = add(root,val);
  }

  //get left most node.
  int getLeftNode(Node node){
    while(node.left != null){
      node = node.left;
    }
    return node.val;
  }
  //remove Node
  Node remNode(Node node, int val){
    if(node == null){
      System.out.println("Node not found");
    }
    else{
      if(val == node.val){
        if(node.left != null && node.right != null){
          int smallest = getLeftNode(node.right);
          node.val = smallest;
          node.right = remNode(node.right, smallest);
        }
        else if(node.right != null && node.left == null)
          return node.right;
        else if(node.left != null && node.right == null)
          return node.left;
        else if(node.left == null && node.right == null)
          return null;
      }
      else if(val > node.val)
        node.right = remNode(node.right, val);
      else
        node.left = remNode(node.left, val);
    }
    return node;
  }

  //remove node.
  void removeNode(int val){
      System.out.println("\ndelete: "+val);
      root = remNode(root, val);
  }

  //get tree as level order.
  void getLevelOrder(){
    Queue<Node> qu = new LinkedList<>();
    ArrayList<ArrayList<Node>> lvlst = new ArrayList<>();

    qu.offer(root);
    while(!qu.isEmpty()){
      lvlst.add(new ArrayList<>(qu));
      Queue<Node> qu1 = new LinkedList<>();
      while(!qu.isEmpty()){
        Node node = qu.poll();
        if(node.left != null)
          qu1.offer(node.left);
        if(node.right != null)
          qu1.offer(node.right);
      }
      qu.addAll(qu1);
    }

    //display lvl ord
    System.out.println("\nlvl order:");
    for(List<Node> ar: lvlst)
      System.out.println(ar);
  }

  void bst(){
    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    System.out.println("\nbst:");
    while(!qu.isEmpty()){
      Node node = qu.poll();
      System.out.print(node.val+" ");
      if(node.left != null)
        qu.offer(node.left);
      if(node.right != null)
        qu.offer(node.right);
    }
    System.out.println("");
  }

  //get all nums between i,j.
  void getBetween(int i, int j){
    Queue<Node> qu = new LinkedList<>();
    ArrayList<Integer> ar = new ArrayList<>();

    qu.offer(root);

    while(!qu.isEmpty()){
      Node node = qu.poll();
      if(node.val >=i && node.val <=j){
        ar.add(node.val);

        if(node.left != null){
          qu.offer(node.left);
        }
        if(node.right != null){
          qu.offer(node.right);
        }
      }
      else if(node.val < i && node.right != null){
        qu.offer(node.right);
      }
      else if(node.val > j && node.left != null){
        qu.offer(node.left);
      }
    }
    System.out.println("\nPrnt between: "+i+", "+j);
    System.out.println(ar);
  }

  //get max depth of tree.
  int maxDepth(Node node){
    if(node == null)
      return 0;
    int left = maxDepth(node.left);
    int right = maxDepth(node.right);

    return Math.max(left,right)+1;
  }
  //get max depth of tree.
  void maxDepth(){
    int ret =  maxDepth(root);
    System.out.println("\nMax depth: "+ret);
  }

  //ge lca
  int getLCA(Node node, int i, int j){
    if(node == null)
      return -1;

    if(node.val == i || node.val == j)
      return node.val;

    int left = getLCA(node.left, i, j);
    int right = getLCA(node.right, i, j);

    if(left != -1 && right != -1)
      return node.val;

    return left != -1 ? left: right != -1 ?right: -1;
  }
  //get lca
  void getLCA(int i, int j){
    int ret = getLCA(root, i, j);
    System.out.println("\nLCA for "+i+", "+j+" :"+ret);
  }

  //see if tree is balanced.
  int isBalanced(Node node){
    if(node == null)
      return 0;

    int left = isBalanced(node.left);
    if(left < 0)
      return left;
    int right = isBalanced(node.right);
    if(right < 0)
      return right;

    if(Math.abs(right - left) > 1)
      return -1;

    return Math.max(left,right)+1;
  }

  void balance(List<Integer> ar, int strt, int en){
    if(strt <= en){
      int mid = strt+(en-strt)/2;
      addNode(ar.get(mid));
      balance(ar,strt,mid-1);
      balance(ar,mid+1,en);
    }
  }
  //see if tree is balanced.
  void isBalanced(){
    if(isBalanced(root) > 0){
      System.out.println("\ntree balanced");
    }
    else{
      System.out.println("\nnot balanced, balancing ....");
      List<Integer> ar = inorder();
      root = null;
      balance(ar,0,ar.size()-1);
    }
  }
}

class treeMain2{
  public static void main(String args[]){
    btree2 tre = new btree2();
    tre.addNode(15);
    tre.addNode(17);
    tre.addNode(16);
    tre.addNode(18);
    tre.addNode(19);
    tre.addNode(13);
    tre.addNode(14);
    tre.addNode(12);
    tre.addNode(11);
    tre.addNode(10);

    List<Integer> ar = tre.inorder();
    System.out.println(ar);

    tre.getLevelOrder();
    tre.bst();

    tre.getBetween(14,16);
    tre.maxDepth();
    tre.removeNode(15);
    tre.removeNode(17);
    tre.getLevelOrder();

    tre.getLCA(18,19);

    tre.isBalanced();
    tre.getLevelOrder();
    tre.isBalanced();
    
  }
}
