package Array;
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return; // nums2 is empty, no merging needed
        }
        int k = 0;
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[k++];
            }
        }

        for(int i = m; i < m + n ; i++){
            nums1[i] = nums2[k++];
        }

        for(int i = 1; i < m + n; i++){
            // find the current element need to be sorted
            int key = nums1[i];
            // the index we start to compare the value
            int j = i - 1;
            //as long as current elements greater than the key
            while(j >= 0 && nums1[j] > key){
                // right shift the current element
                nums1[j + 1] = nums1[j];
                j--;
            }
            // find the correct position, since when we quit the while loop we find the index of the element which less than the key,
            // so the index behind this index is where we put the key
            nums1[j + 1] = key;
        }
        for(int i : nums1){
            System.out.println(i);
        }

    }
    public void merge1(int[] nums1,int m, int[] nums2, int n){
        int idx = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            nums1[idx --] = (nums1[i] > nums2[j]) ? nums1[i--]: nums2[j--];
        }
        while (j >= 0){
            nums1[idx --] = nums2[j--];
        }
    }

 // 4,8,7,2,1,3
    public static void main(String[] args) {
        MergeSortedArray_88 test = new MergeSortedArray_88();
        int[] nums1 = {4,2,0};
        int[] nums2 = {1};
        test.merge(nums1,2,nums2,1);
    }
}
