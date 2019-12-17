import java.util.*;
class stack{

  public static void main(String args[]){
    Stack<Integer> stk = new Stack<>();
    stk.push(2);
    stk.push(4);
    stk.push(1);

    System.out.println("top :"+stk.peek()+"\n");

    while(!stk.isEmpty()){
      System.out.println(stk.pop());
    }
  }
}
