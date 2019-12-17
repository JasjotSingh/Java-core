import java.util.*;

class TStack{
  int []stk;
  int indx1;
  int indx2;
  int cap;
  TStack(int cap){
    stk = new int[cap];
    indx1 = -1;
    indx2 = cap;
    this.cap = cap;
  }

  public void push(int val, int st){
    if(st == 1){
      if(++indx1 == indx2){
        System.out.println("Stack1 full, can not add elem.");
        --indx1;
        return;
      }
      stk[indx1] = val;
    }
    else{
      if(--indx2 == indx1){
        System.out.println("Stack2 full, can not add elem.");
        ++indx2;
        return;
      }
      stk[indx2] = val;
    }
  }

  public int pop(int st){
    if(st == 1){
      if(indx1 < 0){
        System.out.print("Stack1 empty.");
        return -1;
      }
      return stk[indx1--];
    }
    else{
      if(indx2 >= cap){
        System.out.print("Stack2 empty.");
        return -1;
      }
      return stk[indx2++];
    }
  }
}

class TwoStack{
  public static void main(String args[]){
    TStack ts = new TStack(5);
    ts.push(2,1);
    ts.push(3,1);
    ts.push(2,1);
    ts.push(3,1);
    ts.push(2,1);
    ts.push(3,2);
    ts.push(2,1);
    ts.push(3,2);
    ts.push(2,1);
    ts.push(3,2);

    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));

    ts.push(5,1);
    ts.push(6,2);
    ts.push(5,1);
    ts.push(6,2);
    ts.push(5,1);
    ts.push(6,2);
    ts.push(5,1);
    ts.push(6,2);
    ts.push(5,1);
    ts.push(6,2);

    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
  }
}
