package Hash;

import java.util.HashMap;

public class RansomNote_036 {
    public boolean canConstruct(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str2.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        for (char c : str1.toCharArray()) {
            // check if str1 has the char or we have enough char in str2, important! the checking order is matter
            if (!map.containsKey(c) || map.get(c) <= 0) {
              return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote_036 solution = new RansomNote_036();

        String ransomNote = "aabddb";
        String magazine = "aabbc";
        System.out.println(solution.canConstruct(ransomNote, magazine));

        ransomNote = "aad";
        magazine = "aabbc";
        System.out.println(solution.canConstruct(ransomNote, magazine));
    }
    }

