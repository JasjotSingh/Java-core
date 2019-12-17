import java.util.*;

class Empll implements Comparable<Empll>{
  int num;
  String name;
  Empll(int num, String name){
    this.num = num;
    this.name = name;
  }

  int getNum(){
    return num;
  }
  String getName(){
    return name;
  }
  void setNum(int num){
    this.num = num;
  }
  void setName(String name){
    this.name = name;
  }

  @Override
  public int compareTo(Empll emp){
    if(this.num == emp.num)
      return 0;
    else if(this.num > emp.num)
      return 1;
    return -1;
  }
}

class sortByName implements Comparator<Empll>{
  @Override
  public int compare(Empll emp1, Empll emp2){
    return emp1.name.compareTo(emp2.name);
  }
}

class LinkedL{
  public static void main(String args[]){
    LinkedList<Empll> emp = new LinkedList<>();
    emp.push(new Empll(32,"ewff"));
    emp.add(new Empll(24,"wfdf"));
    emp.addFirst(new Empll(54,"12fr"));
    emp.addLast(new Empll(565,"jkds"));

    //iterate
    System.out.println("iterator ll:");
    Iterator<Empll> itr = emp.iterator();
    while(itr.hasNext()){
      Empll e = itr.next();
      System.out.println(e.num+" "+e.name);
    }

    //sort comparable.
    System.out.println("\ncomparable sort ll:");
    Collections.sort(emp);
    for(Empll e: emp)
      System.out.println(e.num+" "+e.name);

    //sort comparable.
    System.out.println("\ncomparator sort ll:");
    Collections.sort(emp, new sortByName());
    for(Empll e: emp)
      System.out.println(e.num+" "+e.name);

    //remove
    System.out.println("\nremove pop: "+emp.pop().getName());
    System.out.println("remove removeLast: "+emp.removeLast().getName());
    System.out.println("remove(0) at indx 0: "+emp.remove(0).getName());
    System.out.println("remove poll :"+emp.poll().getName());

    System.out.println(String.valueOf(emp.isEmpty()));
  }
}
