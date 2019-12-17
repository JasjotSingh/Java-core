import java.util.*;
<<<<<<< HEAD
//test comment//added on atom
=======
//test comment, will be deleted.on github
>>>>>>> fa9a6284065de1906b617cbcf37e151ab6c96c43
class ArrayTest{
  public static void main(String args[]){
    int[] ar = new int[2];
    ar[0] = 1;
    ar[1] = 2;

    int[] ar1 = ar;
    System.out.println(ar[0]+" "+ar[1]);
    System.out.println(ar1[0]+" "+ar1[1]);

    ar[0]= 2;
    System.out.println(ar[0]+" "+ar[1]);
    System.out.println(ar1[0]+" "+ar1[1]);
  }
}
