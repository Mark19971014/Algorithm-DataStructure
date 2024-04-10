package Array;


import java.util.Arrays;
public class MicroDemo1 {
    public int solution(int[] A) {
        // First, sort the array
        Arrays.sort(A);

        // Start looking for the smallest positive integer from 1
        int smallestInt = 1;

        // Iterate through the array
        for (int i = 0; i < A.length; i++) {
            // When the current element is the same as smallestInt, increment smallestInt
            if (A[i] == smallestInt) {
                smallestInt++;
            }
        }

        // Return the smallest positive integer that was not found in the array
        return smallestInt;
    }

    public int optimal (int[] nums){
        boolean[] seen = new boolean[nums.length + 1];

        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){
                // mark this number as see
                seen[nums[i]] = true;
            }
        }

        for(int i = 1; i <  nums.length; i++){
            if(!seen[i]){
                return i;
            }
        }

        return nums.length + 1;
    }
    public static void main(String[] args) {
        MicroDemo1 solution = new MicroDemo1();


        // Test cases
        int[] nums1 = {1, 3, 6, 4, 1, 2};
        System.out.println("The smallest positive integer not in nums1: " + solution.solution(nums1));

        int[] nums2 = {1, 2, 3};
        System.out.println("The smallest positive integer not in nums2: " + solution.solution(nums2));

        int[] nums3 = {-1, -3};
        System.out.println("The smallest positive integer not in nums3: " + solution.solution(nums3));
    }
}
