//catch: 1.can all strings be converted to lower case, so cat and TAC are permutations.?
//2. consider white spaces? no in this case.
//3. is "c  a  t   " a valid string?

import java.util.*;

class Solution{
  //1.convert to lower case,
  //2.remove leading and trailing white spaces.
  //2.compare lengths nw. if not same not perm.
  //3.sort both strings.
  //4.compare.
  void sortnCompare(String s1, String s2){
    s1 = s1.toLowerCase().trim();
    s2 = s2.toLowerCase().trim();
    if(s1.length() != s2.length()){
      System.out.println("not a perm");
      return;
    }

    char ar1[] = s1.toCharArray();Arrays.sort(ar1);
    char ar2[] = s2.toCharArray();Arrays.sort(ar2);
    s1 = new String(ar1);
    s2 = new String(ar2);


    if(s1.compareTo(s2) == 0)
      System.out.println("is a perm");
    else
      System.out.println("not a perm");
  }

  //1.convert to lower case,
  //2.remove leading and trailing white spaces.
  //2.compare lengths nw. if not same not perm.
  //3.cout both string chars.
  //4.compare.
  void countnCompare(String s1, String s2){
    s1 = s1.toLowerCase().trim();
    s2 = s2.toLowerCase().trim();

    if(s1.length() != s2.length()){
      System.out.println("not a perm");
      return;
    }

    HashMap<Character, Integer> hmp1 = new HashMap<>();

    for(int i = 0 ; i < s1.length() ;i++){
      hmp1.put(s1.charAt(i), (hmp1.getOrDefault(s1.charAt(i), 0) + 1));
    }
    for(int i = 0 ; i < s2.length() ;i++){
      hmp1.put(s2.charAt(i), (hmp1.getOrDefault(s2.charAt(i), 0) - 1));
    }

    for(int i : hmp1.values()){
      if(i != 0){
        System.out.println("not a perm");
        return;
      }
    }
    System.out.println("is a perm");
  }
}
class ChkPerm{
  public static void main(String args[]){
    String st1 = "cdat   ";
    String st2 = "Tac";

    Solution sol = new Solution();
    sol.sortnCompare(st1, st2);
    sol.countnCompare(st1, st2);
  }
}
