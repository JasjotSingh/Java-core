import java.util.*;

class SelSort{
  public void swp(int ne[], int min, int indx){
    int temp = ne[indx];
    ne[indx] = ne[min];
    ne[min] = temp;
  }
  public static void main(String args[]){
    int ne[] = {65,2,31,87,0,65,3};
    SelSort in = new SelSort();
    System.out.println("unsorted list: ");
    System.out.println(Arrays.toString(ne));

    int min = Integer.MIN_VALUE;
    for(int i = 0 ;i < ne.length - 1 ; i++){
      min = i;
      for(int j = i+1; j < ne.length; j++){
        if(ne[min] > ne[j]){
          min = j;
        }
      }
      if(min != i)
        in.swp(ne, min, i);
    }

    System.out.println("list after sort:");
    System.out.println(Arrays.toString(ne));
  }
}
