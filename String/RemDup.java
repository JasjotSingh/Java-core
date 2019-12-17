import java.util.*;

class RemDup{
  String removeDup(String s){
    StringBuilder st = new StringBuilder(s);
    int flg = 0;
    for(int i = 0; i < st.length(); i++){
      int j= 0;
      for(j = 0; j < i; j++){
        if(st.charAt(i) == st.charAt(j)){
          break;
        }
      }
      if(j == i){
        st.setCharAt(flg, st.charAt(i));
        flg++;
      }
    }
    while(flg < s.length()){
      st.setCharAt(flg++, '\u');
    }
    return st.toString();
  }
  public static void main(String args[]){
    RemDup re = new RemDup();
    String st = "hi hello ni";
    System.out.println("String before: "+st);
    st = re.removeDup(st);
    System.out.println("String after: "+st);
  }
}
