import java.util.*;

class Student implements Comparable<Student>{
  int rollnum;
  String name;
  int score;
  Student(int rollnum, String name, int score){
    this.rollnum = rollnum;
    this.name = name;
    this.score = score;
  }

  int getRoll(){
    return this.rollnum;
  }
  int getScore(){
    return this.score;
  }
  String getName(){
    return this.name;
  }
  void setRoll(int rollnum){
    this.rollnum = rollnum;
  }
  void setScore(int score){
    this.score = score;
  }
  void setName(String name){
    this.name = name;
  }

  @Override
  public String toString(){
    return String.valueOf(this.rollnum+" :"+this.name+" :score - "+this.score);
  }
  @Override
  public int compareTo(Student st){
    return this.rollnum > st.getRoll()? 1: this.rollnum < st.getRoll()? -1 :0;
  }
}

class SortByScore implements Comparator<Student>{
  @Override
  public int compare(Student st1, Student st2){
    return st1.getScore() > st2.getScore()? 1: st1.getScore() < st2.getScore()? -1 :0;
  }
}

class PQstudent{
  public static void main(String args[]){
    //min heap by default, use reverseOrder ot reversed to get max heap.
    PriorityQueue<Student> pq = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Student> pq1 = new PriorityQueue<>((new SortByScore()).reversed()); //

    pq.offer(new Student(1,"sat",90));
    pq.offer(new Student(2,"dsw",85));
    pq.offer(new Student(3,"sat1",90));
    pq.offer(new Student(4,"dsw1",99));
    pq.offer(new Student(5,"sa23",70));
    pq.offer(new Student(6,"ds23",80));

    //addAll pq
    pq1.addAll(pq);

    System.out.println("Student based on roll: ");
    while(!pq.isEmpty()){
      System.out.println(pq.poll());
    }

    pq.addAll(pq1);
    System.out.println("Student based on score: ");
    while(!pq1.isEmpty()){
      System.out.println(pq1.poll());
    }

  }
}
