import java.util.*;

class ChkPerm{

  private int pivot(char ar[], int st, int en){
    int pivindx = (st+en)/2;
    char piv = ar[pivindx];

    while(st < en){
      while(ar[st] < piv)
        st++;

      while(ar[en] > piv)
        en--;

      if(ar[st] == ar[en])
        st++;

      if(st < en){
        char temp = ar[st];
        ar[st] = ar[en];
        ar[en] = temp;
      }
    }

    return en;
  }
  public void QSort(char ar[], int st, int en){
    if(st >= en)
      return;

    int piv = pivot(ar, st, en);
    QSort(ar,st,piv);
    QSort(ar,piv+1,en);
  }

  public Boolean isPerm(String st1, String st2){
    char ar1[] = st1.toCharArray();
    char ar2[] = st2.toCharArray();

    QSort(ar1, 0, ar1.length -1 );
    QSort(ar2, 0, ar2.length -1 );

    st1 = Arrays.toString(ar1);
    st2 = Arrays.toString(ar2);

    System.out.println(st1);
    System.out.println(st2);

    return st1.equals(st2);

  }
  public static void main(String args[]){
    ChkPerm cp = new ChkPerm();
    String s1 = "got ds123";
    String s2 = "tog 132ad";

    System.out.println(cp.isPerm(s1,s2));
  }
}
