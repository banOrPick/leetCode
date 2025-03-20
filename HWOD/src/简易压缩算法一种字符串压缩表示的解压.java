import java.util.Scanner;

public class 简易压缩算法一种字符串压缩表示的解压 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar <= '9' && currentChar > '2') {
                int n = Integer.parseInt(String.valueOf(currentChar));
                for (int j = 1; j < n; j++) {
                    result.append(line.charAt(i+1));
                }
            } else if (currentChar >= '0' && currentChar <= '2') {
                System.out.println("!error");
                return;
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                if (i + 2 < line.length()) {
                    char first = line.charAt(i + 1);
                    char second = line.charAt(i + 2);
                    if (first == currentChar && second == currentChar) {
                        System.out.println("!error");
                        return;
                    }
                }
                result.append(currentChar);
            }else{
                System.out.println("!error");
                return;
            }
        }
        System.out.println(result);
    }
}
