import java.util.Scanner;

public class 文本统计分析 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            input.append(s).append("\n");
            if (s.equals("")) {
                break;
            }
        }
        scanner.close();
        System.out.println(countTexts(input.toString()));
    }

    // 统计文本中的文本数量
    private static int countTexts(String input) {
        int count = 0;
        boolean inString = false;
        boolean inComment = false;
        char stringDelimiter = 0;
        boolean isEmpty = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char nextChar = (i + 1 < input.length()) ? input.charAt(i + 1) : '\0';

            if (inComment) {
                inComment = handleComment(c);
                continue;
            }

            if (isStartOfComment(c, nextChar, inString)) {
                inComment = true;
                i++;
                continue;
            }

            if (isStartOfString(c, inString)) {
                inString = true;
                stringDelimiter = c;
                isEmpty = false;
                continue;
            }

            if (inString) {
                inString = handleString(c, input, i, stringDelimiter);
                continue;
            }

            if (isEndOfText(c, inString, isEmpty)) {
                count++;
                isEmpty = true;
                continue;
            }

            if (isNonEmptyText(c, inString)) {
                isEmpty = false;
            }
        }

        if (!isEmpty) {
            count++;
        }

        return count;
    }

    // 处理注释状态
    private static boolean handleComment(char c) {
        return c != '\n';
    }

    // 判断是否为注释开始
    private static boolean isStartOfComment(char c, char nextChar, boolean inString) {
        return c == '-' && nextChar == '-' && !inString;
    }

    // 判断是否为字符串开始
    private static boolean isStartOfString(char c, boolean inString) {
        return (c == '\'' || c == '\"') && !inString;
    }

    // 处理字符串状态
    private static boolean handleString(char c, String input, int index, char delimiter) {
        if (c == delimiter) {
            if (index > 0 && input.charAt(index - 1) == '\\') {
                return true;
            }
            return false;
        }
        return true;
    }

    // 判断是否为文本结束
    private static boolean isEndOfText(char c, boolean inString, boolean isEmpty) {
        return c == ';' && !inString && !isEmpty;
    }

    // 判断是否为非空文本
    private static boolean isNonEmptyText(char c, boolean inString) {
        return !Character.isWhitespace(c) && !inString;
    }
}
