
class Eal extends Fish{
  private boolean shock;

  public Eal(){
    super();
    this.shock = false;
  }

  public Eal(int height, double weight, boolean fins, boolean deepsea, boolean shock){
    super(height, weight,fins, deepsea);
    this.shock = shock;
  }

  @Override
  public String toString(){
    return "Eal: ["+super.toString()+", shock: "+this.shock+"]";
  }
}
