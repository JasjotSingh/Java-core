import java.util.*;

class LinkPL{
  class Node{
    int val;
    Node next;

    Node(int val){
      this.val = val;
      this.next = null;
    }
  }

  Node head = null;

  public void add(int val){
    if(head == null){
      head = new Node(val);
    }
    else{
      Node ne = new Node(val);
      ne.next = head;
      head = ne;
    }
  }

  public void display(){
    Node curr = head;
    while(curr != null){
      System.out.println(curr.val);
      curr = curr.next;
    }
  }

  public void part(int val){
    Node tail = head;
    Node curr = head;
    while(curr != null){
      Node ne = curr.next;
      if(curr.val < val){
        curr.next = head;
        head = curr;
      }
      else{
        tail.next = curr;
        tail = curr;
      }
      curr = ne;
    }
    tail.next = null;
  }
}
class PartLink{
  public static void main(String args[]){
    LinkPL lp = new LinkPL();
    lp.add(3);
    lp.add(5);
    lp.add(8);
    lp.add(4);
    lp.add(10);
    lp.add(2);
    lp.add(1);

    System.out.println("before part : ");
    lp.display();

    lp.part(5);
    System.out.println("\nAfter part: ");
    lp.display();
  }
}
