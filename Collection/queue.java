import java.util.*;
class queue{
  public static void main(String args[]){
    Queue<String> qu = new LinkedList<>();
    qu.offer("dsfdf");
    qu.offer("dggd");
    qu.add("evfg");

    System.out.println("top :"+qu.peek()+"\n");

    while(!qu.isEmpty()){
      System.out.println(qu.poll());
    }
  }
}
