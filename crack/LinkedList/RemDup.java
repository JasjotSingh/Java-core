
import java.util.*;
class Node{
  int val;
  Node next;

  Node(int val){
    this.val = val;
    this.next = null;
  }
}

class Solution{
  private Node head;
  Solution(){
    head = null;
  }

  void addNode(int val){
    if(head == null){
      head = new Node(val);
    }
    else{
      Node node = new Node(val);
      node.next = head;
      head = node;
    }
  }

  void removeDups(){
    //idea.
    //have current and prev pointer.
    //1.see a node, add the val to hashset.
    //2.if node val in hash set, move cur to next and only update prev
    //if new current is not seen, update linked list through prev and cur pointer.
    HashSet<Integer> hs = new HashSet<>();
    Node cur = head;
    Node prev = head;
    while(cur != null){
      if(!hs.contains(cur.val)){
        hs.add(cur.val);
        if(prev != cur)
          prev.next = cur;
        prev = cur;
      }
      else{
        prev.next = null;
      }
      cur = cur.next;
    }

    cur = head;
    while(cur!=null){
      System.out.println(cur.val);
      cur = cur.next;
    }
  }

  void removeDupsNoBuf(){
    Node pointer = head;

    while(pointer != null){
      Node prev = pointer;
      Node runner = pointer.next;
      System.out.println(" ");
      System.out.print(" "+prev.val);
      while(runner != null){
        if(runner.val == pointer.val){
          prev.next = runner.next;
        }
        else{
          prev = runner;
          System.out.print(" "+prev.val);
        }
        runner = runner.next;
      }
      pointer = pointer.next;
    }
System.out.println("--------");
    Node cur = head;
    while(cur!=null){
      System.out.println(cur.val);
      cur = cur.next;
    }

  }
}

class RemDup{
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.addNode(3);
    sol.addNode(3);
    sol.addNode(4);
    sol.addNode(6);
    sol.addNode(5);
    sol.addNode(6);
    sol.addNode(6);

    //sol.removeDups();
    sol.removeDupsNoBuf();
  }
}
