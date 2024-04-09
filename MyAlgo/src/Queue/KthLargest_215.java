package Queue;

import java.util.PriorityQueue;

public class KthLargest_215 {

    public int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add first k element to the pq

        for(int i = 0; i< k; i++){
            pq.add(nums[i]);
        }
    // iterate over the remaining elements
        for (int i = k; i < nums.length;i++){
            // if current element larger than the smallest in the heap

            if(nums[i] > pq.peek()){
                // remove the smallest
                pq.poll();
                //add the current element
                pq.add(nums[i]);
            }
        }

        return  pq.peek();
    }
    public static void main(String[] args) {
        KthLargest_215 solution = new KthLargest_215();

        int[] nums1 = {3, 2, 1, 5, 6,6, 4};
        int k1 = 4;
        System.out.println("The " + k1 + "th largest element is " + solution.findKthLargest(nums1, k1));
        //{1,2,2,3,3,4,5,5,6}
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 3;
        System.out.println("The " + k2 + "th largest element is " + solution.findKthLargest(nums2, k2));
    }
}
