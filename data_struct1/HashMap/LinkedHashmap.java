class Node{
  int key;
  int val;
  Node hashNext;
  Node linkNext;
  Node linkPrev;

  Node(int key, int val){
    this.key = key;
    this.val = val;
    this.hashNext = null;
    this.linkNext = null;
    this.linkPrev = null;
  }

  @Override
  public String toString(){
    return "[key: "+this.key+", val: "+this.val+"]";
  }
}

class LinkHashMap{

  Node[] hashMap;
  int size;
  Node head;
  Node tail;

  LinkHashMap(int size){
    hashMap = new Node[size];
    this.size = size;
    head = new Node(-999, -999);
    tail = new Node(-999, -999);
    head.linkNext = tail;
    tail.linkPrev = head;
  }

  private int getHash(int key){
    return (key % size);
  }

  private void addLink(Node node){
    //add node
    Node prevNode = tail.linkPrev;
    prevNode.linkNext = node;
    tail.linkPrev = node;
    node.linkNext = tail;
    node.linkPrev = prevNode;
  }

  private void removeLink(Node node){
    //remove node.
    Node prevNode = node.linkPrev;
    Node nextNode = node.linkNext;
    System.out.println(node);
    System.out.println(prevNode);
    System.out.println(nextNode);
    prevNode.linkNext = nextNode;
    nextNode.linkPrev = prevNode;
    node.linkPrev = null;
    node.linkNext = null;
  }

  private Node create(int key, int val){
    Node newNode = new Node(key, val);
    addLink(newNode);
    return newNode;
  }

  private void chkHashLink(int key, int val, Node hashHead){
    //see if alread exists.
      //if dose update val.
      //else add new.
    Node current = hashHead;

    while(current.hashNext != null && current.key != key){
      current = current.hashNext;
    }

    if(current.key == key){
      current.val = val;
      //remove node.
      removeLink(current);
      //add in end.
      addLink(current);
    }
    else{
      current.hashNext = create(key,val);
    }
  }
  public void add(int key, int val){
    int hashIndx = getHash(key);

    //if hashMap head nulll, no value exists, no need to find exist, just add.
    if(hashMap[hashIndx] == null){
      hashMap[hashIndx] =  create(key, val);
    }
    else{
      chkHashLink(key, val, hashMap[hashIndx]);
    }
  }


  private void chkHashLink(int key, Node hashHead){
    //see if alread exists.
      //if dose update val.
      //else add new.
    Node current = hashHead;
    Node prev = current;
    while(current.hashNext != null && current.key != key){
      prev = current;
      current = current.hashNext;
    }

    if(current.key == key){
      removeLink(current);
      prev.hashNext = current.hashNext;
      System.out.println("reomved");
    }
    else{
      System.out.println("no key found for remove");
    }
  }

  public void remove(int key){
    int hashIndx = getHash(key);
    //if hashMap head nulll, no value exists, no need to find exist, just add.
    if(hashMap[hashIndx] == null){
      System.out.println("no such key.");
    }
    else{
      chkHashLink(key, hashMap[hashIndx]);
    }
  }

  public void display(){
    Node current = head.linkNext;
    while(current != tail ){
      System.out.println(current);
      current = current.linkNext;
    }
  }
}

class LinkedHashmap{
  public static void main(String[] args) {
    LinkHashMap ln = new LinkHashMap(3);
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
