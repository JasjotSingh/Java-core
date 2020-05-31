import java.util.*;
class Emp implements Comparable<Emp>{
  int num;
  String name;
  Emp(int num, String name){
    this.num = num;
    this.name = name;
  }
  int getEnum(){
    return this.num;
  }
  String getName(){
    return this.name;
  }
  void setEnum(int num){
    this.num = num;
  }
  void setName(String name){
    this.name = name;
  }

  @Override
  public int compareTo(Emp emp){
    if(this.num == emp.num){
      return 0;
    }
    else if(this.num > emp.num){
      return 1;
    }

    return -1;
  }
}

class sortByName implements Comparator<Emp>{
  @Override
  public  int compare(Emp emp1, Emp emp2){
    return emp1.name.compareTo(emp2.name);
  }
}
class ArrayL{
  public static void main(String args[]){
    //constructors:
    ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(4,5,62,1,3));
    ArrayList<Emp> ar1 = new ArrayList<>();

    ar1.add(new Emp(23,"jasjot"));
    ar1.add(new Emp(43,"dsa"));
    ar1.add(new Emp(21,"dsda"));

    //iterator.
    Iterator<Integer> itr = ar.iterator();
    while(itr.hasNext()){
      System.out.println(itr.next());
    }

    //sort
    System.out.println("\n"+"sort:");
    Collections.sort(ar);
    for(int x: ar){
      System.out.println(x);
    }

    System.out.println("\nempclass list: ");
    for(Emp e: ar1){
      System.out.println(e.getEnum()+" "+e.getName());
    }

    //comparable --
    //look at https://www.concretepage.com/java/example-collections-reverseorder-java. good resource.
    System.out.println("\ncomparable sorted empclass list: ");
    Collections.sort(ar1,Collections.reverseOrder());
    for(Emp e: ar1){
      System.out.println(e.getEnum()+" "+e.getName());
    }

    //comparator --
    System.out.println("\ncomparator sorted empclass list: ");
    Collections.sort(ar1, new sortByName());
    for(Emp e: ar1){
      System.out.println(e.getEnum()+" "+e.getName());
    }

    System.out.println("\nreversed comparator sorted empclass list: ");
    Collections.sort(ar1, (new sortByName()).reversed());
    for(Emp e: ar1){
      System.out.println(e.getEnum()+" "+e.getName());
    }

    System.out.println("\ncomparator.comparing sorted empclass list: ");
    Collections.sort(ar1, Comparator.comparing(Emp::getName));
    for(Emp e: ar1){
      System.out.println(e.getEnum()+" "+e.getName());
    }

    //clear
    System.out.println("\nclear arrlist");
    ar.clear();
    System.out.println(ar);
  }
}
