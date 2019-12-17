import java.util.*;

class sortByString implements Comparator<String>{
  @Override
  public int compare(String s1, String s2){
    return s1.compareTo(s2);
  }
}
class Treeset{
  public static void main(String args[]){
    TreeSet<String> tset = new TreeSet<>(new sortByString());


    tset.add("zfdfd");
    tset.add("43ghfhjv");
    tset.add("iow w");
    for(String s: tset)
      System.out.println(s);
  }
}
