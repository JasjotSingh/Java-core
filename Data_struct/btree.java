import java.util.*;
import java.lang.Math;
class Tree{
  class Node{
    int num;

    Node left;
    Node right;
  }

  Node root = null;

  //create node --
  private Node create(int val){
    Node ne = new Node();
    ne.num = val;
    ne.left = null;
    ne.right = null;
    return ne;
  }

  //add ndoe --
  void add(int val){
    if(root == null){
      root = create(val);
    }
    else{
      Node ne = addNode(root,val);
    }
  }

  //add node --
  private Node addNode(Node node, int val){
    if(node == null){
      return create(val);
    }
    if(val > node.num){
      node.right = addNode(node.right, val);
    }
    else{
      node.left = addNode(node.left, val);
    }
    return node;
  }

  //find min left node --
  Node findLeftNode(Node node){
    while(node.left != null){
      node = node.left;
    }
    return node;
  }

  //remove node --
  Node removeNode(int val, Node node){
      if(node == null){
        return node;
      }
      if(node.num == val ){
        System.out.println("found "+val);
        if(node.right != null){
          Node ndel = findLeftNode(node.right);
          node.num = ndel.num;
          node.right = removeNode(ndel.num,node.right);
        }
        else if(node.left != null){
          return node.left;
        }
        else{
          return null;
        }
      }
      else if(val > node.num){
        System.out.println("right "+val);
        node.right = removeNode(val,node.right);
      }
      else{
        System.out.println("left "+val);
        node.left = removeNode(val,node.left);
      }
      return node;
  }

  //remove node --
  void remove(int val){
    if(root == null){
      System.out.println("tree empty");
    }
    else{
      root = removeNode(val,root);
    }
  }

  //see if tree is balanced
  private int isBalanced(Node node){
    if(node == null){
      return 1;
    }
    int left = isBalanced(node.left);
    if(left == -1){
      return -1;
    }
    int right = isBalanced(node.right);
    if(right == -1){
      return -1;
    }
    int diff = left - right;
    if(Math.abs(diff) > 1){
      return -1;
    }
    return (Math.max(left,right)+1);
  }

  //get nodde values to balance a tree
  private void sortNodeVal(ArrayList<Integer> ar, Node node){
    if(node  == null)
      return;

    sortNodeVal(ar,node.left);
    ar.add(node.num);
    sortNodeVal(ar,node.right);
  }

  //create a balanced tree
  private void bal(ArrayList<Integer>ar , int strt, int end){
    if(strt > end)
      return;
    int mid = (end+strt)/2;
    System.out.println("add val bal: "+ar.get(mid)+" strt: "+strt +" end:"+end+" mid:"+mid);
    add(ar.get(mid));
    bal(ar,strt,mid-1);
    bal(ar,mid+1,end);
  }

  //create a balanced tree
  private void balance(){
    ArrayList<Integer> ar = new ArrayList<>();
    sortNodeVal(ar,root);
    root = null;
    System.out.println(ar);
    bal(ar,0,ar.size()-1);
  }

  //create a balanced tree
  public void balanceTree(){
    if(isBalanced(root) >= 0){
      System.out.println("Tree is balanced");
    }
    else{
      System.out.println("Tree is not balanced\nbalanceing tree ....");
      balance();
    }
  }
/*
  private int getLCA(int i, int j, Node node){
    if(node == null){
      return -1;
    }

    if(node.num == i || node.num == j){
      return node.num;
    }
    int lef = getLCA(i,j,node.left);
    int rig = getLCA(i,j,node.right);

    if(lef != -1 && rig != -1){
      return node.num;
    }

    return lef != -1 ? lef:rig;
  }
  //get lowest common ancestor.
  public void getLowestCommonAncestor(int i, int j){
    int lca = getLCA(i,j,root);
    if( lca == -1){
      System.out.println("no lca");
    }
    else{
      System.out.println("lca :"+lca);
    }
  }
*/

  //getLCA
  private int getLCA(int i, int j, Node node){
    if(node == null){
      return -1;
    }

    if(node.num == i || node.num == j){
      return node.num;
    }

    int left = getLCA(i,j,node.left);
    int right = getLCA(i,j,node.right);

    if(left != -1 && right != -1)
      return node.num;

    return left != -1 ? left : right;

  }
  //get getLowestCommonAncestor
  public void getLowestCommonAncestor(int i, int j){
    int lca = getLCA(i, j, root);
    if(lca == -1){
      System.out.println("neither of the nums are in tree");
    }
    else{
      System.out.println("lca :"+lca);
    }
  }

  //get max depth
  private int getMaxDepth(Node node){
    if(node == null)
      return 0;

    int left = getMaxDepth(node.left);
    int right = getMaxDepth(node.right);

    return (Math.max(left,right)+1);
  }

  //get max depth.
  public void maxDepth(){
    System.out.println(getMaxDepth(root));
  }
  
  //breath first search
  public void bfs(){
    Queue<Node> qu = new LinkedList<>();
    System.out.println("\nbfs :");

    if(root != null)
      qu.add(root);

    while(!qu.isEmpty()){
      Node node = qu.poll();

      System.out.println(node.num);

      if(node.left != null){
        qu.add(node.left);
      }
      if(node.right != null){
        qu.add(node.right);
      }
    }
  }

  //inorder search
  private void inord(Node node){
    if(node == null){
      return;
    }
    inord(node.left);
    System.out.println(node.num);
    inord(node.right);
  }
  //inorder search
  public void inorder(){
    inord(root);
  }

}



class btree{
  public static void main(String args[]){
    Tree te = new Tree();
    te.add(10);
    te.add(15);
    te.add(5);
    te.add(13);
    te.add(7);
    te.add(17);
    te.add(3);
    te.add(20);
    te.add(0);
    te.add(16);
    te.add(2);
    te.add(11);

    te.balanceTree();
    te.bfs();

    te.remove(15);
    te.remove(0);
    te.remove(5);
    //te.remove(2);
    te.inorder();

    te.bfs();
    te.balanceTree();
    te.bfs();
    te.getLowestCommonAncestor(3,20);
    te.maxDepth();
  }
}
