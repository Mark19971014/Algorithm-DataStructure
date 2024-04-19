package Array;

import java.util.Arrays;
/*Use three pointers initially at the end of nums1, the end of the non-zero part of nums1, and the end of nums2.
Compare the elements at the two pointers not at the end of nums1.
Place the larger element at the pointer at the end of nums1 and move the pointer backwards.
Repeat this process until all elements in nums2 have been placed into nums1.*/
public class MergeSortedArray_088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = 0;
        for( i = m; i < nums1.length;i++){
            nums1[i] = nums2[j++];
        }

        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }

            p--;
        }
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
    public static void main(String[] args) {
        MergeSortedArray_088 test = new MergeSortedArray_088();
        int[] nums1 = {};
        int[] nums2 = {1};
        test.merge1(nums1,0,nums2,1);
    }
}
