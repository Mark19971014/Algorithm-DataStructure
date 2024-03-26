package Matrix;

import java.util.HashSet;

/*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without

*/
public class ValidSudoko_036 {
    public boolean isValidSudoko(char[][] board){

        for(int i = 0; i < 9; i++){
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> CubeSet = new HashSet<>();

            //we iterate the sub martix in the outer for i loop
            // change the staring row index every 3 times of increment of i, row 0(i = 0,1,2)
            //                                                               row 1(i = 3,4,5),
            //                                                               row 2(i = 5,6,8)

            int startRowIdx = 3*(i/3);
            // change the staring column index every time of increment of i
            // column 0 (i = 0,3,6);
            // column 1 (i = 1,4,7)
            // column 2 (i = 2,5,8)
            int startColIdx = 3*(i%3);


            for (int j = 0; j < 9; j++){
                //column index++,left->right
                if(board[i][j] != '.' && rowSet.add(board[i][j]) == false){
                    return false;
                }
                // row index++, up to down
                if(board[j][i] != '.' && colSet.add(board[j][i]) == false) {
                    return false;
                }
                // iterate the entry of each submatrix in the for j loop

                int cellRowOffset = startRowIdx + j / 3;
                int cellColOffset = startColIdx + j % 3;

                if(board[cellRowOffset][cellColOffset] != '.' && CubeSet.add(board[cellRowOffset][cellColOffset])){
                    return false;
                }
            }
        }

        return  true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        ValidSudoko_036 validator = new ValidSudoko_036();
        System.out.println("Is valid: " + validator.isValidSudoko(board));
    }
}

