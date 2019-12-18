import java.util.*;
import java.lang.*;

class floorCeiling{
  public static void main(String args[]){
    TreeSet<Integer> hset = new TreeSet<>(Arrays.asList(1,2,5,7));

    int ceil = hset.ceiling(4);
    System.out.println(ceil);
    int flor = hset.floor(4);
    System.out.println(flor);

  }
}
