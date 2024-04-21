package Array;

public class JumpGame_055 {
    public boolean canJump(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length - 1;i++){
            if(i > max){
                return false;
            }

            max=Math.max(max, nums[i] + i);
        }

        return  max >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame_055 test = new JumpGame_055();
         int[] nums = {3,2,1,0,4};
        System.out.println(test.canJump(nums));
    }
}
