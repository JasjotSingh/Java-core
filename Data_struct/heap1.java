import java.util.*;

class heap1{
  int heapsize;
  int curindx;
  int []hep;
  heap1(int size){
    this.heapsize = size;
    this.hep = new int[size];
    this.curindx = -1;
  }

  int getPIndx(int indx){
    if(indx == 0)
      return 0;
    return (indx-1)/2;
  }

  int getLeftIndx(int indx){
    return (2*indx)+1;
  }
  int getRightIndx(int indx){
    return (2*indx)+2;
  }

  void pushup(int indx){
    int pindx = getPIndx(indx);

    if(pindx == indx){
      return;
    }
    else if(hep[pindx] > hep[indx]){
        int tmp = hep[pindx];
        hep[pindx] = hep[indx];
        hep[indx] = tmp;
        pushup(pindx);
    }
  }
  void push(int val){
    if(curindx == heapsize -1){
      System.out.println("heap is full");
      return;
    }
    hep[++curindx] = val;
    pushup(curindx);
  }

  void pushdown(int indx){
      int lindx = getLeftIndx(indx);
      int rindx = getRightIndx(indx);

      if(lindx > curindx){
        return;
      }
      else if(rindx > curindx){
        //check left.
        if(hep[indx] > hep[lindx]){
          int tmp = hep[lindx];
          hep[lindx] = hep[indx];
          hep[indx] = tmp;
          pushdown(lindx);
        }
      }
      else{
        //get lowest of right and left indx, see if indx greater than lowest.
        if(hep[rindx] < hep[lindx]){
          if(hep[indx] > hep[rindx]){
            int tmp = hep[rindx];
            hep[rindx] = hep[indx];
            hep[indx] = tmp;
            pushdown(rindx);
          }
        }
        else{
          if(hep[indx] > hep[lindx]){
            int tmp = hep[lindx];
            hep[lindx] = hep[indx];
            hep[indx] = tmp;
            pushdown(lindx);
          }
        }
      }

  }

  void pop(){
    if(curindx == -1){
      System.out.println("heap empty.");
      return;
    }
    System.out.println(hep[0]);
    hep[0] = hep[curindx--];
    pushdown(0);
    return;
  }
}

class heap1main{
  public static void main(String args[]){
    heap1 hp = new heap1(8);
    hp.push(12);
    hp.push(43);
    hp.push(65);
    hp.push(3);
    hp.push(21);
    hp.push(5);


    for(int  i = 0; i < 8;i ++){
      hp.pop();
    }

    System.out.println("");
    
    hp.push(5);
    hp.push(543);
    hp.push(1);
    hp.push(0);

    for(int  i = 0; i < 8;i ++){
      hp.pop();
    }
  }
}
