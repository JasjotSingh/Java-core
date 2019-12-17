import java.util.*;

class Croc extends Reptile{

  private int count;

  Croc(){
    super();
    this.count = 0;
  }

  Croc(int height, double weight, String animalType, String skinType, boolean backBone, int count){
    super(height, weight,animalType,skinType,backBone,"Hard Shell");
    this.count = count;
  }

  @Override
  public String toString(){
    return "Croc: ["+super.toString()+", count : "+this.count+"]";
  }
}
