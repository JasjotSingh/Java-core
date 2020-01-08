import java.util.*;

class AnimalTest{
  public static void main(String args[]){
    Croc cr = new Croc(6,300.23,32);
    Croc cr1 = new Croc();
    System.out.println(cr);
    System.out.println(cr1);

    Eal ea = new Eal(7,50.23,true, true, true);
    Eal ea1 = new Eal();
    System.out.println(ea);
    System.out.println(ea1);
  }
}
