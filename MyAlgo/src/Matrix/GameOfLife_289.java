package Matrix;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife_289 {
    public void gameOfLife(int[][] board) {
        List<Integer> Neighbour = new ArrayList<>(8);
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,-1},{1,1}};
        int m = board.length, n = board[0].length;
        int[][] temp = new int[m][n];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                int liveCount = 0;
                // check all the neighbour cell of current cell
                for(int[] neighbour : direction){
                    int newRow = row + neighbour[0];
                    int newCol = col + neighbour[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 1 ){
                        liveCount += 1;
                    }
                }
                // Live cell;
                if(board[row][col] == 1){
                    if(liveCount < 2 || liveCount > 3) {
                        temp[row][col] = 0;
                    }
                    else {
                        temp[row][col] = 1;
                    }
                    // dead cell;
                }else{
                    if (liveCount == 3){
                        temp[row][col] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            System.arraycopy(temp[i], 0, board[i], 0, n);
        }
    }
}
