import java.util.*;
class Solution{
  void KthFrmLast(Node<Integer> head, int k){
    Node<Integer> runner = head;
    Node<Integer> cur = head;
    int i = 0;
    while(i < k){
      runner = runner.next;
      i++;
    }
    while(runner != null){
      cur = cur.next;
      runner = runner.next;
    }
    System.out.println("Kth from last: "+cur.val);
  }
}
class KthFrmLast{
  public static void main(String[] args) {
    Node<Integer> llist = new Node<>();
    Node<Integer> head = llist.addNode(new ArrayList<>(Arrays.asList(3,4,5,2,1,6,8,9,3)));
    Solution sol = new Solution();
    sol.KthFrmLast(head, 5);
  }
}
