package Matrix;

public class RotateMatrix_048 {

    public static void rotate(int[][] matrix){
        //1. transpose the matrix : swap the elements that are symmetrical to the diagonal line
        //2. filp the new matrix, swap the half the elements on each row
        int n = matrix.length;
        for(int i = 0; i <  n;i++){
            // diagonal line, j = i
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n- j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("Rotated matrix:");
        printMatrix(matrix);
    }

}
