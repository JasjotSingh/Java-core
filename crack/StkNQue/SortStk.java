/*
  4 5 6 2 3
  stk1 =       
  stk2 = 2 3 4 5 6
  tmp =

  stk1 = 6 5 4 3 2

crack:
  1. while stk1 != Empty
    1a. keep stk1.pop in  tmp.
    1b. while stk2 != empty and tmp < stk2.peek()
      1ba. stk1.push(stk2.pop)
    1c.push tmp in stk2.
  2.while stk2 != empty
    2a. keep stk2.pop in  tmp.
    2c.push tmp in stk1.

jas original:

  1. while stk1 != Empty
    1a. keep stk1.pop in  tmp.
    1b. while stk1 != empty and tmp > stk1.peek()
      1ba. stk2.push(stk1.pop)
    1c.push tmp in stk2.
  2.while stk2 != empty
    2a. keep stk2.pop in  tmp.
    2b.while stk2 != empty and tmp < stk2.peek()
      2ba. stk1.push(stk2.pop)
    2c.push tmp in stk1.
*/

import java.util.*;

class Solution{
  void sortStk(Stack<Integer> stk1){
    Stack<Integer> stk2 = new Stack<>();

    while(!stk1.isEmpty()){
      int tmp = stk1.pop();
      while(!stk2.isEmpty() && tmp < stk2.peek()){
        stk1.push(stk2.pop());
      }
      stk2.push(tmp);
    }
    while(!stk2.isEmpty()){
      int tmp = stk2.pop();

      stk1.push(tmp);
    }
  }
}

class SortStk{
  public static void main(String[] args) {
    Solution sol = new Solution();
    Stack<Integer> stk = new Stack<>(); // 4 5 6 2 3
    stk.push(4);stk.push(5);stk.push(6);stk.push(2);stk.push(3);
    sol.sortStk(stk);
    System.out.println(stk);
  }
}
