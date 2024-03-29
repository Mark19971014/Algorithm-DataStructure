package Graph;

public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // up and bottom row
        for (int i = 0; i < col;i++){
            // if any element on the first row is o
            if(board[0][i] == 'O'){
                //expand
                dfs(board,0,i);
            }
            // if any element on the last row is o
            if (board[row - 1][i] == 'O'){
                dfs(board,row - 1, i);
            }
        }

        for (int i = 0; i < row;i++){
            // if any element on the first col is o
            if(board[i][0] == 'O'){
                //expand
                dfs(board,i,0);
            }
            // if any element on the last col is o
            if (board[i][col - 1] == 'O'){
                dfs(board,i, col - 1);
            }
        }

        // traverse the graph, flip all the o to x
        for(int i = 0; i<board.length; i++){
            for (int j = 0; j < board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        // traverse the graph, flip back all the A to O
        for(int i = 0; i<board.length; i++){
            for (int j = 0; j < board[0].length;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board,int i ,int j){
            // if the char not on the board
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = 'T';

        dfs(board, i + 1 , j);
        dfs(board,i - 1 , j);
        dfs(board,i , j + 1);
        dfs(board, i  , j - 1);

    }

    public static void main(String[] args) {
        SurroundedRegions_130 test = new SurroundedRegions_130();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        test.solve(board);
    }
}
