
class Indian extends Asian{
  public Indian(){
    super();
  }

  public Indian(String name){
    super(name);
  }

  public String walk(){
    return "like a humans from india.";
  }

  @Override
  public String eats(){
    return "eats Indian food.";
  }

  public String sing(){
    return "sing indian songs.";
  }
}
