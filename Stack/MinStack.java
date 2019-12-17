//create a stack, and also be able to return the min element at all times.
//idea
//1. create two stack. add x to stk1, if x <= stk2.peek(), add x to stk2 as well.(stk2 keep track of min)
//2. when removing elem, if stk1.peek == stk2.peek remove both stk1.peek and stk2.peek, else kust stk1.peek.
import java.util.*;

class MinStack{
  Stack<Integer> s1;
  Stack<Integer> s2;
  MinStack(){
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  private void push(int val){
    s1.push(val);
    if(val <= getMin())
      s2.push(val);
  }

  private int pop(){
    if(s1.isEmpty()){
      return Integer.MAX_VALUE;
    }
    else{
      int ret = s1.pop();
      if(ret == s2.peek())
        s2.pop();
      return(ret);
    }
  }
  private int getMin(){
    if(s2.isEmpty()){
      return Integer.MAX_VALUE;
    }
    else{
      return s2.peek();
    }
  }

  public static void main(String args[]){
    MinStack ms = new MinStack();
    ms.push(2);
    ms.push(5);
    ms.push(0);
    ms.push(3);
    ms.push(0);
    ms.push(9);

    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());

    ms.push(2);
    ms.push(5);
    ms.push(0);
    ms.push(3);
    ms.push(0);
    ms.push(9);

    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
    System.out.println(ms.pop()+" min: "+ms.getMin());
  }
}
