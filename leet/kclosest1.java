import java.util.*;

//doing the same problem with int[][], instead od sorting based on integer.
class Solution1 {

    class SortByDist implements Comparator<int[][]>{
      @Override
      public int compare(int[][] point1, int[][] point2){
        int sum1 = (point1[0][0]*point1[0][0]) + (point1[0][1]*point1[0][1]);
        int sum2 = (point2[0][0]*point2[0][0]) + (point2[0][1]*point2[0][1]);

        return  sum1 - sum2;
      }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[][]> pq = new PriorityQueue<>(new SortByDist());
        for(int i = 0; i < points.length; i++){
          int pnt[][] = new int[1][];
          pnt[0][0] = points[i][0];
          pnt[0][1] = points[i][1];
          pq.add(pnt);
        }

        int ret[][] = new int[K][];
        int si = 0;
        while(!pq.isEmpty() && si < K){
          int [][]bk = pq.poll();
          ret[si][0] = bk[0][0];
          ret[si][1] = bk[0][1];
          si++;
        }
        return ret;
    }
}
class kClosest1{
  public static void main(String args[]){
    Solution sl = new Solution();
    int ar[][] = new int[4][2];
    ar[0][0] = 1;
    ar[0][1] = 3;
    ar[1][0] = -2;
    ar[1][1] = 2;
    ar[2][0] = 4;
    ar[2][1] = 3;
    ar[3][0] = 10;
    ar[3][1] = 2;
    int ret[][];
    ret = sl.kClosest(ar,3);
    for(int i = 0 ; i < ret.length; i++){

            System.out.println(ret[i][0] +" "+ ret[i][1]);
    }
  }
}
