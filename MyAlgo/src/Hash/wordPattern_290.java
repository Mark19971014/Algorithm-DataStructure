package Hash;

import java.util.HashMap;

public class wordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;
        HashMap<Character, String> charToString = new HashMap<>();
        HashMap<String,Character> stringToChar = new HashMap<>();
        for (int i = 0; i < words.length;i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToString.containsKey(c)){
                if(!charToString.get(c).equals(word)){
                    return false;
                }
            }else{
                charToString.put(c, word);
            }

            if (stringToChar.containsKey(word)){
                if(stringToChar.get(word) != c){
                    return false;
                }
            }else{
                stringToChar.put(word,c);
            }
        }

        return true;
    }
}
