import java.util.*;
class Linkl{
  int val;
  Linkl next;
  Linkl(int val){
    this.val = val;
    this.next = null;
  }
}
class UniList{
  Linkl head = null;

  private void display(){
    Linkl curr = head;
    while(curr != null){
      System.out.println(curr.val);
      curr = curr.next;
    }
  }

  private void add(int val){
    if(head == null){
      head = new Linkl(val);
    }
    else{
      Linkl ne = new Linkl(val);
      ne.next = head;
      head = ne;
    }
  }

  private void uniq(){
    HashSet<Integer> hs = new HashSet<>();
    Linkl prev = head;
    Linkl curr = head;
    while(curr != null){
      if(hs.contains(curr.val)){
        prev.next = curr.next;
        System.out.println("remove: "+curr.val);
      }
      else{
        hs.add(curr.val);
        prev = curr;
      }
      curr = curr.next;
    }
  }
  public static void main(String args[]){
    UniList ul = new UniList();
    ul.add(3);
    ul.add(0);
    ul.add(0);
    ul.add(0);
    ul.add(0);
    ul.add(5);
    ul.add(3);
    ul.add(2);
    ul.add(5);
    ul.display();
    ul.uniq();
    ul.display();

  }
}
