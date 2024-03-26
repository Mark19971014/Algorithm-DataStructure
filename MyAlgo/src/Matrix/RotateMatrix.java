package Matrix;

/*3. X 3
        T
        1 2 3.       1 4 7
        4 5 6 ->.    2 5 8
        7 8 9.       3 6 9


        R
        1 2 3       7 4 1
        4 5 6  ->   8 5 2
        7 8 9	    9 6 3


        4 x 4
                             T
        1     2    3   4     	 1.     5.    9.    13
        5    6    7   8 ->       2.     6.    10.   14
        9   10  11.  12	         3.     7.    11    15
        13  14  15.  16.         4.     8.    12    16

                             R
        1    2    3    4        13.    9.     5.     1
        5    6    7    8 ->     14.    10.    6.     2
        9   10    11.  12	    15.    11.    7.     3
        13  14    15.  16.      16.    12.    8.     4
matrix.length number of rows
matrix[0].length number of columns

Important! here is a runtime error if the array is 1 x 1
 for (int row = 0; row < matrix[0].length; row++) {
                for (int col = row; col < matrix[1].length; col++)

*/
public class RotateMatrix {
    public void rotate(int[][] matrix) {

        int colSize = matrix[1].length - 1 ;
        // Transpose the matrix
            for (int row = 0; row < matrix[0].length; row++) {
                for (int col = row; col < matrix[1].length; col++) {
                        int cur = 0;
                        cur = matrix[row][col];
                        matrix[row][col] = matrix[col][row];
                        matrix[col][row] = cur;
                    }
                }
            //
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;

            while (left < right) {
                // Swap elements
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                // Move indices towards the center
                left++;
                right--;
            }
        }

    }



    public static void main(String[] args) {
        RotateMatrix test = new RotateMatrix();

        int[][] matrix = {{1}};
        System.out.println("original matrix");
        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix[1].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
        test.rotate(matrix);

        System.out.println("new matrix");
        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix[1].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
