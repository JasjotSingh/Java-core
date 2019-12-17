import java.util.*;

class MatrixRot{
  private void rotate(int[][] mat){


      for(int k = 0; k < mat.length/2; k++){
        for(int j = k; j < mat.length-1-k; j++){
      int temp = mat[k][j];
      mat[k][j] = mat[mat.length -1 -j][k];
      mat[mat.length -1 -j][k] = mat[mat.length -1 -k][mat.length -1 -j];
      mat[mat.length -1 -k][mat.length -1 -j] = mat[j][mat.length -1-k];
      mat[j][mat.length -1 -k] = temp;
    }
    }

  }
  public static void main(String args[]){
    MatrixRot mr = new MatrixRot();
    int mat[][]= {{3,4,2,1,7},
                  {7,6,4,2,8},
                  {0,6,2,4,0},
                  {7,5,4,2,2},
                  {6,4,2,1,5}};

    System.out.println("Matrix before rotation: ");
    for(int i = 0 ; i < mat.length; i++){
      for(int j = 0; j < mat[i].length; j++){
        System.out.print(mat[i][j]+" ");
      }
      System.out.println("");
    }
    mr.rotate(mat);

    System.out.println("Matrix after rotation: ");
    for(int i = 0 ; i < mat.length; i++){
      for(int j = 0; j < mat[i].length; j++){
        System.out.print(mat[i][j]+" ");
      }
      System.out.println("");
    }
  }
}
