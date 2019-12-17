import java.util.*;

class Counter extends Thread{
  int Threadno;
  Counter(int no){
    this.Threadno = no;
  }

//run method should be run by jvm
//we use strt to create and start the thread(runable state).
//start then puts the thread in running state by calling run.
//the itr methods has a sleep, so when one thread sleeps we run the other thread.
  @Override
  public void run(){
    itr();
  }

  public void itr(){
    for(int i = 0 ; i < 10; i++){
      try{
        sleep(100);
      }
      catch(InterruptedException e){
        System.out.println(e);
      }
      System.out.println("i: "+i+" thread no:"+Threadno);
    }
  }
}

class ThreadItr{
  public static void main(String args[]){
    Counter c1 = new Counter(1);
    Counter c2 = new Counter(2);

    int strt = (int)System.currentTimeMillis();
    c1.start();
    System.out.println("");
    c2.start();

    //here since the above two calls are being changes to thread, we need to make the main thread so to sleep,
    //other wise it will compute the total time evenbefore the above two threads are done running.
    try{
      Thread.sleep(1000);
    }
    catch(InterruptedException e){
      System.out.println(e);
    }
    int end = (int)System.currentTimeMillis();
    System.out.println("total time: "+(end-strt));
  }
}
