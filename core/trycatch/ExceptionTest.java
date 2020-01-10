import java.util.*;

class UserDefinedException extends Exception{
  UserDefinedException(){
    System.out.println("in UserDefinedException constructor");
  }
}
class MathTest{
  //needs to thro UserDefinedException in order to work, in this case since UserDefinedException
  //class extends from exception, we can also thro Exception instead of UserDefinedException.
  void devide(int x, int y)throws UserDefinedException{
    System.out.println(x/y);
    //this needs to be uncommented to see user defined exceptin.
    //throw new UserDefinedException();
  }
}
class ExceptionTest{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 1st value:");
    int x = sc.nextInt();
    System.out.println("Enter 2nd value:");
    int y = sc.nextInt();
    MathTest mt = new MathTest();

    try{
      mt.devide(x,y);
    }
    catch(UserDefinedException e){
      System.out.println(e);
    }
    //Exception is most genric , easy to use other subclasses from exception if used,
    //need to be added in a catch block before the Exception catch block below.
    catch(Exception e){
      System.out.println(e);
      //e.printStackTrace();
    }
  }
}
