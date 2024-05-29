package Array;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int start = 0;
        for(int i = 0; i < s.length();i++){
            char sChar = s.charAt(i);
            boolean found = false;
            for(int j = start; j < t.length(); j++){
                char tChar = t.charAt(j);
                // Once we found char at subsequence == char at sequence, we check the next char at subsequence
                // but for the next iteration, we need to update j to current j + 1;
                if(sChar == tChar){
                    start = j + 1;
                    found = true;
                    break;
                }
            }
            if (found == false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";


        IsSubsequence_392 test = new IsSubsequence_392();
        System.out.println(test.isSubsequence(s,t));
    }
}
