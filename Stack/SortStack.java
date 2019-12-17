//function to create a sorted stack, using two stacks.
//idea,
//1. if x > stk1.peek(), add x to stk1.
//2. if x<stk1.peek(), move all elems larger than x to stk2 from stk1. put x in stak1,
//   put elems back in stk1 from stk2.

import java.util.*;


class SortStack{
  Stack<Integer> st1;
  Stack<Integer> st2;
  SortStack(){
    st1 = new Stack<>();
    st2 = new Stack<>();
  }

  void push(int val){
    while(!st1.isEmpty()){
      if(val > st1.peek()){
        break;
      }
      st2.push(st1.pop());
    }
    st1.push(val);
    while(!st2.isEmpty()){
      st1.push(st2.pop());
    }
    System.out.println(st1);
  }

  int pop(){
    int ret = Integer.MIN_VALUE;
    if(st1.isEmpty()){
      return ret;
    }
    return st1.pop();
  }

  public static void main(String args[]){
    SortStack ss = new SortStack();
    ss.push(8);
    ss.push(9);
    ss.push(3);
    ss.push(5);
    ss.push(2);
    ss.push(10);

    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
  }
}
