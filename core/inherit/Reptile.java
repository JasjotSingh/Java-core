import java.util.*;

public class Reptile extends Animal{
  private String skinType;
  private boolean backBone;
  private String eggType;

  Reptile(){
    super();
    this.skinType = "no type";
    this.backBone = false;
    this.eggType = "no type";
  }

  Reptile(int height, double weight, String animalType, String skinType, boolean backBone, String eggType){
    super(height, weight, animalType);
    this.skinType = skinType;
    this.backBone = backBone;
    this.eggType = eggType;
  }

  public String getSkinType(){
    return this.skinType;
  }

  public boolean getBackBone(){
    return this.backBone;
  }

  public String getEggType(){
    return this.eggType;
  }

  @Override
  public String toString(){
    return "Reptile: [ "+super.toString()+", skinType :"+getSkinType()+", backBone : "+getBackBone()+", eggType : "+getEggType()+"]";
  }
}
