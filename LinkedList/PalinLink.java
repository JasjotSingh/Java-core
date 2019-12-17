import java.util.*;

class LinkPal{
  class Node{
    int val;
    Node next;

    Node(int val){
      this.val = val;
      this.next = next;
    }
  }

  class Result{
    boolean res;
    Node node;

    Result(Node node,boolean res){
      this.res = res;
      this.node = node;
    }
  }

  Node head = null;

  public void display(){
    Node curr = head;
    while(curr != null){
      System.out.println(curr.val);
      curr = curr.next;
    }
  }

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
  //1,2,3,4,5,6,7
  //3,4,5,6,5,4,3
  public Result palindrome(Node curr, int len){
    if(len <= 0){
      return(new Result(curr, true));
    }
    else if(len == 1){
      return(new Result(curr.next, true));
    }

    Result res = palindrome(curr.next, len -2);

    if(!res.res){
      return res;
    }

    if(res.node.val == curr.val){
      return new Result(res.node.next, true);
    }
    else{
      System.out.println(res.node.val +" "+curr.val);
      return new Result(res.node.next,false);
    }
  }
  public boolean isPalin(){
    int len = 0;
    Node curr = head;
    while(curr != null){
      len++;
      curr = curr.next;
    }
    System.out.println(len);
    curr = head;
    Result res = palindrome(curr, len);

    return res.res;
  }

}

class PalinLink{
  public static void main(String args[]){
    LinkPal lpal = new LinkPal();

    lpal.add(3);
    lpal.add(4);
    lpal.add(5);
    //lpal.add(6);
    lpal.add(5);
    lpal.add(4);
    lpal.add(3);

    if(lpal.isPalin()){
      System.out.println("yup");
    }
    else{
      System.out.println("nope");
    }
  }
}
