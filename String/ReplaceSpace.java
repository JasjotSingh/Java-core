import java.util.*;

class ReplaceSpace{

  private String replSpace(String st, int tlen){
    int i = st.length() - 1;
    int indx = tlen - 1;
    StringBuffer s = new StringBuffer(st);
    //System.out.println(s+" "+s.length()+" "+i+" "+indx+" "+s.charAt(indx--));
    while(i >= 0){
      //System.out.println(s.charAt(indx)+" "+indx);
      if(s.charAt(indx) == ' '){
        indx--;
        s.setCharAt(i--,'0');
        s.setCharAt(i--,'2');
        s.setCharAt(i--,'%');
      }
      else{
        s.setCharAt(i--, s.charAt(indx--));
      }
    }

    return s.toString();
  }

  public static void main(String args[]){
    ReplaceSpace rst = new ReplaceSpace();
    String st = "Mr Jhon Smith    ";
    int tru_len = 13;

    st = rst.replSpace(st, tru_len);

    System.out.println("After replace: "+st);
  }
}
