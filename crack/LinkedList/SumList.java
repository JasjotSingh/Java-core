import java.util.*;
class Solution{

  int addList(Node<Integer> node1, Node<Integer> node2, int carry){
    if(node1 == null && node2 == null)
      return carry;

    int sum = 0;
    if(node1 == null){
      if(node2 != null){
        sum = node2.val+carry;
        // System.out.println("1, carry: "+sum/10+" sum: "+sum%10);
        return ((addList(node1, node2.next, sum/10)*10) + sum%10);
      }
    }
    else if(node2 == null){
      if(node1 != null){
        sum = node1.val+carry;
        // System.out.println("2, carry: "+sum/10+" sum: "+sum%10);
        return ((addList(node1.next, node2, sum/10)*10) + sum%10);
      }
    }
    else{
      sum = node1.val+node2.val+carry;
      // System.out.println("3, carry: "+sum/10+" sum: "+sum%10);
      return ((addList(node1.next, node2.next, sum/10)*10) + sum%10);
    }
    return 0;
  }
}

class SumList{
  public static void main(String[] args) {
    Node<Integer> node = new Node<>();
    Node<Integer> head1 = node.addNode(new ArrayList<>(Arrays.asList(0,0,0,0,0,0,6,1,7)));
    Node<Integer> node1 = new Node<>();
    Node<Integer> head2 = node1.addNode(new ArrayList<>(Arrays.asList(2,9,5)));

    Solution sol =  new Solution();
    int carry = 0;
    int sum = sol.addList(head1, head2, carry);
    System.out.println(sum);
  }
}
