import java.util.*;
//catch: are strings, lowercase or different cases are allowed.
class Solution{
  void extraSpace(String str){
    //create a hash set, add char in hs as we see them, if already seen, print not uniq.
    HashSet<Character> hs = new HashSet<>();
    for(int i = 0; i < str.length();i++){
      char c = str.charAt(i);
      if(hs.contains(c)){
        System.out.println("not uniq");
        return;
      }
      hs.add(c);
    }
    System.out.println("uniq");
  }

  void noExtraSpace(String str){
    //go over all elements and for each check the str to find the duplicate.
    //will take n^2 time.
    //can also sort (using a sort algo that does not take extra space, quick sort maybe), then iterate over the string to find
    //same neighbours, n log(n) for sort and n for find. n + n log(n) time. 
  }
}

class isUniq{
  public static void main(String args[]){
    String str = "abcdacdea";
    Solution sol  = new Solution();
    sol.extraSpace(str);
    //sol.noExtraSpace(str);
  }
}
