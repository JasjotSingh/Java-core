import java.util.*;

class Node{
  int val;
  Node right;
  Node left;

  Node(int val){
    this.val = val;
    this.right = null;
    this.left = null;
  }
}

class Solution{
  Node root;

  Solution(){
    root = null;
  }

  Node addNode(int val){
    return new Node(val);
  }

  Node add(Node node, int val){
    if(node == null)
      return addNode(val);

    if(node.val < val){
      node.right = add(node.right, val);
    }
    else{
      node.left = add(node.left, val);
    }
    return node;
  }

  void add(int val){
    root = add(root,val);
  }

  void display(){
    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    while(!qu.isEmpty()){
      List<Node> clist = new ArrayList<>();
      while(!qu.isEmpty()){
        Node pnode = qu.poll();
        System.out.print(pnode.val+" ");

        if(pnode.left != null)
          clist.add(pnode.left);
        if(pnode.right != null)
          clist.add(pnode.right);
      }
      qu.addAll(clist);
      System.out.println(" ");
    }
  }
  //1,2,3,4,5,6,7.
  void divnConq(List<Integer> arr, int st, int en){
    if(st <= en){
      int mid = st + (en - st) / 2;//(en+st)/2;    //l + (r - l) / 2; 
      add(arr.get(mid));
      divnConq(arr, st, mid-1);
      divnConq(arr, mid+1, en);
    }
  }
  void miniTree(List<Integer> arr){
    divnConq(arr, 0,arr.size()-1);
  }
}

class MiniTree{
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.miniTree(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
    sol.display();
  }

}
