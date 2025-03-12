import java.util.HashMap;
import java.util.Scanner;

public class 九宫格按键输入 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', " ");
        map.put('1', ",.");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char currentChar;
        char lastChar = 'A';
        int mode = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                if (mode == 0) {
                    result.append(currentChar);
                } else {
                    int tmp = i;
                    String tmpStr = map.get(currentChar);
                    for (; tmp < input.length(); tmp++) {
                        if (input.charAt(tmp) != currentChar) {
                            break;
                        }
                    }

                    result.append(tmpStr.charAt((tmp - i - 1) % tmpStr.length()));
                    i = tmp - 1;
                }

            } else if (currentChar == '#') {
                mode = Math.abs(mode - 1);
                continue;
            } else if (currentChar == '/') {
                continue;
            } else {
                break;
            }

        }
        System.out.println(result.toString().trim());
    }
}
