class A{
  A(){

  }
  public void comp(int a, String b){
    System.out.println("in non-static A.comp ");
    return;
  }
  public static void comp(String b, int a){
    System.out.println("in static A.comp ");
    return;
  }

}
class B extends A{
  B(){
    super();
  }

  public static void comp(String b, int a){
    System.out.println("in static B.comp ");
    return;
  }
  @Override
  public void comp(int a, String b){
    System.out.println("in non-static B.comp ");
    return;
  }
}
class InheritTest{
  public static void main(String args[]){
    A a= new B();
    a.comp(1,"sa");
    A.comp("sa",2);
    B.comp("ds",3);
  }
}
