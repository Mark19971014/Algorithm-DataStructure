package Array;

public class RemoveDuplicate_026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int j = 0;
        int res = 1;
        for (int i = 0; i < nums.length;i++){
            if (nums[j] == nums[i]){
                nums[j] = nums[i];
            }else{
                nums[j + 1] = nums[i];
                j++;
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicate_026 test = new RemoveDuplicate_026();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(test.removeDuplicates(nums));
    }
}
