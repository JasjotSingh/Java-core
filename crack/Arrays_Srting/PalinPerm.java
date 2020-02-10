import java.util.*;
class Solution{
  void isPermPalin(String str){
    str = str.toLowerCase();
    HashMap<Character, Integer> hmp = new HashMap<>();
    char ar[] = str.toCharArray();

    int oddCount = 0;
    for(char c : ar){
      if(Character.isLetter(c)){
        hmp.put(c, (hmp.getOrDefault(c, 0)+1));
        if(hmp.get(c) % 2 == 0)
          oddCount--;
        else
          oddCount++;
      }
    }

    if(oddCount > 1){
      System.out.println("Nope");
      return;
    }
    System.out.println("yup");
    return;
  }
}

class PalinPerm{
  public static void main(String[] args) {
    String str = "Tact Coa";
    Solution sol = new Solution();
    sol.isPermPalin(str);
  }
}
