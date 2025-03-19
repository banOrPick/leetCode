import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 模拟目录管理 {
    // 定义一个内部类Node，用于表示文件系统中的每个目录
    static class Node {
        String path; // 目录的路径
        Map<String, Node> next = new HashMap<>(); // 存储当前目录下的子目录，键为目录名，值为对应的Node对象

        // Node类的构造方法ac
        Node(String path, Node parent) {
            this.path = path; // 设置当前节点的路径
            // 如果存在父目录，则在子目录映射中添加一个指向父目录的条目
            if (parent != null) {
                this.next.put("..", parent);
            }
        }
    }

    // 程序的主入口点
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象来读取用户的输入
        Node root = new Node("/", null); // 创建根目录节点，根目录没有父目录，所以第二个参数为null
        Node currentNode = root; // 初始化当前目录为根目录
        String lastOutput = ""; // 用于存储最后输出的路径

        // 循环读取用户输入的命令
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim(); // 读取一行输入并去除前后空格
            if (input.isEmpty()) break; // 如果输入为空，则退出循环

            String[] parts = input.split(" "); // 将输入的命令按空格分割为命令和参数
            String command = parts[0]; // 获取命令部分

            // 处理mkdir命令，用于创建新的子目录
            if ("mkdir".equals(command) && parts.length == 2 && isValidDirectoryName(parts[1])) {
                // 如果目录名有效并且不存在，则创建一个新的目录节点，并将其添加到当前目录的子目录映射中
                currentNode.next.putIfAbsent(parts[1], new Node(currentNode.path + parts[1] + "/", currentNode));
            } else if ("cd".equals(command) && parts.length == 2 && isValidChangeDirectory(parts[1])) {
                // 处理cd命令，用于改变当前目录
                Node nextNode = currentNode.next.get(parts[1]); // 从子目录映射中获取要切换的目录节点
                if (nextNode != null) {
                    currentNode = nextNode; // 如果目录存在，则将当前目录切换为该目录
                }
            } else if ("pwd".equals(command) && parts.length == 1) {
                // 处理pwd命令，用于打印当前目录的路径
                lastOutput = currentNode.path; // 将当前目录的路径保存到lastOutput变量中
            }
        }

        System.out.println(lastOutput); // 循环结束后，打印最后保存的路径
    }

    // 检查目录名是否有效的方法，目录名只能包含小写字母
    private static boolean isValidDirectoryName(String name) {
        for (char c : name.toCharArray()) {
            if (c < 'a' || c > 'z') {
                return false; // 如果目录名中包含非小写字母的字符，则返回false
            }
        }
        return true; // 如果目录名全部由小写字母组成，则返回true
    }

    // 检查是否可以切换到指定的目录的方法，目录名要么是有效的，要么是".."表示上级目录
    private static boolean isValidChangeDirectory(String name) {
        return "..".equals(name) || isValidDirectoryName(name); // 如果是".."或者是有效的目录名，则返回true
    }
}
