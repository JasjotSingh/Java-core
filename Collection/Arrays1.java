import java.util.*;

class Employ implements Comparable<Employ>{
  int num;
  String name;
  Employ(int  num, String name){
    this.num = num;
    this.name = name;
  }

  void setNum(int num){
    this.num = num;
  }
  void setName(String name){
    this.name = name;
  }
  int getNum(){
    return this.num;
  }
  String getName(){
    return this.name;
  }

  @Override
  public String toString(){
    return (String)(this.num+" : "+this.name );
  }

  @Override
  public int compareTo(Employ emp){
    return this.name.compareTo(emp.name);
  }
}

class SortByNum implements Comparator<Employ>{
  @Override
  public int compare(Employ emp1, Employ emp2){
    return emp1.getNum() > emp2.getNum()?1:emp1.getNum() < emp2.getNum()?-1:0;
  }
}

class Arrays1{
  public static void main(String args[]){
    ArrayList<Employ> ar = new ArrayList<>();
    ArrayList<Employ> ar2 ;
    ArrayList<Integer> ar1 = new ArrayList<>(Arrays.asList(2,3,5,12,5,43,23));

    //iterator
    Iterator<Integer> itr = ar1.iterator();
    while(itr.hasNext()){
      System.out.println(itr.next());
    }

    System.out.println("for loop for ar1:");
    for(Integer x : ar1){
      System.out.println(x);
    }

    //add
    Employ ep1 = new Employ(23,"abc");
    ar.add(ep1);
    ep1 = new Employ(54,"bcd");
    ar.add(0,ep1);
    ep1 = new Employ(2,"cde");
    ar.add(1,ep1);
    ep1 = new Employ(0,"def");
    ar.add(1,ep1);

    for(Employ emp : ar){
      System.out.println(emp);
    }

    //sublist
    //do this instead of assiging ar2 = sublist.
    ar2 = new ArrayList(ar.subList(1,ar.size()));


    //remove
    System.out.println("After remove: ");
    ar.remove(ep1);
    ar.remove(0);
    for(Employ emp : ar){
      System.out.println(emp);
    }


    //for loop with get
    for(int i = 0; i < ar2.size(); i++){
      System.out.println("for loop ar2: "+ar2.get(i));
    }
    
    //toarray
    System.out.println("Convert to array: ");
    Object oar[] = ar.toArray();
    System.out.println(Arrays.toString(oar));

    System.out.println("ar2 from addall from index 1: ");
    //ar2.remove(1);
    System.out.println(ar2+" "+ar );

    //sort comparable for classes.
    Collections.sort(ar2, Collections.reverseOrder());
    //Collections.sort(ar2);
    System.out.println("comparable: "+ar2);

    //sort Comparator for classes.
    Comparator cmp = new SortByNum();
    Collections.sort(ar2,cmp.reversed());
    System.out.println("comparator: "+ar2);
  }
}
