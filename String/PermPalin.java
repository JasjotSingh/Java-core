import java.util.*;

class PermPalin{
  private Boolean isPalPerm(String st){
    HashMap<Character,Integer> ccnt = new HashMap<>();
    st = st.toLowerCase();
    for(int i = 0; i < st.length(); i++){
      if(st.charAt(i) != ' '){
        ccnt.put(st.charAt(i),ccnt.getOrDefault(st.charAt(i),0)+1);
      }
    }

    int odd = 0 ;
    //int evn = 0;
    for(char c: ccnt.keySet()){
      if(ccnt.get(c)%2 != 0){
        odd++;
      }
      if(odd > 1)
        return false;
    }
    return true;
  }
  public static void main(String args[]){
    String st = "Tacet Coa";
    PermPalin p = new PermPalin();

    if(p.isPalPerm(st)){
      System.out.println("yup");
    }
    else{
      System.out.println("Nope");
    }
  }
}
