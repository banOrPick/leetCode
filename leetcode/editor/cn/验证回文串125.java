import org.junit.Test;

public class 验证回文串125 {
    @Test
    public void test(){
        System.out.println(isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        boolean result = true;
        StringBuilder builder = new StringBuilder();
        String lowerCase = s.trim().toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) >= 'a' && lowerCase.charAt(i) <= 'z') {
                builder.append(lowerCase.charAt(i));
            }
        }
        String string = builder.toString();
        int left = 0;
        int right = string.length()-1;
        while (left<right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return result;

    }
}
