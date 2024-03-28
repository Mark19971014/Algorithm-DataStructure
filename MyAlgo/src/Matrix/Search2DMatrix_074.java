package Matrix;

// the time complexity must be log(n*m)

/*
*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
* */
public class Search2DMatrix_074 {
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        // we flatten the 2D matrix to a 1D array, since we have n*m element thus the last index is n*m -1
        int right = n * m - 1;
        // binary search
        while(left <= right){
            int mid = left + (right - left)/2;
            // each row have n element, division find which row , modular find the offset on that row;
            int midVal = matrix[mid/n][mid%n];
            if (midVal == target){
                return true;
            } else if ( midVal < target) {
                // search the right sub part , update the left pointer
                left = mid + 1;

            }else {
                right = mid - 1;
            }

        }
        return  false;
    }

}
