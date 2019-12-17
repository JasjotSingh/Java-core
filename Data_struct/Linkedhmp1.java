import java.util.*;

class Node{
  int key;
  int val;
  Node next;
  Node prev;
  Node link;
  
  Node(int key, int val){
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
    this.link = null;
  }
}
class Linkedhmp1{
  Node []hmp;
  int hindx;
  Node head;

  Linkedhmp1(int hindx){
    this.hindx = hindx;
    hmp = new Node[hindx];
    head = null;
  }

  int hashindx(int key){
    return (key % hindx);
  }

  void add(int key, int val){
    System.out.println("adding: "+key+" :"+val);
    int indx = hashindx(key);

    if(hmp[indx] == null){
      hmp[indx] = new Node(key, val);
      addLink(hmp[indx]);
    }
    else{
      Node cur = hmp[indx];
      Node prev = cur;

      while(cur != null && cur.key != key) {
        prev = cur;
        cur = cur.link;
      }

      if(cur == null){
        prev.link = new Node(key,val);
        addLink(prev.link);
      }
      else{
        cur.val = val;
        remLink(cur);
        addLink(cur);
      }
    }
  }

  void remove(int key){
    System.out.println("removing: "+key);
    int indx = hashindx(key);
    Node cur = hmp[indx];
    Node prev = cur;
    while(cur != null && cur.key != key){
      prev = cur;
      cur = cur.link;
    }

    if (cur == hmp[indx] && cur != null){
      hmp[indx] = cur.link;
      remLink(cur);
    }
    else if (cur != null){
      prev.link = cur.link;
      remLink(cur);
    }
  }

  void addLink(Node node){
    if(head == null){
      head = node;
    }
    else{
      head.prev = node;
      node.next = head;
      head = node;
    }
  }
  void remLink(Node node){
    if(node == head){
      head = node.next;
      if(head != null)
        head.prev = null;
    }
    else{
      Node prev = node.prev;
      Node next = node.next;
      prev.next = next;
      if(next != null)
        next.prev = prev;
    }
  }

  void display(){
    Node cur = head;
    while(cur != null){
      System.out.println(cur.key+" :"+cur.val);
      cur = cur.next;
    }
  }
}

class lhmpmain{
  public static void main(String args[]){
    Linkedhmp1 ln = new Linkedhmp1(10);
    ln.add(3,4);
    ln.remove(3);
    ln.add(12,4);
    ln.add(10,4);
    ln.add(45,4);
    ln.add(65,4);
    ln.add(32,4);
    ln.add(1,4);

    ln.remove(3);
    ln.remove(1);
    ln.remove(45);

    ln.add(543,3);
    ln.add(1,3);
    ln.add(431,3);

    ln.remove(431);
    ln.add(12,34);
    ln.display();
  }
}
