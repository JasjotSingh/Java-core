import java.util.*;

class Croc extends Reptile{

  private int count;

  Croc(){
    super();
    this.count = 0;
  }

  Croc(int height, double weight, int count){
    super(height, weight,"reptile","hard scales",true,"Hard Shell");
    this.count = count;
  }

  @Override
  public String toString(){
    return "Croc: ["+super.toString()+", count : "+this.count+"]";
  }
}
