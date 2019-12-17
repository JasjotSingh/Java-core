import java.util.*;

class onediff{

  Boolean isOneDiff(String s1, String s2){
    int diff = 0;

    if(s1.length() > s2.length()){
      int i = 0; int j = 0;
      while(i < s1.length()){
        if(s1.charAt(i) != s2.charAt(j)){
          i++;
          if(++diff > 1){
            return  false;
          }
          continue;
        }
        i++;
        j++;
      }
    }
    else if (s1.length() < s2.length()){
      int i = 0; int j = 0;
      while(i < s2.length()){
        if(s1.charAt(i++) != s2.charAt(j++)){
          j++;
          if(++diff > 1){
            return  false;
          }
          continue;
        }
        j++;
        i++;
      }
    }
    else{
      int i = 0; int j = 0;
      while(i < s2.length()){
        if(s1.charAt(i++) != s2.charAt(j++)){
          if(++diff > 1){
            return  false;
          }
        }
      }
    }
    return true;
  }
  public static void main(String args[]){
    String s1 = "pales";
    String s2 = "ales";
    onediff od = new onediff();


    System.out.println(od.isOneDiff(s1,s2));
  }
}
