import java.util.concurrent.*;

class SolThread implements Runnable{
  private static int num = 1;
  private static Object lock = new Object();

  private int max;
  private String text;
  private Boolean div3;
  private Boolean div5;
  SolThread(int max, Boolean div3, Boolean div5, String text){
    this.max = max;
    this.text = text;
    this.div3 = div3;
    this.div5 = div5;
  }

  @Override
  public void run(){
    fizzBuzz();
  }

  private void fizzBuzz(){
    while(true){
      synchronized(lock){
        if(num > max)
          break;

        if( (num % 3==0) == div3 && (num % 5==0) == div5){
          switch(this.text){
            case "":
              System.out.println(num);
              break;
            default:
              System.out.println(this.text +" "+num);
          }
          num++;
        }
      }
    }
  }
}

class FizzBuzz{
  public static void main(String[] args) {
    ExecutorService serv = Executors.newFixedThreadPool(4);
    serv.execute(new SolThread(25, true, false, "fizz"));
    serv.execute(new SolThread(25, false, true, "buzz"));
    serv.execute(new SolThread(25, true, true, "fizzbuzz"));
    serv.execute(new SolThread(25, false, false, ""));

    serv.shutdown();
  }

}
