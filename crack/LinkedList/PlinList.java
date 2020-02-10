import java.util.*;
class Solution{

  boolean PalinList(Node<Character> head){
    Stack<Character> stk = new Stack<>();
    Node<Character> cur = head;

    while(cur != null){
      stk.push(cur.val);
      cur = cur.next;
    }

    cur = head;
    while(cur != null){
      // System.out.println(cur.val+" "+stk.peek());
      if(cur.val != stk.pop())
        return false;
      cur = cur.next;
    }
    return true;
  }
}

class PalinList{
  public static void main(String[] args) {
    Node<Character> llist = new Node<>();
    Node<Character> head = llist.addNode(new ArrayList<>(Arrays.asList('a','b','a','c','a','b','a')));

    Solution sol = new Solution();
    if(sol.PalinList(head)){
      System.out.println("a palin");
    }
    else{
      System.out.println("not a palin");
    }
  }
}
