enum ETest{
  ONE,TWO,THREE
}
class EnumTest{
  void someMethod(){
    System.out.println(ETest.TWO);
  }
  public static void main(String args[]){
    ETest et = ETest.ONE;
    System.out.println(et);
    new EnumTest().someMethod();
  }
}
