import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 寻找符合要求的最长子串 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char nextInt = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();
        int left = 0, right = 0;
        Integer max = Integer.MIN_VALUE;
        for (; left < input.length()-1; right++) {
            max = Math.max(getMax(input.substring(left, right + 1), nextInt), max);
            if (right == input.length() - 1) {
                left++;
                right = left;
            }
        }
        System.out.println(max);
    }

    private static int getMax(String substring, char nextInt) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < substring.length(); i++) {
            char currentChar = substring.charAt(i);
            map.compute(currentChar, (key,value) -> value == null ? 1 : value + 1);
            if (currentChar == nextInt || map.get(currentChar) == 3) {
                return -1;
            }
        }
        return substring.length();
    }

}
