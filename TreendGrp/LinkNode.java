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
class TreeLinkNode{
  Node root;
  TreeLinkNode(){
    root = null;
  }
  private Node creNode(int val){
    Node ne = new Node(val);
    return ne;
  }
  public Node addNode(Node node, int val){
    if(node == null){
      return creNode(val);
    }
    if(val > node.val){
      node.right = addNode(node.right, val);
    }
    else{
      node.left = addNode(node.left, val);
    }
    return node;
  }

  public void add(int val){
    if(root == null){
      root = new Node(val);
    }
    else{
      addNode(root, val);
    }
  }

  void getlndfs(Node node, ArrayList<LinkedList<Node>> ll, int lv){
    LinkedList<Node> l;
    if(node == null){
      return;
    }
    if(lv > ll.size()){
      l = new LinkedList<>();
      ll.add(l);
    }
    else{
      l = ll.get(lv-1);
    }
    l.add(node);
    getlndfs(node.left, ll, lv+1);
    getlndfs(node.right, ll, lv+1);

  }

  void getlnbfs(Node root, ArrayList ll, int lv){
    LinkedList<Node> l = new LinkedList<>();
    l.add(root);

    while(l.size() > 0){
      ll.add(l);
      LinkedList<Node> nl = new LinkedList<>();
      for(Node n: l){
        if(n.left != null){
          nl.add(n.left);
        }
        if(n.right != null){
          nl.add(n.right);
        }
      }
      l = nl;
    }
  }

  public void levelNode(ArrayList<LinkedList<Node>> dlist, ArrayList<LinkedList<Node>> blist){
    getlndfs(root, dlist, 1);
    System.out.println("dfs: ");
    for(LinkedList<Node> ll: dlist){
      for(Node n: ll){
        System.out.print(n.val+" ");
      }
      System.out.println("");
    }

    getlnbfs(root, blist, 1);
    System.out.println("\nbfs: ");
    for(LinkedList<Node> ll: blist){
      for(Node n: ll){
        System.out.print(n.val+" ");
      }
      System.out.println("");
    }
  }

  private int isBal(Node node){
    if(node == null){
      return 1;
    }
    int left = isBal(node.left);
    if(left < 0){
      //System.out.println("neg :"+node.val);
      return -1;
    }
    int right = isBal(node.right);
    if(right < 0 ){
      //System.out.println("neg :"+node.val);
      return -1;
    }

    if(Math.abs(left - right) >= 2){
      //System.out.println("neg :"+node.val);
      return -1;
    }

    return (Math.max(right, left) +1);
  }
  public void bal(){
    if(isBal(root) >= 0){
      System.out.println("Tree is balanced");
    }
    else{
      System.out.println("Tree is not balanced");
    }
  }
}

class LinkNode{
  public static void main(String args[]){
    TreeLinkNode te = new TreeLinkNode();
    ArrayList<LinkedList<Node>> dlist = new ArrayList<>();
    ArrayList<LinkedList<Node>> blist = new ArrayList<>();
    te.add(5);
    te.add(3);
    te.add(4);
    te.add(2);
    te.add(1);
    te.add(8);
    te.add(7);
    te.add(6);
    te.add(9);
    te.add(0);

    te.levelNode(dlist, blist);
    te.bal();
  }
}
