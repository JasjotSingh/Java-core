import java.util.*;
class Emppq implements Comparable<Emppq>{
  int num;
  String name;
  Emppq(int num, String name){
    this.num = num;
    this.name = name;
  }

  int getNum(){
    return this.num;
  }
  String getName(){
    return this.name;
  }
  @Override
  public int compareTo(Emppq emp){
    return emp.name.compareTo(this.name);
  }

}
class Priorityqu{
  public static void main(String args[]){
    PriorityQueue<Emppq> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.add(new Emppq(23,"1frss"));
    pq.add(new Emppq(43,"4frss"));
    pq.add(new Emppq(54,"5frss"));
    pq.add(new Emppq(73,"2frss"));
    pq.add(new Emppq(13,"8frss"));

    while(!pq.isEmpty()){
      Emppq emp = pq.poll();
      System.out.println(emp.getNum()+" "+emp.getName());
    }

  }
}
