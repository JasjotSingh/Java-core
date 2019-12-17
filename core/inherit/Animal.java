import java.util.*;

class Animal{
  private int height;
  private double weight;
  private String animalType;

  Animal(){
    this.height = 0;
    this.weight = 0;
    this.animalType = "no type";
  }
  Animal(int height, double weight, String animalType){
    this.height = height;
    this.weight = weight;
    this.animalType = animalType;
  }
  public int getHeight(){
    return this.height;
  }
  public double getWeight(){
    return this.weight;
  }
  public String getAnimalType(){
    return this.animalType;
  }
  @Override
  public String toString(){
    return "Animal : [height : "+getHeight()+", weight : "+getWeight()+", animalType : "+getAnimalType()+"]";
  }
}
