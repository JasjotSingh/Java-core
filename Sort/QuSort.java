import java.util.*;

class QSort{

  private int pivot(int ar[], int st, int en){
    int pindx = (st+en)/2;
    int piv = ar[pindx];

   //System.out.println(st+" "+en+" :");
    while(st < en){
      while(ar[st] < piv)
        st++;
      while(ar[en] > piv)
        en--;
      if(ar[st] == ar[en])
        st++;
      if(st < en){
        int temp = ar[st];
        ar[st] = ar[en];
        ar[en] = temp;
      }
    }
    System.out.println("piv :"+piv+" "+Arrays.toString(ar));
    return en;
  }

  public void qSort(int ar[], int strt, int end){
    System.out.println(strt+" "+end+" :");
    if(strt >= end)
      return;

    int piv_indx = pivot(ar, strt, end);
    qSort(ar,strt,piv_indx -1);
    qSort(ar,piv_indx+1,end);
  }
}

class QuSort{
  public static void main(String args[]){
    QSort q = new QSort();
    int ar[] = {65,1,11,0,34,12,98,6,11,32,1,2,5};
    System.out.println("list before sort: ");
    System.out.println(Arrays.toString(ar));

    q.qSort(ar,0,ar.length - 1);

    System.out.println("list after sort: ");
    System.out.println(Arrays.toString(ar));

  }
}
