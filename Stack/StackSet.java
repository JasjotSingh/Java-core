import java.util.*;

class StackSet{
  ArrayList<Stack<Integer>> StkSet;
  int scap = 0;
  StackSet(int cap){
    StkSet = new ArrayList<>();
    StkSet.add(new Stack<>());
    scap = cap;
  }

  private void push(int val){
    Stack<Integer> stk  = StkSet.get(StkSet.size() -1);
    if(stk.size() == scap){
      StkSet.add(new Stack<>());
      stk = StkSet.get(StkSet.size() -1);
    }
    stk.push(val);
  }

  private int pop(){
    int ret = Integer.MIN_VALUE;
    Stack<Integer> stk = null;

    if(!StkSet.isEmpty())
      stk = StkSet.get(StkSet.size() -1);

    if(stk == null || stk.isEmpty())
      System.out.println("Stack is Empty");
    else
      ret = stk.pop();

    if(stk != null && stk.size() == 0 && StkSet.size() > 1){
      StkSet.remove(stk);
    }
    return ret;
  }

  public static void main(String args[]){
    StackSet ss = new StackSet(3);
    ss.push(4);
    ss.push(5);
    ss.push(2);
    ss.push(14);
    ss.push(15);
    ss.push(12);
    ss.push(41);
    ss.push(51);
    ss.push(21);
    ss.push(43);
    ss.push(54);

    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());

    ss.push(51);
    ss.push(21);
    ss.push(43);
    ss.push(54);


    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());



  }
}
