import java.util.concurrent.*;
import java.util.concurrent.locks.*;

//===========USING LOCKS=============//

class Foo{

  Lock lock = new ReentrantLock();
  Condition first = lock.newCondition();
  Condition second = lock.newCondition();
  Boolean firstLock;
  Boolean secondLock;

  public Foo(){
    firstLock = true;
    secondLock = true;
  }
  public void first(){
    lock.lock();

    try{
      System.out.println("first");

      firstLock = false;
      first.signal();
    }
    finally{
      //should always be called from a finally block,
      //in case try block throws exception, we will always release lock.
      //otherwise we ll return without releasing lock.
      lock.unlock();
    }
  }
  public void second(){
    lock.lock();
    try {

      while(firstLock){
        first.await();
      }

      System.out.println("second");

      secondLock = false;
      second.signal();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    finally{
      //should always be called from a finally block,
      //in case try block throws exception, we will always release lock.
      //otherwise we ll return without releasing lock.
      lock.unlock();
    }

  }
  public void third(){
    lock.lock();
    try{

      while(secondLock){
        second.await();
      }

      System.out.println("third");
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    finally{
      //should always be called from a finally block,
      //in case try block throws exception, we will always release lock.
      //otherwise we ll return without releasing lock.
      lock.unlock();
    }
  }
}


//===========USING SEMAPHORES ============//
// class Foo{
//
//   Semaphore sem1;
//   Semaphore sem2;
//
//   public Foo(){
//     sem1  = new Semaphore(1);
//     sem2  = new Semaphore(1);
//
//     try {
//       //lock both sempahores.
//       sem1.acquire();
//       sem2.acquire(1);
//     } catch(Exception e) {
//       e.printStackTrace();
//     }
//   }
//   public void first(){
//
//     System.out.println("first");
//     //release sem1
//     sem1.release();
//   }
//   public void second(){
//     try {
//       //acquire sem1
//       sem1.acquire();
//     } catch(Exception e) {
//       e.printStackTrace();
//     }
//     System.out.println("second");
//     //release sem1 and sem2.
//     sem1.release();
//     sem2.release(1);
//
//   }
//   public void third(){
//     try {
//       //acquire sem2
//       sem2.acquire(1);
//     } catch(Exception e) {
//       e.printStackTrace();
//     }
//     System.out.println("third");
//     // release sem2
//     sem2.release(1);
//   }
// }

class CallinOrder{
  public static void main(String[] args) {
    Foo foo = new Foo();
    ExecutorService service = Executors.newFixedThreadPool(3);

    service.execute(new Runnable(){
      @Override
      public void run(){
        foo.third();
      }
    });

    service.execute(new Runnable(){
      @Override
      public void run(){
        foo.second();
      }
    });

    service.execute(new Runnable(){
      @Override
      public void run(){
        foo.first();
      }
    });

    service.shutdown();
  }
}
