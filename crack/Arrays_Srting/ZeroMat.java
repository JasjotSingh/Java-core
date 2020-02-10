import java.util.*;
class Solution{
  void ZeroMat(int mat[][]){
    List<Integer> row = new ArrayList<>();
    List<Integer> col = new ArrayList<>();

    for(int i = 0 ; i < mat.length; i++){
      for(int j = 0 ; j < mat[i].length; j++){
        if(mat[i][j] == 0){
          row.add(i);
          col.add(j);
        }
      }
    }

    for(int i : row){
      for(int j = 0; j < mat[i].length; j++){
        mat[i][j] = 0;
      }
    }
    for(int j : col){
      for(int i = 0; i < mat.length; i++){
        mat[i][j] = 0;
      }
    }
    for(int i = 0; i < mat.length; i++){
      for(int j = 0 ; j < mat[i].length; j++){
        System.out.print(" ");
        System.out.print(mat[i][j]);
      }
      System.out.println("");
    }
  }
}
class ZeroMat{
  public static void main(String[] args) {
    int mat[][] = {{ 1, 2, 3, 4,5},
                    { 5, 7, 7, 0,9},
                    { 9,0,11,12,13},
                    {13,0,15,16,0},
                    {18,19,20,21,22}};

    Solution sol = new Solution();
    sol.ZeroMat(mat);
  }
}
