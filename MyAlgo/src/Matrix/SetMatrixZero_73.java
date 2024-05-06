package Matrix;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZero_73 {

    public int[][] setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> rowZero = new HashSet<>();
        HashSet<Integer> colZero = new HashSet<>();
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                // if element is 0
                if (matrix[i][j] == 0){
                  rowZero.add(i);
                  colZero.add(j);
                }
            }
        }

        for(int row : rowZero){
            for(int col = 0; col <  n; col++){
                matrix[row][col] = 0;
            }
        }

        for(int col: colZero){
             for(int row = 0; row < m; row++){
                matrix[row][col] = 0;
            }
        }
        return  matrix;
    }
    public static void main(String[] args) {
        SetMatrixZero_73 test = new SetMatrixZero_73();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        int[][] res = test.setZeroes(matrix);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
