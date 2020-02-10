/*
  00 01 02 03
  10 11 12 13
  20 21 22 23
  30 31 32 33

  n-1-i  = 4-1-0 = 3
           4-1-1 = 2
  j-i    = 0-0 = 0
           1-0 = 1
           2-0 = 2
*/
class Solution{
  void RotMat(int mat[][]){
    int len = mat.length;
    for(int i = 0 ; i < len/2; i++){
      for(int j = i ; j < len - 1 - i; j++){
        int temp = mat[i][j];
        mat[i][j] = mat[len-1-j][i];
        mat[len-1-j][i] = mat[len-1-i][len-1-j];
        mat[len-1-i][len-1-j] = mat[j][len-1-i];
        mat[j][len-1-i] = temp;
      }
    }
    for(int i = 0; i < len; i++){
      for(int j = 0 ; j < len; j++){
        System.out.print(" ");
        System.out.print(mat[i][j]);
      }
      System.out.println("");
    }
  }
}

class RotMat{
  public static void main(String[] args) {
    int mat[][] = {{ 1, 2, 3, 4,5},
                    { 5, 6, 7, 8,9},
                    { 9,10,11,12,13},
                    {13,14,15,16,17},
                    {18,19,20,21,22}};

    Solution sol = new Solution();
    sol.RotMat(mat);
  }
}
