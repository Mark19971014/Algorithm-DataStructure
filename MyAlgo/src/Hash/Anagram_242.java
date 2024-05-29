package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Anagram_242 {
    public boolean isAnagram(String s, String t) {
        // check length
        if (s.length() != t.length()) return false;

        HashMap<Character,Integer> stMap = new HashMap<>();
        HashMap<Character,Integer> tsMap = new HashMap<>();
        // initialize stMap: char -> number of occurence
        for(char c : s.toCharArray()){
            stMap.put(c,stMap.getOrDefault(c,0) + 1);
        }
        // initialize tsMap
        for(char c : t.toCharArray()){
            tsMap.put(c,tsMap.getOrDefault(c,0) + 1);
        }
        // example 2: check keySet
        Set<Character> letterS = stMap.keySet();
        Set<Character> letterT = tsMap.keySet();
        if (!letterS.containsAll(letterT)){
            return false;
        }
        // exmaple 1: check number of occurrence:

        // key set must equal

        for(char c : letterS){
            // unmatched occurrence
            if(!Objects.equals(stMap.get(c), tsMap.get(c))){
                return false;
            }
        }
        return true;
    }
    //  s = "aaba" .keyset{ab}
    // t = "baba"  keyset{ab}
    public static void main(String[] args) {
       String s = "anagram";
       String t = "nagaram";

       Anagram_242 test = new Anagram_242();
        System.out.println(test.isAnagram(s,t));

    }
}
