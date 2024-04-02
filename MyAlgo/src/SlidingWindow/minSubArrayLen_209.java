package SlidingWindow;

public class minSubArrayLen_209 {
    public int minSubArrayLen(int target, int[]nums){
        int left= 0;
        int curSum = 0;
        int Len = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length;right++){
            curSum += nums[right];

            while(curSum >= target){
                Len = Math.min(Len,right - left + 1);
                curSum -= nums[left];
                left++;
            }
        }
        return Len == Integer.MAX_VALUE ? 0 :Len;
    }

    public static void main(String[] args) {
        minSubArrayLen_209 test = new minSubArrayLen_209();
        test.minSubArrayLen(7,new int[] {2,3,1,2,4,3});
    }
}
