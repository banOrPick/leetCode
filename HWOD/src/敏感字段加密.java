import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 敏感字段加密 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取命令字索引 K
        int K = scanner.nextInt();
        scanner.nextLine();
        // 读取命令字符串 S
        String S = scanner.nextLine();

        // 解析命令字符串为命令字列表
        List<String> commandList = parseCommandString(S);

        // 检查索引是否超出范围
        if (K < 0 || K >= commandList.size()) {
            System.out.println("ERROR");
        } else {
            // 加密指定索引的命令字
            commandList.set(K, "******");
            // 构建结果字符串
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < commandList.size(); i++) {
                if (i > 0) {
                    result.append("_");
                }
                result.append(commandList.get(i));
            }
            // 输出结果
            System.out.println(result.toString());
        }
        scanner.close();
    }

    // 解析命令字符串为命令字列表
    private static List<String> parseCommandString(String S) {
        List<String> commandList = new ArrayList<>();
        StringBuilder command = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '"') {
                if (inQuotes) {
                    command.append(ch);
                    commandList.add(command.toString());
                    command.setLength(0);
                    inQuotes = false;
                } else {
                    inQuotes = true;
                    command.append(ch);
                }
            } else if (!inQuotes && ch == '_') {
                if (command.length() > 0) {
                    commandList.add(command.toString());
                    command.setLength(0);
                }
            } else {
                command.append(ch);
            }
        }

        // 处理最后一个命令字
        if (command.length() > 0) {
            commandList.add(command.toString());
        }

        return commandList;
    }
}
