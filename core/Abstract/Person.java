
public abstract class Person implements Action{
  private String name;
  private String bodyStrength;

  public Person(){
    this.name = "no name";
    this.bodyStrength = "weak";
  }

  public Person(String name, String bodyStrength){
    this.name = name;
    this.bodyStrength = bodyStrength;
  }

  public abstract String eats();
  public abstract String language();

  public String walk(){
    return "walk like human";
  }

  public String sing(){
    return "sings songs";
  }
}
