import java.util.*;

class Solver{

  public void reduce(String str, int limit){
    Stack<Integer> stk = new Stack<>();
    StringBuffer s = new StringBuffer();
    int i = 0;
    while(i < str.length()){

      int j;
      int strt = i;
      for(j = s.length(); j <= limit -4 &&  i < str.length(); j++,i++){
        if(str.charAt(i) == '<')
          stk.push(i);
        if(str.charAt(i) == '>')
          stk.pop();
      }
      if(!stk.isEmpty()){
        i = stk.pop()-1;
      }
      s.append(str.substring(strt,i));
      s.append("</p>");
      System.out.println(s);
      s = new StringBuffer();
      if(i < str.length()){
        s.append("<p>");
      }
    }
    System.out.println(s);
  }
}

class htmlsnip{
  public static void main(String args[]){

    String str = "<p> The <b>quick</b> brown <i>fox</i> jumps over a lazy dog.</p>";
    Solver slv = new Solver();
    slv.reduce(str, 30);
  }
}
