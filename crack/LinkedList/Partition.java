import java.util.*;
class Solution{

  public  Node<Integer> Partition( Node<Integer> node, Integer val){
    Node<Integer> head = node;
    Node<Integer> tail = node;

    while(node != null){
      Node<Integer> next = node.next;
      if(node.val < val){
        node.next = head;
        head = node;
      }
      else{
        tail.next = node;
        tail = node;
        tail.next = null;
      }
      node = next;
    }
    return head;
  }
}
class Partition{
  public static void main(String[] args) {
    Solution sol = new Solution();
    Node<Integer> llist = new Node<>();
    Node<Integer> head = llist.addNode(new ArrayList<>(Arrays.asList(3,4,1,8,65,3,9)));

    Node<Integer> cur = head;
    while(cur != null){
      System.out.print(" "+cur.val);
      cur = cur.next;
    }
    System.out.println("\n----------");

    cur = sol.Partition(head, 8);

    while(cur != null){
      System.out.print(" "+cur.val);
      cur = cur.next;
    }
    System.out.println("\n----------");
  }



}
