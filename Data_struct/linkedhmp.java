class linked{
  class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node link;
  }
  Node hmap[];
  int hashindx;
  Node head;

  linked(int hindx){
    hmap = new Node[hindx];
    hashindx = hindx;
    head = null;
  }

  private int getHash(int key){
    return key % hashindx;
  }

  private void addLink(Node node){
    if(head == null){
      head = node;
    }
    else{
      node.link = head;
      head.prev = node;
      head = node;
    }
  }
  private Node create(int key, int val){
    Node ne = new Node();
    ne.key = key;
    ne.val = val;
    ne.prev = null;
    ne.next = null;
    ne.link = null;

    addLink(ne);
    return ne;
  }

  public void add(int key, int val){
    int hash = getHash(key);

    if(hmap[hash] == null){
      hmap[hash] = create(key,val);
    }
    else{
      Node cur = hmap[hash];
      while(cur != null && cur.key != key){
        cur = cur.next;
      }

      if(cur != null && cur.key == key){
        cur.val = val;
      }
      else{
        Node ne = create(key,val);
        ne.next = hmap[hash];
        hmap[hash] = ne;
      }
    }
  }

  private void removeLink(Node node){
    Node prev = node.prev;
    Node link = node.link;

    if(node == head){
      head = node.link;
      head.prev = null;
    }
    else{
      prev.link = link;
      if(link != null)
        link.prev = prev;
    }
  }
  public void remove(int key){
    int hash = getHash(key);
    Node cur = hmap[hash];
    Node prev = cur;
    while(cur != null && cur.key != key){
      prev = cur;
      cur = cur.next;
    }

    if(cur != null && cur.key == key){
      if(cur == hmap[hash] && cur.next == null){
        hmap[hash] = null;
        removeLink(cur);
      }
      else if(cur == hmap[hash] && cur.next != null){
        hmap[hash] = cur.next;
        removeLink(cur);
      }
      else if(prev != cur){
        prev.next = cur.next;
        removeLink(cur);
      }
    }
    else{
      System.out.println("Key does not exist.");
    }
  }

  public void display(){
    Node cur = head;
    while(cur.link != null){
      cur = cur.link;
    }
    while(cur != null){
      int hash = getHash(cur.key);
      System.out.println(cur.key+" "+cur.val+" hash: "+hash);
      cur = cur.prev;
    }
  }
}
class linkedhmp{
  public static void main(String args[]){
    linked ln = new linked(3);
    ln.add(3,4);
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
    ln.display();
  }
}
