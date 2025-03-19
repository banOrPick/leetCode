import java.util.Scanner;

public class 文本统计分析 {
    public static void main(String[] args) {
        // 创建Scanner对象用于获取用户输入
        Scanner scanner = new Scanner(System.in);
        // 使用StringBuilder来构建整个输入文本
        StringBuilder input = new StringBuilder();
        // 循环读取每一行输入直到没有新的输入
        while (scanner.hasNextLine()) {
            // 将读取的每一行追加到StringBuilder对象，并添加换行符
            String s = scanner.nextLine();
            input.append(s).append("\n");
            if (s.equals("")) {
                break;
            }
        }
        // 关闭Scanner对象
        scanner.close();
        // 输出文本统计结果
        System.out.println(countTexts(input.toString()));
    }

    // 统计文本中的文本数量
    private static int countTexts(String input) {
        // 初始化计数器
        int count = 0;
        // 标记是否在字符串内部
        boolean inString = false;
        // 标记是否在注释内部
        boolean inComment = false;
        // 记录字符串分隔符
        char stringDelimiter = 0;
        // 标记当前是否为空文本（即没有遇到非空白字符）
        boolean isEmpty = true;

        // 遍历输入文本的每个字符
        for (int i = 0; i < input.length(); i++) {
            // 当前字符
            char c = input.charAt(i);
            // 下一个字符（如果存在）
            char nextChar = (i + 1 < input.length()) ? input.charAt(i + 1) : '\0';

            // 如果在注释中
            if (inComment) {
                // 如果遇到换行符，则注释结束
                if (c == '\n') {
                    inComment = false;
                }
                continue;
            }

            // 如果遇到连续的两个减号，并且不在字符串内，则进入注释状态
            if (c == '-' && nextChar == '-' && !inString) {
                inComment = true;
                continue;
            }

            // 如果遇到单引号或双引号，并且不在字符串内，则进入字符串状态
            if ((c == '\'' || c == '\"') && !inString) {
                inString = true;
                stringDelimiter = c;
                isEmpty = false;
                continue;
            }

            // 如果在字符串内，并且遇到了相同的分隔符，则检查是否为转义
            if (c == stringDelimiter && inString) {
                if (nextChar == stringDelimiter) {
                    i++; // 跳过转义的引号
                } else {
                    inString = false; // 字符串结束
                }
                continue;
            }

            // 如果遇到分号，并且不在字符串内，则增加计数器
            if (c == ';' && !inString) {
                if (!isEmpty) {
                    count++;
                    isEmpty = true;
                }
                continue;
            }

            // 如果遇到非空白字符，并且不在字符串内，则标记为非空文本
            if (!Character.isWhitespace(c) && !inString) {
                isEmpty = false;
            }
        }

        // 如果最后一个文本没有闭合的分号，则增加计数器
        if (!isEmpty) {
            count++; // 最后一个文本没有闭合分号
        }

        return count;
    }
}
