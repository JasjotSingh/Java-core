import java.util.*;

class UniqSt{
  public Boolean isUniq(String st){
    HashSet<Character> cset = new HashSet<>();

    for(int i = 0; i < st.length(); i++){
      if(cset.contains(st.charAt(i))){
        return false;
      }
      cset.add(st.charAt(i));
    }
    return true;
  }
  public static void main(String args[]){
    UniqSt uq = new UniqSt();
    String st = "hi aelo";
    System.out.println("is the string uniq: "+uq.isUniq(st));
  }
}
