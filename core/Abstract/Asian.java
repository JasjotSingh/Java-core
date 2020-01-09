
class Asian extends Person{
  Asian(){
    super();
  }

  Asian(String name){
    super(name, "Asian Strength");
  }

  public String walk(){
    return "like a humans from asia.";
  }

  @Override
  public String eats(){
    return "eats Asian food.";
  }

  @Override
  public String language(){
    return "speaks Asian Languages.";
  }
}
