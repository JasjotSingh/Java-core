import java.util.*;

class Node {
  int val;
  Node left;
  Node right;

  Node(int val){
    this.val = val;
    this.left = null;
    this.right = null;
  }

  int getVal(){
    return this.val;
  }

  Node getLeft(){
    return this.left;
  }

  Node getRight(){
    return this.right;
  }

  void setVal(int val){
    this.val = val;
  }

  void setLeft(Node node){
    this.left = node;
  }

  void setRight(Node node){
    this.right = node;
  }
}

class Solution{
  Node root;

  Solution(){
    root = null;
  }
/// add Node begin
  private Node addNode(int val, Node node){
    if(node == null){
      return new Node(val);
    }

    if(val > node.getVal()){
      node.setRight(addNode(val, node.getRight()));
    }
    else{
      node.setLeft(addNode(val, node.getLeft()));
    }
    return node;
  }

  void addVal(int val){
    root = addNode(val, root);
  }
/// add Node end.

/// remove node begin

  private int getRightMinValue(Node node){
    while(node.getLeft() != null){
      node = node.getLeft();
    }
    return node.getVal();
  }

  private Node removeNode(int val, Node node){
    if(node == null)
      return null;

    if(val == node.getVal()){
      if(node.getLeft() == null && node.getRight() == null){
        return null;
      }
      else if(node.getRight() == null){
        return node.getLeft();
      }
      else if(node.getLeft() == null){
        return node.getRight();
      }
      else{
        int rightMinValue = getRightMinValue(node.getRight());
        node.setVal(rightMinValue);
        node.setRight(removeNode(rightMinValue, node.getRight()));
      }
    }
    else if(val > node.getVal()){
      node.setRight(removeNode(val, node.getRight()));
    }
    else{
      node.setLeft(removeNode(val, node.getLeft()));
    }
    return node;
  }

  void removeVal(int val){
    root = removeNode(val, root);
  }

/// remove node end

/// inorder begin

  private void inorder(Node node){
    if(node == null){
      return;
    }

    inorder(node.getLeft());
    System.out.print(node.getVal()+" ");
    inorder(node.getRight());
  }

  void inorder(){
    System.out.println("\nIn Order:");
    inorder(root);
    System.out.println("");
  }
/// inorder end

/// preorder begin

  private void preorder(Node node){
    if(node == null){
      return;
    }

    System.out.print(node.getVal()+" ");
    preorder(node.getLeft());
    preorder(node.getRight());
  }

  void preorder(){
    System.out.println("\nPre Order:");
    preorder(root);
    System.out.println("");
  }
/// preorder end

/// postorder begin

  private void postorder(Node node){
    if(node == null){
      return;
    }

    postorder(node.getLeft());
    postorder(node.getRight());
    System.out.print(node.getVal()+" ");
  }

  void postorder(){
    System.out.println("\nPost Order:");
    postorder(root);
    System.out.println("");
  }
/// preorder end

/// BFSorder begin

  void BFSorder(){
    System.out.println("\nBFS Order:");

    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    while(!qu.isEmpty()){
      Node node = qu.poll();
      System.out.print(node.getVal()+" ");

      if(node.getLeft() != null){
        qu.offer(node.getLeft());
      }
      if(node.getRight() != null){
        qu.offer(node.getRight());
      }
    }

    System.out.println("");
  }

/// BFSorder end

/// level Order begin

  void levelOrder(){
    System.out.println("\nLevel Order:");

    Queue<Node> qu = new LinkedList<>();
    qu.add(root);

    while(!qu.isEmpty()){
      Queue<Node> subqu = new LinkedList<>();
      while(!qu.isEmpty()){
        Node node = qu.poll();
        System.out.print(node.getVal()+" ");
        if(node.getLeft() != null){
          subqu.offer(node.getLeft());
        }
        if(node.getRight() != null){
          subqu.offer(node.getRight());
        }
      }
      qu.addAll(subqu);
      System.out.println("");
    }

    System.out.println("");
  }

/// level Order end

/// balance tree begin.

  private int isBalanced(Node node){
    if(node == null){
      return 0;
    }

    int left = isBalanced(node.getLeft());
    if(left == -1)
      return -1;

    int right = isBalanced(node.getRight());
    if(right == -1)
      return -1;

    int diff = Math.abs(right - left);
    return diff > 1 ? -1 : Math.max(right, left)+1;

  }

  private void balance(ArrayList<Integer> ar, int st, int en){
    if(st <= en){
      int mid = st+(en-st)/2;
      addVal(ar.get(mid));
      balance(ar,st,mid-1);
      balance(ar,mid+1,en);
    }
  }

  private void sortNodeVal(ArrayList<Integer> ar, Node node){
      if(node == null)
        return;

      sortNodeVal(ar,node.getLeft());
      ar.add(node.getVal());
      sortNodeVal(ar,node.getRight());
  }

  void balanced(){
    if(isBalanced(root) >= 0){
      System.out.println("Tree is balanced.");
    }
    else{
      ArrayList<Integer> nodeVal = new ArrayList<>();
      sortNodeVal(nodeVal, root);
      root = null;
      balance(nodeVal, 0, nodeVal.size()-1);
      System.out.println("Tree not balanced, balancing tree.......\nBalancedTree:");
      levelOrder();
    }
  }

/// balance tree end.

/// lowestCommonAncestor

  private int lowestCommonAncestor(int val1, int val2, Node node){
    if(node == null){
      return -1;
    }

    if(node.getVal() == val1 || node.getVal() == val2)
      return node.getVal();

    int left = lowestCommonAncestor(val1, val2, node.getLeft());
    int right = lowestCommonAncestor(val1, val2, node.getRight());

    if(left != -1 && right != -1)
      return node.getVal();

    return left != -1 ? left : right != -1 ? right : -1;

  }

  void getLowestCommonAncestor(int val1, int val2){
    int LCA = lowestCommonAncestor(val1, val2, root);

    System.out.println("Lowest Common Ancestor for : "+val1+" and "+val2+":\n"+LCA);
  }

/// lowestCommonAncestor

/// getBetween

  void getBetween(int v1, int v2){
    ArrayList<Integer> ar = new ArrayList<>();
    Queue<Node> qu = new LinkedList<>();

    qu.add(root);

    while(!qu.isEmpty()){
      Node node = qu.poll();

      if(v1 <= node.getVal() && node.getVal() <= v2){
        ar.add(node.getVal());
        if(node.getRight() != null)
          qu.offer(node.getRight());
        if(node.getLeft() != null)
          qu.offer(node.getLeft());
      }

      else if(node.getVal() < v1){
        if(node.getRight() != null)
          qu.offer(node.getRight());
      }
      else if(v2 < node.getVal()){
        if(node.getLeft() != null)
          qu.offer(node.getLeft());
      }
    }
    System.out.println("values between "+v1+" and "+v2+" :");
    for(int x : ar){
      System.out.print(x+" ");
    }
    System.out.println("");
  }

/// getBetween
}

class BST{
  public static void main(String args[]){
    Solution sol = new Solution();
    sol.addVal(10);
    sol.addVal(15);
    sol.addVal(5);
    sol.addVal(13);
    sol.addVal(7);
    sol.addVal(17);
    sol.addVal(3);
    sol.addVal(20);
    sol.addVal(0);
    sol.addVal(16);
    sol.addVal(2);
    sol.addVal(11);

    sol.inorder();
    sol.preorder();
    sol.postorder();
    sol.BFSorder();
    sol.levelOrder();

    sol.balanced();
    sol.getLowestCommonAncestor(2,7);
    sol.getBetween(7,16);
  }
}
