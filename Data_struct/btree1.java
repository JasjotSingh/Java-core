import java.util.*;
import java.lang.Math;

class Node{
  int val;
  Node left;
  Node right;

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

class Tree{
  Node root;
  Tree(){
    root = null;
  }

  Node addN(int val, Node node){
    if(node == null){
      return new Node(val);
    }

    if(val > node.val){
      node.right = addN(val, node.right);
    }
    else{
      node.left = addN(val, node.left);
    }
    return node;
  }

  void addNode(int val){
      root = addN(val, root);
  }

  void getLevelOrder(){
    ArrayList<ArrayList<Node>> lvlst = new ArrayList<>();
    ArrayList<Node> nlst = new ArrayList<>();
    System.out.println("lvlord: ");
    nlst.add(root);

    while(nlst.size() > 0){
      lvlst.add(new ArrayList<>(nlst));
      ArrayList<Node> lst = new ArrayList<>();
      while(nlst.size() > 0){
        Node node = nlst.get(0);
        nlst.remove(0);
        if(node.left != null){
          lst.add(node.left);
        }
        if(node.right != null){
          lst.add(node.right);
        }
      }
      nlst.addAll(lst);
    }

    for(ArrayList<Node> nar : lvlst){
      System.out.println(nar);
    }
  }

  void bst(){
    Queue<Node> nq = new LinkedList<>();
    System.out.println("bst: ");
    nq.offer(root);
    while(!nq.isEmpty()){
      System.out.print( nq.peek()+" ");
      Node node = nq.poll();
      if(node.left != null)
        nq.offer(node.left);
      if(node.right != null)
        nq.offer(node.right);
    }
  }

  int findRightMin(Node node){
    if(node.left == null)
      return node.val;
    return findRightMin(node.left);
  }

  Node remNode(Node node, int val){
    if(node == null){
      return null;
    }
    if(node.val == val){
      if(node.right == null && node.left == null)
        return null;
      else if(node.left == null)
        return node.right;
      else if(node.right == null)
        return node.left;
      else{
        int rightMinVal = findRightMin(node.right);
        node.val = rightMinVal;
        node.right = remNode(node.right, rightMinVal);
      }
    }
    if(val > node.val)
      node.right = remNode(node.right, val);
    else
      node.left = remNode(node.left, val);
    return node;
  }

  void removeNode(int val){
    if(root == null)
      System.out.println("Tree Empty");
    root = remNode(root, val);
  }

  int LCA(int v1, int v2, Node node){
      if(node == null)
        return -1;

      if(node.val == v1 || node.val == v2)
        return node.val;

      int left = LCA(v1,v2,node.left);
      int right = LCA(v1,v2,node.right);

      if(left != -1 && right != -1){
        return node.val;
      }

      return left != -1 ? left : right != -1 ? right : -1;
  }

  int isBalanced(Node node){
    if(node == null)
      return 1;

    int left = isBalanced(node.left);
    if(left < 0){
      return -1;
    }
    int right = isBalanced(node.right);
    if(right < 0){
      return -1;
    }

    if(Math.abs(right - left) > 1)
      return -1;

    return (Math.max(left,right)+1);
  }

  void getinarr(Node node, ArrayList<Integer> ar){
    if(node == null)
      return;
    getinarr(node.left, ar);
    ar.add(node.val);
    getinarr(node.right, ar);
    return;
  }

  void creBalanced(ArrayList<Integer> ar, int strt, int end){
    if(strt > end)
      return;

    int mid = (strt+end)/2;
    //System.out.println(ar.get(mid));
    addNode(ar.get(mid));
    creBalanced(ar,strt,mid-1);
    creBalanced(ar,mid+1,end);
  }

  void isBalanced(){
    if(isBalanced(root) > 0){
      System.out.println("balanced");
    }
    else{
      System.out.println("not balanced\nbalancing....\nbalanced:");
      ArrayList<Integer> ar = new ArrayList<>();
      getinarr(root, ar);
      root = null;
      creBalanced(ar,0,ar.size()-1);
    }
  }

  void getLCA(int val1, int val2){
    int lca = LCA(val1, val2, root);
    System.out.println("lca : "+lca);
  }

  void getBetween(int v1, int v2){
    Queue<Node> pq = new LinkedList<>();
    TreeSet<Node> an = new TreeSet<>(new Comparator<Node>(){
      @Override
      public int compare(Node n1, Node n2){
        return n1.val > n2.val?1 : n1.val < n2.val?-1:0;
      }
    });
    pq.offer(root);

    System.out.println("\nget between :"+v1+" "+v2);
    while(!pq.isEmpty()){
      Node node = pq.poll();
      if(node.val >= v1 && node.val <=v2){
        an.add(node);
        if(node.left != null)
          pq.offer(node.left);
        if(node.right != null)
          pq.offer(node.right);
      }
      else if(node.val > v2){
        if(node.left != null)
          pq.offer(node.left);
      }
      else if(node.val < v1){
        if(node.right != null)
          pq.offer(node.right);
      }
    }

    System.out.println(an);
  }
}

class treeMain{
  public static void main(String args[]){
    Tree tre = new Tree();
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


    tre.getLevelOrder();
    tre.bst();

    tre.getBetween(11,16);

    tre.removeNode(15);
    tre.removeNode(17);
    tre.getLevelOrder();

    tre.getLCA(19,11);

    tre.isBalanced();
    tre.getLevelOrder();

  }
}
