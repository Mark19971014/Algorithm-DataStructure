package Array;

public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length){
            k %= length;
        }
        int[] temp = new int[k];
        int idx = 0;
        // copy the last k from the original array to temp array
        for(int i = length - k; i < length; i++){
            temp[idx] = nums[i];
            idx++;
        }
        for(int i = length - k - 1; i >= 0;i--){
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k;i++){
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        RotateArray_189 test = new RotateArray_189();
        int[] arr = {1,2,3,4,5,6,7};
        test.rotate(arr,10);
    }
}
