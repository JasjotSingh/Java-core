import java.util.*;


class Animal{
  String name;
  long tstmp;
  int type;
  Animal(String name, int type){
    this.name = name;
    Date dt = new Date();
    this.tstmp = dt.getTime();
    this.type = type;
  }

  public String getName(){
    return this.name;
  }
  public int getType(){
    return this.type;
  }
  public long getTime(){
    return this.tstmp;
  }
}
class Dog extends Animal{

  Dog(String name){
    super(name,1);
  }
}

class Cat extends Animal{

  Cat(String name){
    super(name,2);
  }

}

class AniShel{
  LinkedList<Dog> dlist;
  LinkedList<Cat> clist;

  AniShel(){
    dlist = new LinkedList<>();
    clist = new LinkedList<>();
  }

  void add(Animal an){
    if(an.getType() == 1){
      dlist.add((Dog)an);
    }
    else{
      clist.add((Cat)an);
    }
  }

  void getAny(){
    if(dlist.size() == 0){
      Cat ct = clist.getFirst();
      dlist.remove(ct);
      System.out.println("get1 "+ct.getName());
      return;
    }
    else if(clist.size() == 0){
      Dog dg = dlist.getFirst();
      dlist.remove(dg);
      System.out.println("get1 "+dg.getName());
      return;
    }

    Dog dg = dlist.getFirst();
    Cat ct = clist.getFirst();

    if(dg.getTime() < ct.getTime()){
      dlist.remove(dg);
      System.out.println("get "+dg.getName());
    }
    else{
      clist.remove(ct);
      System.out.println("get "+ct.getName());
    }
  }

  void display(){
    for(int i = 0 ; i < dlist.size(); i++){
      Dog dg = dlist.get(i);
      System.out.println(dg.getName()+" "+dg.getTime());
    }
    for(int i = 0 ; i < clist.size(); i++){
      Cat ct = clist.get(i);
      System.out.println(ct.getName()+" "+ct.getTime());
    }
  }

  public static void main(String args[]){
    AniShel as = new AniShel();
    as.add(new Dog("oban"));
    as.add(new Cat("billu"));
    as.add(new Dog("sheru"));

    as.display();
    System.out.println("get any");
    as.getAny();
    as.getAny();
    as.getAny();
  }
}
