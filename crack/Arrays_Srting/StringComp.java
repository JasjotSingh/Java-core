/*case:
aabcccccaaa  -> a2b1c5a3.
have a count = 0;
have prev char = '#'
have retString = ""
iterate over the string
   if prev char != present char.
       if count != 0
           retstring = retstring+ prevchar+count.
       count = 1.
       prev = present char.
   else
       count++
//for last chars
retstring = retstring+ prevchar+count.
if retstring lenght == str lengths
    return str
return retstring.
*/
class Solution{
  void stringComp(String str){
    StringBuffer ret = new StringBuffer();
    int count = 0;

    for(int i = 0 ; i < str.length(); i++){
      count++;
      if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
        ret.append(str.charAt(i)).append(count);
        count = 0;
      }
    }

    if(ret.length() >= str.length()){
      System.out.println(str);
      return;
    }
    System.out.println(ret.toString());
  }
}
class StringComp{
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.stringComp("aabcccccaaa");
    sol.stringComp("abc");
    sol.stringComp("aabbcc");
  }
}
