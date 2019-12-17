import java.util.*;

class LinkKth{
  class Node{
    int val;
    Node next;

    Node(int val){
      this.val = val;
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

  public int kthElem(int kth){
    int cnt = 0;
    Node cur = head;
    while(cnt < kth){
      cnt++;
      cur = cur.next;
    }
    Node knode = head;
    while(cur != null){
      cur = cur.next;
      knode = knode.next;
    }
    return knode.val;
  }
}
class KthLink{
  public static void main(String args[]){
    LinkKth  lk = new LinkKth();
    lk.add(3);
    lk.add(4);
    lk.add(9);
    lk.add(1);
    lk.add(13);
    lk.add(24);
    lk.add(49);
    lk.add(51);
    lk.display();
    System.out.println("kth elem: "+lk.kthElem(5));
  }
}
