import java.util.*;

class QTwoStack{

  Stack<Integer> s1;
  Stack<Integer> s2;
  QTwoStack(){
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  public void offer(int val){
    s2.push(val);
  }
  private void shiftStack(){
    if(s1.isEmpty()){
      while(!s2.isEmpty()){
        s1.push(s2.pop());
      }
    }
  }
  public int poll(){
    shiftStack();
    if(s1.isEmpty()){
      return Integer.MIN_VALUE;
    }
    return s1.pop();
  }
  public static void main(String args[]){
    QTwoStack qt = new QTwoStack();
    qt.offer(3);
    qt.offer(4);
    qt.offer(5);

    System.out.println(qt.poll());
    System.out.println(qt.poll());

    qt.offer(9);
    qt.offer(7);
    System.out.println(qt.poll());
    System.out.println(qt.poll());
    System.out.println(qt.poll());
    System.out.println(qt.poll());

  }
}
