
class PersonTest{
  public static void main(String args[]){
    Person jas = new Indian("jas");
    System.out.println(jas.walk());
    System.out.println(jas.eats());
    System.out.println(jas.language());
    System.out.println(jas.sing());

    System.out.println("***************");
    Person zho = new Asian("zho");
    System.out.println(zho.walk());
    System.out.println(zho.eats());
    System.out.println(zho.language());
    System.out.println(zho.sing());
  }
}
