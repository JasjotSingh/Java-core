

class Fish extends Animal{
  private boolean fins;
  private boolean deepsea;

  public Fish(){
    super();
    this.fins = true;
    this.deepsea = false;
  }

  public Fish(int height, double weight, boolean fins, boolean deepsea){
    super(height, weight, "Fish");
    this.fins = fins;
    this.deepsea = deepsea;
  }

  @Override
  public String toString(){
    return "Fish: [ "+super.toString()+", Fins: "+this.fins+", deepsea: "+this.deepsea+"]";
  }
}
