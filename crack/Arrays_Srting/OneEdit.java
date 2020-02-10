//catch-
//1.do capital letters count as differences. (int his case no).
//2.
import java.util.*;

//1. if same length- chk to see if more than one char different.
//2. if different length, differenct already one, nothing should be different.
//2.1. if difference in length more than 1 then not one edit away.
class Solution{

  void oneEditAway(String s1, String s2){

    if(Math.abs(s1.length() - s2.length()) > 1){
      System.out.println("not one edit away.");
      return;
    }

    if(s1.length() == s2.length()){
      boolean diffFound = false;
      for(int i = 0 ; i < s1.length(); i++){
        if(s1.charAt(i) != s2.charAt(i)){
          if(diffFound){
            System.out.println("not one edit away.");
            return;
          }
          diffFound = true;
        }
      }
    }
    else{ // ple , pale.
      String frst = s1.length()<s2.length() ? s1 :s2;
      String sec = s1.length()<s2.length() ? s2 :s1;

      int index1 = 0;
      int index2 = 0;

      while(index1 < frst.length() && index2 < sec.length()){
        if(frst.charAt(index1) != sec.charAt(index2)){
          if(index1 != index2){
            System.out.println("not one edit away.");
            return;
          }
          index2++;
        }
        else{
          index1++;
          index2++;
        }
      }
    }
    System.out.println("one edit away.");
    return;
  }

  void oneEditCrack(String s1, String s2){
    if(Math.abs(s1.length() - s2.length()) > 1){
      System.out.println("not one edit away.");
      return;
    }

    String frst = s1.length()<s2.length() ? s1 :s2;
    String sec = s1.length()<s2.length() ? s2 :s1;

    int index1 = 0;
    int index2 = 0;
    boolean diffFound = false;

    while(index2 < sec.length() && index1 < frst.length()){
      if(frst.charAt(index1) != sec.charAt(index2)){
        if(diffFound){
          System.out.println("not one edit away.");
          return;
        }
        diffFound = true;
        if(frst.length() == sec.length()){
          index1++;
        }
      }
      else{
        index1++;
      }
      index2++;
    }
    System.out.println("one edit away.");
    return;
  }
}

class OneEdit{
  public static void main(String[] args) {
    String s1 = "pale";
    String s2 = "aled";
    Solution sol = new Solution();
    sol.oneEditAway(s1,s2);
    // sol.oneEditCrack(s1, s2);
  }
}
