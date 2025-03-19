import java.util.HashSet;
import java.util.Scanner;

public class 字符串拼接 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        String[] str = split[0].split("");
        int n = Integer.parseInt(split[1]);
        HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[str.length];
        getString(str, n, set, "", visited);
        System.out.println(set.size());
    }

    private static void getString(String[] str, int n, HashSet<String> set, String lastString, boolean[] visited) {
        if (n == 0) {
            set.add(lastString);
            return;
        }
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (visited[i] || (!lastString.isEmpty() && lastString.charAt(lastString.length() - 1) == s.charAt(0))) {
                continue;
            }
            visited[i] = true;
            getString(str, n - 1, set, lastString + s, visited);
            visited[i] = false;

        }

    }

//    public static void main(String[] args) {
//        // 创建一个Scanner对象来读取用户的输入
//        Scanner sc = new Scanner(System.in);
//        // 读取用户输入的字符串
//        String input = sc.nextLine();
//        // 将输入的字符串按空格分割为两部分，分别为字符串和长度
//        String[] parts = input.split(" ");
//        String str = parts[0]; // 获取输入的字符串
//        int length = Integer.parseInt(parts[1]); // 将输入的长度部分转换为整数
//
//        // 调用countDistinctStrings方法计算满足条件的不同字符串的数量
//        int count = countDistinctStrings(str, length);
//        // 输出计算结果
//        System.out.println(count);
//    }
//
//    // 计算满足条件的不同字符串的数量
//    public static int countDistinctStrings(String str, int length) {
//        // 创建一个HashSet来存储不同的字符串
//        HashSet<String> set = new HashSet<>();
//        // 创建一个boolean数组来标记字符串中的字符是否已经被使用
//        boolean[] used = new boolean[str.length()];
//        // 调用generateDistinctStrings方法生成满足条件的不同字符串
//        generateDistinctStrings(str, length, "", set, used);
//        // 打印生成的所有不同的字符串
//        // for(String str1 : set){
//        // System.out.println(str1);
//        // }
//        // 返回不同字符串的数量
//        return set.size();
//    }
//
//    // 递归生成满足条件的不同字符串
//    public static void generateDistinctStrings(String str, int length, String current, HashSet<String> set, boolean[] used) {
//        // 当生成的字符串长度等于指定长度时，将其加入到HashSet中
//        if (current.length() == length) {
//            set.add(current);
//            return;
//        }
//
//        // 遍历字符串中的字符
//        for (int i = 0; i < str.length(); i++) {
//            // 判断字符是否已经被使用，或者当前字符与前一个字符相同
//            if (used[i] || (current.length() > 0 && current.charAt(current.length() - 1) == str.charAt(i))) {
//                continue; // 如果字符已被使用或与前一个字符相同，则跳过当前字符
//            }
//            used[i] = true; // 标记当前字符为已使用
//            // 递归调用生成下一个字符
//            generateDistinctStrings(str, length, current + str.charAt(i), set, used);
//            used[i] = false; // 取消标记当前字符的使用状态，以便下一次遍历
//        }
//    }
}
