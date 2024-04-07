package Graph;

import java.util.*;

public class Snake_ladder_909 {

    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0) return 0;

        int length = board.length;
        // create a queue of {current square; move}
        Deque<int[]> queue = new ArrayDeque<>();
        // add the initial pos and number of move
        queue.offer(new int[] {1,0});
        //Set to track is the square already visited
        Set<Integer> visit = new HashSet<>();
        visit.add(1);
        //BFS
        while(!queue.isEmpty()){
            // poll the element from the queue
            int[] entry = queue.poll();
            int square = entry[0];
            int moves = entry[1];

            // each square have 6 possible steps of movement
            for (int i = 1; i <= 6; i++){
                int nextSquare = square + i;
                int[] rowcol = intToPos(nextSquare,length);
                int rowidx = rowcol[0], colidx = rowcol[1];
                // if it's not a ladder or snake only update square when square is not equal -1
                if(board[rowidx][colidx] != -1){
                    nextSquare = board[rowidx][colidx];
                }
                if (nextSquare == length * length) return moves + 1;
                // if not visited, update the set and queue
                if (!visit.contains(nextSquare)){
                    visit.add(nextSquare);
                    queue.add(new int[] {nextSquare,moves + 1});
                }
                // if this square has a ladder or snake
            }
        }

        return -1;
    }
    private int[] intToPos(int square, int length) {
        int adjustedSquare = square - 1;
        // Calculate the row from the top to the bottom (0-indexed).
        int r = length - adjustedSquare / length - 1;
       //int c =  r % 2 != 0 ? adjustedSquare % length : length - adjustedSquare % length - 1;
        int c = (length - r) % 2 != 0 ? adjustedSquare % length : length - adjustedSquare % length - 1;
        return new int[]{r, c};
    }
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};

        Snake_ladder_909 test = new Snake_ladder_909();
                test.snakesAndLadders(board);
    }
}
