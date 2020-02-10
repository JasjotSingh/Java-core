import java.util.*;
class Solution{

  void InterLink(Node<Integer> head1, Node<Integer> head2){
    int len1 = 1;
    int len2 = 1;

    Node<Integer> node1 = head1;
    Node<Integer> node2 = head2;

    while(node1.next != null){
      node1 = node1.next;
      len1++;
    }
    while(node2.next != null){
      node2 = node2.next;
      len2++;
    }

    if(node1 == node2){
      System.out.println("intersection.");
      System.out.println("len1:"+len1+" len2: "+len2);
    }
    else{
      System.out.println("no intersection.");
    }
  }
}

class InterLink{
  public static void main(String[] args) {
    Node<Integer> llist1 = new Node<>();
    Node<Integer> head1 = llist1.addNode(new ArrayList<>(Arrays.asList(4,5,6,2,1)));

    Node<Integer> llist2 = new Node<>();
    Node<Integer> head2 = llist2.addNode(new ArrayList<>(Arrays.asList(2,1)));

    Node<Integer> node1 = head1;
    node1 = node1.next;
    node1 = node1.next;

    Node<Integer> node2 = head2;
    while(node2.next != null)
      node2 = node2.next;

    node2.next = node1;
    Solution sol = new Solution();
    sol.InterLink(head1, head2);
  }
}
