import java.util.*;
class Solution {
    class SortByDistance implements Comparator<Integer>{
        int ar [][];
        SortByDistance(int[][] pnts){
            ar = new int [pnts.length][pnts[0].length];
            for(int i = 0 ; i < pnts.length; i++){
                for(int j = 0 ; j < pnts[i].length; j++){
                    this.ar[i][j] = pnts[i][j];
                }
            }
        }
        @Override
        public int compare(Integer i1, Integer i2){
            int sum1 = (ar[i1][0] * ar[i1][0]) + (ar[i1][1] * ar[i1][1]);
            int sum2 = (ar[i2][0] * ar[i2][0]) + (ar[i2][1] * ar[i2][1]);

            return sum1 > sum2 ? 1: sum1 < sum2?-1: 0;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new SortByDistance(points));
        int ret[][] = new int[K][2];
        int siz = 0;
        for(int i = 0 ; i < points.length; i++){
            pq.add(i);
        }

        while(!pq.isEmpty() && siz < K){
            int i = pq.poll();
            int ar[]  =new int[2];
            ar[0] = points[i][0];
            ar[1] = points[i][1];
            ret[siz] = ar;
            siz++;
        }

        return ret;
    }
}
class kclosestpnt{
  public static void main(String args[]){
    Solution sl = new Solution();
    int ar[][] = new int[2][2];
    ar[0][0] = 1;
    ar[0][1] = 3;
    ar[1][0] = -2;
    ar[1][1] = 2;
    int ret[][];
    ret = sl.kClosest(ar,1);
    for(int i = 0 ; i < ret.length; i++){

            System.out.println(ret[i][0] +" "+ ret[i][1]);
    }
  }
}
