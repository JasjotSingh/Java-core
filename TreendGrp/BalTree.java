import java.util.*;

class Node{
  int val;
  Node left;
  Node right;

  Node(int val){
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
class BalTree{
  Node root;
  BalTree(){
    root = null;
  }
  private Node Create(int val){
    return new Node(val);
  }

  private Node add(Node node, int val){
    if(node == null){
      return Create(val);
    }
    else if(val >= node.val){
      node.right = add(node.right, val);
    }
    else{
      node.left = add(node.left, val);
    }
    return node;
  }
  private void addNode(int val){
    if(root == null){
      root = Create(val);
    }
    else{
      add(root,val);
    }
  }
  public void balTree(int[] ar, int strt, int end){
    if(strt > end){
      return;
    }
    int mid = (strt+end)/2;
    //System.out.println("hjj"+ar[mid]);
    addNode(ar[mid]);
    balTree(ar,strt,mid-1);
    balTree(ar,mid+1,end);
  }

  private void inorder(Node node){
    if(node == null)
      return;
    inorder(node.left);
    System.out.println(node.val);
    inorder(node.right);
  }
  public void inord(){
    inorder(root);
  }
  public static void main(String args[]){
    int ar[] = {1,2,3,4,4,5,6,7,8,9};
    BalTree bl = new BalTree();
    bl.balTree(ar, 0,ar.length - 1);
    bl.inord();
  }
}
