package String;

public class palindrome_125 {

    public boolean isPalindrome(String s) {
        int start  = 0;
        int end  =  s.length() - 1;

        while (start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start) )){
                start += 1;
            }

            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end -=1;
            }
            if(Character.toLowerCase(s.charAt(start))!= Character.toLowerCase(s.charAt(end))){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        palindrome_125 test = new palindrome_125();
        String s = "A man, a plan, a canal: Panama";
        boolean res =  test.isPalindrome(s);

        System.out.println(res);

    }
}
