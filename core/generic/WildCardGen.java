import java.util.*;

class Vehical{
  private int vid;

  Vehical(){
    this.vid = 0;
  }
  Vehical(int vid){
    this.vid = vid;
  }

  public int getVehicalid(){
    return this.vid;
  }
  @Override
  public String toString(){
    return "Vehical: [Vehical_id: "+getVehicalid()+" ]";
  }

  /*
  static <T extends Vehical> void display(List<T> vlst){
    for(T v: vlst)
      System.out.println(v);
  }*/

  //using wild card , we can make use of extends(upper bound) and super (lower bound),
  //in case we do not know the type of object will be passed in.
  // we can also do as above example.
  static void display(List<? extends Vehical> vlst){
    for(Vehical v: vlst)
      System.out.println(v);
  }
}

class Car extends Vehical{
  private String carModel;

  Car(){
    super();
    this.carModel = "***";
  }

  Car(int vid, String carModel){
    super(vid);
    this.carModel = carModel;
  }

  public String getCarModel(){
    return this.carModel;
  }

  @Override
  public String toString(){
    return "Car: ["+super.toString()+", Car_model: "+getCarModel()+" ]";
  }
}

class WildCardGen{
  public static void main(String args[]){
    List<Vehical> vlst = new ArrayList<>();
    vlst.add(new Car(12,"super"));
    vlst.add(new Car(13,"extra super"));
    vlst.add(new Car(10,"super delux"));
    vlst.add(new Car(19,"awsome"));
    vlst.add(new Vehical(1));

    Vehical.display(vlst);
  }

}
