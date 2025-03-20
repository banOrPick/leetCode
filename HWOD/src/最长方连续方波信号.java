import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 最长方连续方波信号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String minStr = "01";
        StringBuffer maxResult = new StringBuffer();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < input.length(); right++) {
            int tmpright = Integer.parseInt(String.valueOf(input.charAt(right)));
            if (tmpright == 1 || right == left || right - left < 3) {
                continue;
            }
            boolean flag = true;
            String substring = input.substring(left, right + 1);
            StringBuffer tmpStr = new StringBuffer();

            for (int i = 1; i <= (right - left) / 2; i++) {
                tmpStr.append(minStr);
            }
            tmpStr.append("0");
            while (!substring.equals(tmpStr.toString()) && left < input.length() && left < right) {
                left++;
                substring = input.substring(left, right + 1);
            }
            if (maxLength < right - left && right - left >= 2) {
                if (right == input.length() - 1) {
                    maxLength = right - left;
                    maxResult = tmpStr;
                } else if (Integer.parseInt(String.valueOf(input.charAt(right + 1))) == 0) {
                    maxLength = right - left;
                    maxResult = tmpStr;
                }

            }
        }
        System.out.println(maxResult.toString());

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String signal = scanner.nextLine(); // 输入信号字符串
//
//        Pattern pattern = Pattern.compile("^(01)+0$"); // 定义正则表达式匹配完全连续交替方波信号
//
//        int maxLength = 0; // 最长完全连续交替方波信号的长度
//        String result = "-1"; // 最长完全连续交替方波信号的字符串
//
//        StringBuilder sb = new StringBuilder(); // 用于存储当前处理的信号
//        for (char c : signal.toCharArray()) {
//            if (c == '0' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') { // 当前字符是0，且前一个字符也是0，说明一个完整信号结束
//                Matcher matcher = pattern.matcher(sb.toString()); // 对当前信号进行匹配
//                if (matcher.find() && sb.length() > maxLength) { // 如果匹配到完全连续交替方波信号，并且长度大于之前的最大长度
//                    maxLength = sb.length(); // 更新最大长度
//                    result = sb.toString(); // 更新最大长度对应的字符串
//                }
//                sb.setLength(0); // 清空当前信号
//            }
//            sb.append(c); // 将当前字符加入当前信号
//        }
//
//        Matcher matcher = pattern.matcher(sb.toString()); // 对最后一个信号进行匹配
//        if (matcher.find() && sb.length() > maxLength) { // 如果匹配到完全连续交替方波信号，并且长度大于之前的最大长度
//            result = sb.toString(); // 更新最大长度对应的字符串
//        }
//
//        System.out.println(result); // 输出最长的完全连续交替方波信号串
//    }
}
