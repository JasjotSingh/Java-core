
class Counter implements Runnable{
  int Threadno;
  Counter(int Threadno){
    this.Threadno = Threadno;
  }

  @Override
  public void run(){
    count();
  }

  public void count(){
    for(int i = 0; i < 10; i++){
      try{
        Thread.sleep(10);
      }
      catch(InterruptedException e){
        System.out.println(e);
      }
      System.out.println("Threadno: "+Threadno+" i: "+i);
    }
  }
}

class ThreadRunnable{
  public static void main(String args[]){
    Thread t1 = new Thread(new Counter(1));
    Thread t2 = new Thread(new Counter(2){
      @Override
      public void run(){
        for(int i = 11; i < 20; i++){
          try{
            Thread.sleep(10);
          }
          catch(InterruptedException e){
            System.out.println(e);
          }
          System.out.println("Threadno: "+Threadno+" i: "+i);
        }
      }
    });

    int strt = (int)System.currentTimeMillis();
    t1.start();
    t2.start();
    try{
      Thread.sleep(200);
    }
    catch(InterruptedException e){
      System.out.println(e);
    }
    int end = (int)System.currentTimeMillis();
    System.out.println("total time: "+(end-strt));
  }
}
