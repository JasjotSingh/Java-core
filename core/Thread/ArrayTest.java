class Solution implements Runnable{
  int arlen = 0;
  int synindx = 0;
  int ar[];
  Solution(int ar[]){
    arlen = ar.length;
    this.ar = ar;
  }

  @Override
  public void run(){
    fill();
  }

  synchronized void fill(){
    while(synindx < arlen){
      ar[synindx] = synindx;
      synindx++;
    }
  }
}

class Solution1 implements Runnable{
  int arlen = 0;
  int oddindx = 1;
  int evenindx = 0;
  int synindx = 0;
  int ar[];
  Solution1(int ar[]){
    arlen = ar.length;
    this.ar = ar;
  }

  @Override
  public void run(){
    fill();
  }

  void fill(){
    if("1" == Thread.currentThread().getName()){
      ar[evenindx] = evenindx;
      evenindx += 2;
    }
    else{
      ar[oddindx] = oddindx;
      oddindx += 2;
    }
  }
}

class ArrayTest{
  public static void main(String[] args) {
    int ar[] = new int[100000];
    Solution sol = new Solution(ar);
    Solution1 sol1 = new Solution1(ar);
    Thread t1 = new Thread(sol);
    Thread t2 = new Thread(sol);

    long strt = System.currentTimeMillis();
    try{
      Thread.sleep(1000);
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }

    t1.start();
    t2.start();
    try{
      t1.join();
      t2.join();
    }
    catch(Exception e){
      e.printStackTrace();
    }

    long end = System.currentTimeMillis();

    System.out.println("\n\n\n\n*****************************************");
    System.out.println("total time synchro method1: "+(end - strt));
    System.out.println("*****************************************\n\n\n\n");

    t1 = new Thread(sol1);
    t2 = new Thread(sol1);
    t1.setName("1");
    t2.setName("2");
    strt = System.currentTimeMillis();
    try{
      Thread.sleep(1000);
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }

    t1.start();
    t2.start();
    try{
      t1.join();
      t2.join();
    }
    catch(Exception e){
      e.printStackTrace();
    }

    end = System.currentTimeMillis();

    System.out.println("\n\n\n\n*****************************************");
    System.out.println("total time multi no synchro no lock method1: "+(end - strt));
    System.out.println("*****************************************\n\n\n\n");
    

    strt = System.currentTimeMillis();
    try{
      Thread.sleep(1000);
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }
    for(int i = 0 ; i < ar.length;i++){
      ar[i] = i;
    }
    end = System.currentTimeMillis();

    System.out.println("\n\n\n\n*****************************************");
    System.out.println("total time no multi method1: "+(end - strt));
    System.out.println("*****************************************\n\n\n\n");
  }
}
