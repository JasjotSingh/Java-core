import java.util.*;

class Solution{
  void DelMiddleNode(Node<Character> node){
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
class DelMiddleNode{
  public static void main(String[] args) {
    Node<Character> llist = new Node<>();
    Node<Character> head = llist.addNode(new ArrayList<>(Arrays.asList('f','e','d','c','b','a')));
    Node <Character> cur = head;
    while(cur != null){
      System.out.print(" "+cur.val);
      cur = cur.next;
    }
    System.out.println("\n-----------");
    cur = head;
    cur = cur.next;//b
    cur = cur.next;//c
    cur = cur.next;//d
    cur = cur.next;//e
    //cur = cur.next;//f this will not work, only solution to get this to work is to have a dummy node at the end.
    Solution sol = new Solution();
    sol.DelMiddleNode(cur);
    cur = head;
    while(cur != null){
      System.out.print(" "+cur.val);
      cur = cur.next;
    }
    System.out.println("\n-----------");
  }
}
