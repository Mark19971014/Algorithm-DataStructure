package Array;

public class RemoveDuplicateII_080 {
    // since we can have duplicated element at most twice
    public int removeDuplicatesII(int[] nums) {
        // since we can have duplicated element at most twice
        if(nums.length <= 2) return nums.length;
        // start updating from index 2
        int insertPos = 2;
        // since we can have at most two duplicated element, and the array is sorted,
        // thus there are two cases: 1 1 1, or 1,2,2
        // if the value is same , which mean the num[i] is the third duplicate element, otherwise we can add it in the insert Position
        for(int i = 2; i < nums.length;i++){

            // Check if the current element is different from the element two positions before it.
            if(nums[i] != nums[insertPos - 2]){
                // If it's different, it's not a duplicate that violates our condition, so we can safely add it.
                nums[insertPos] = nums[i];
                // we increment here indicate that the non twice duplicate element added
                insertPos++;
            }
        }
        return  insertPos;
    }

    public static void main(String[] args) {
        RemoveDuplicateII_080 solution = new RemoveDuplicateII_080();
        int[] test = {0,0,1,1,1,2,2,3,3,3};
        System.out.println(solution.removeDuplicatesII(test));
        /*int[][] testArrays = {
                {},
                {1},
                {1, 1, 1, 2, 2, 3},
                {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} // No duplicates
        };

        for (int[] testArray : testArrays) {
            int newLength = solution.removeDuplicates(testArray);
            System.out.print("Resulting array length: " + newLength + " | Elements: ");
            for (int i = 0; i < newLength; i++) {
                System.out.print(testArray[i] + " ");
            }
            System.out.println();
        }*/
    }
}
