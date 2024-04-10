package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_03 {
    public int lengthOfLongestSubstring(String s){
        if (s == "") return 0;
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < s.length()){
            char cur = s.charAt(right);
            while(set.contains(cur)){
                // we remove the duplicated element until remove the cur element which right pointer points
                // for example abc b , left point to a in abc right point to b, we need remove a then remove b
                set.remove(s.charAt(left));
                left++;
            }
            set.add(cur);
            right++;
            res = Math.max(res,right - left);
           /*right is incremented after the character at the current right index is added to the set,
             meaning that right points to the index after the current window. This is a common pattern in sliding window problems,
            and the length of the window is right - left because right is already one past the end of the current window.*/
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_03 test = new LongestSubstringWithoutRepeatingCharacters_03();
        String s = "";
        String s1 = "abcabcbb";
        System.out.println(test.lengthOfLongestSubstring(s));
        System.out.println(test.lengthOfLongestSubstring(s1));

    }
}
