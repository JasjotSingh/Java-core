import java.util.*;

class heap{
  int heap[];
  int heapsize;
  int curindx;

  heap(int hsize){
    heap = new int[hsize];
    heapsize = hsize;
    curindx = -1;
  }

  private int getLeftCIndx(int indx){
    return (2*indx)+1;
  }

  private int getRightCIndx(int indx){
    return (2*indx)+2;
  }
  private int getParentIndx(int indx){
    return indx == 0 ? 0 : (indx-1)/2;
  }

  public void peek(){
    if(curindx >= 0 )
      System.out.println(heap[curindx]);
    else
      System.out.println("Heap Empty");
  }
  private void swap(int indxi, int indxj){
    int temp = heap[indxi];
    heap[indxi] = heap[indxj];
    heap[indxj] = temp;
  }
  private void heapup(int indx){
    int pindx = getParentIndx(indx);

    if(pindx == indx)
      return;

    if(heap[indx] > heap[pindx]){
      swap(indx,pindx);
    }
    heapup(pindx);
    return;
  }
  public void push(int val){
    if(curindx >= heapsize -1 ){
      System.out.println("heap size full");
    }
    else{
      heap[++curindx] = val;
      heapup(curindx);
    }
  }

  private void heapdown(int indx){
    int lindx = getLeftCIndx(indx);
    int rindx = getRightCIndx(indx);

    if(lindx > curindx)
      return;
    else if(rindx > curindx){
      if(heap[lindx] > heap[indx]){
        swap(lindx,indx);
        heapdown(lindx);
      }
    }
    else if(lindx <= curindx && rindx <= curindx){
      if(heap[rindx] > heap[lindx]){
        if(heap[rindx] > heap[indx]){
          swap(rindx,indx);
          heapdown(rindx);
        }
      }
      else{
        if(heap[lindx] > heap[indx]){
          swap(lindx, indx);
          heapdown(lindx);
        }
      }
    }
  }
  public void pop(){
    if(curindx >= 0){
      System.out.println(heap[0]);
      heap[0] = heap[curindx--];
      heapdown(0);
    }
    else{
      System.out.println("heap empty");
    }
  }
}
class heapTest{

  public static void main(String args[]){
    heap p = new heap(6);
    p.push(23);
    p.push(54);
    p.push(12);
    p.push(43);
    p.push(1212);
    p.push(89);
    p.push(755);

    p.pop();
    p.pop();
    p.pop();
    p.pop();
    p.pop();
    p.pop();
    p.pop();

    p.push(10);
    p.push(11);
    p.push(12);
    p.push(13);
    p.push(14);
    p.push(15);
    p.push(16);

    p.pop();
    p.pop();
    p.pop();
    p.pop();
    p.pop();
    p.pop();
    p.pop();
  }
}
