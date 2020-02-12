import java.util.*;

/*
1.que = fifo;
2.stk = lifo;

st1 =  4 5

st2 =

//lasy approck, let stk2 stay in the reverse order(reverse compare to stk1) till another push is performed,
//simillarly, let stk1 stay in its order till pop or peek is performed.
*/
class Solution{

  Stack<Integer> stk1;
  Stack<Integer> stk2;

  Solution(){
    stk1 = new Stack<>();
    stk2 = new Stack<>();
  }

  void push(int val){
    while(!stk2.isEmpty()){
      stk1.push(stk2.pop());
    }
    stk1.push(val);
  }

  int pop(){
    int ret = -1;
    while(!stk1.isEmpty()){
      stk2.push(stk1.pop());
    }
    if(!stk2.isEmpty())
      ret = stk2.pop();
    return ret;
  }
}

class QuevStk{
  public static void main(String[] args) {

    Solution sol = new Solution();
    for(int i = 0 ; i < 5 ; i ++){
      sol.push(i);
    }
    for(int i = 0 ; i < 2 ; i ++){
      System.out.println(sol.pop());
    }
    for(int i = 5 ; i < 10 ; i ++){
      sol.push(i);
    }
    for(int i = 0 ; i < 10 ; i ++){
      System.out.println(sol.pop());
    }
  }
}
