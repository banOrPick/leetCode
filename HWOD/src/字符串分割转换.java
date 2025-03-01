import java.util.Scanner;

public class 字符串分割转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        String[] split = string.split("-");
        String prefix = split[0];

        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer result = new StringBuffer();
        result.append(prefix);
        for (int i = 1; i < split.length; i++) {
            stringBuffer.append(split[i]);
        }
        result = getString(result, stringBuffer, 0, k);
        System.out.println(result.toString().trim());
    }

    private static StringBuffer getString(StringBuffer result, StringBuffer stringBuffer, int start, int k) {
        int end = start + k;
        if (end > stringBuffer.length()) {
            end = stringBuffer.length();
        }
        String string = stringBuffer.substring(start, end);
        int lowNum = getLowNum(string);
        int upNum = getUpNum(string);
        if (lowNum < upNum) {
            string = string.toUpperCase();
        } else if (lowNum > upNum) {
            string = string.toLowerCase();
        }
        result.append("-").append(string);
        if (end != stringBuffer.length()) {
            getString(result, stringBuffer, end, k);
        }
        return result;
    }

    private static int getUpNum(String string) {
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                num++;
            }
        }
        return num;
    }

    private static int getLowNum(String string) {
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
                num++;
            }
        }
        return num;
    }
}

