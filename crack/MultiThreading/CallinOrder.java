import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// class Foo{
//
//   Lock lock = new ReentrantLock();
//
//   Condition first = lock.newCondition();
//   Condition second = lock.newCondition();
//   Boolean firstLock;
//   Boolean secondLock;
//
//   public Foo(){
// firstLock = false;
// secondLock  =false;
//   }
//   public void first(){
//     lock.lock();
//       System.out.println("first");
//       firstLock = true;
//       first.signal();
//     lock.unlock();
//   }
//   public void second(){
//     lock.lock();
//     while(!firstLock){
//       try {
//         first.await();
//       } catch(Exception e) {
//         e.printStackTrace();
//       }
//     }
//
//       System.out.println("second");
//       secondLock = true;
//       second.signal();
//     lock.unlock();
//   }
//   public void third(){
//     lock.lock();
//     while(!secondLock){
//       try {
//         second.await();
//       } catch(Exception e) {
//         e.printStackTrace();
//       }
//     }
//       System.out.println("third");
//     lock.unlock();
//   }
// }

class Foo{

  Semaphore sem;

  public Foo(){
    sem  = new Semaphore(2);

    try {
      sem.acquire(2);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public void first(){
    System.out.println("first: "+sem.availablePermits());
    System.out.println("first");
    sem.release(1);
  }
  public void second(){
    try {
      System.out.println("second: "+sem.availablePermits());
      sem.acquire(1);
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("second");
    sem.release(2);

  }
  public void third(){
    try {
      System.out.println("three: "+sem.availablePermits());
      sem.acquire(2);
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("third");
    sem.release(2);
  }
}

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
