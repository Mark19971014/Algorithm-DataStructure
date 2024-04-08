package Array;

import java.util.HashMap;

public class MajorityElements_169 {
    public int majorityElement(int[] nums) {
        int maxCount = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int majority = nums[0];

        for(int n : nums){
            int count = map.getOrDefault(n,0) + 1;

            map.put(n,count);
            if(count > maxCount){
                maxCount = count;
                majority = n;
            }
        }

        return  majority ;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        MajorityElements_169 solution = new MajorityElements_169();
        System.out.println(solution.majorityElement(nums));
    }
}
