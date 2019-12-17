import java.util.*;



class MSort{

  private void merge(int ar[], int tmp[], int st, int en, int mid){
    int str = st;
    int ms = mid;
    int me = mid+1;
    int end = en;
    int k = st;
    while(str <= ms && me <= end){
      if(ar[str] < ar[me])
        tmp[k++] = ar[str++];

      else
        tmp[k++] = ar[me++];

    }
    while(str <= ms)
      tmp[k++] = ar[str++];

    while(me <= end)
      tmp[k++] = ar[me++];

    for(int i = st; i <= end; i++){
      ar[i] = tmp[i];
    }
  }
  public void mergesort1(int ar[], int tmp[], int st, int en){
    if(st >= en)
      return;
    int mid = (st+en)/2;
    mergesort1(ar,tmp,st,mid);
    mergesort1(ar,tmp,mid+1,en);
    merge(ar,tmp,st,en,mid);
  }
}
class MerSort{
  public static void main(String args[]){
    int ar[] = {43,2,12,5,67,8,5,54,3};
    int ar2[] = {98,56,4,323,69,80,8};

    int[] l1 = new int[ar.length];
    int[] l2 = new int[ar2.length];

    MSort m = new MSort();
    System.out.println("list ar before msort:");
    System.out.println(Arrays.toString(ar));
    m.mergesort1(ar,l1, 0,ar.length -1);
    System.out.println("list ar after msort:");
    System.out.println(Arrays.toString(ar));

    System.out.println("list ar2 before msort:");
    System.out.println(Arrays.toString(ar2));
    m.mergesort1(ar2,l2, 0,ar2.length -1);
    System.out.println("list ar after msort:");
    System.out.println(Arrays.toString(ar2));
  }
}
