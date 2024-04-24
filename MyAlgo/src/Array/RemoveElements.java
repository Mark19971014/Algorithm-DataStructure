package Array;
/*Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

        Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

        Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
        Return k.*/
public class RemoveElements {
    public int removeElement(int[] nums, int val){
        int k = 0; // number of elements not equal to val and also keep track the index to remove the elements which match val
        for(int i = 0; i < nums.length; i++){
            if( nums[i] != val){
                // put the not equal elements into the head part
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        RemoveElements test = new RemoveElements();
        int[] nums = {1,2,2,3,4};
        test.removeElement(nums,3);
    }
}
