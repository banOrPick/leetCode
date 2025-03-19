import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class 字符串化繁为简 {


    public static void main(String[] args) {
        // 创建一个Scanner对象，用于读取用户输入
        Scanner scanner = new Scanner(System.in);
        // 读取用户输入的字符串
        String inputString = scanner.nextLine();
        // 创建一个StringBuilder对象，用于存储最终的输出结果
        StringBuilder outputStringBuilder = new StringBuilder();
        // 创建一个LinkedList对象，用于存储等价集合
        LinkedList<TreeSet<Character>> equivalentSets = new LinkedList<>();

        // 用于判断当前是否在括号内部的标志变量
        boolean isInsideParentheses = false;

        // 遍历输入字符串的每个字符
        for (int i = 0; i < inputString.length(); i++) {
            // 获取当前字符
            char currentChar = inputString.charAt(i);

            // 如果当前字符是左括号'('，则表示进入了括号内部
            if (currentChar == '(') {
                isInsideParentheses = true;
                // 创建一个新的等价集合，并将其添加到LinkedList中
                equivalentSets.add(new TreeSet<>());
            }
            // 如果当前字符是右括号')'，则表示离开了括号内部
            else if (currentChar == ')') {
                isInsideParentheses = false;
                // 如果最后一个等价集合为空集合，则将其从LinkedList中移除
                if (equivalentSets.getLast().size() == 0) equivalentSets.removeLast();
            }
            // 如果当前字符既不是左括号也不是右括号
            else {
                // 如果当前不在括号内部，则直接将字符添加到输出结果中
                if (!isInsideParentheses) {
                    outputStringBuilder.append(currentChar);
                }
                // 如果当前在括号内部，则将字符添加到最后一个等价集合中
                else {
                    equivalentSets.getLast().add(currentChar);
                }
            }
        }

        // 用于判断是否进行了合并操作的标志变量
        boolean merged = true;
        // 循环执行合并操作，直到没有可以合并的等价集合为止
        while (merged) {
            merged = false;
            // 遍历等价集合LinkedList中的每个等价集合
            for (int i = 0; i < equivalentSets.size(); i++) {
                for (int j = i + 1; j < equivalentSets.size(); j++) {
                    boolean canCombine = false;
                    // 遍历字母'a'到'z'，判断两个等价集合是否可以合并
                    for (char c = 'a'; c <= 'z'; c++) {
                        char uppercaseC = (char) (c - 32);
                        if ((equivalentSets.get(i).contains(c) || equivalentSets.get(i).contains(uppercaseC)) && (equivalentSets.get(j).contains(c) || equivalentSets.get(j).contains(uppercaseC))) {
                            canCombine = true;
                            break;
                        }
                    }
                    // 如果可以合并，则将第二个等价集合中的元素合并到第一个等价集合中，并从LinkedList中移除第二个等价集合
                    if (canCombine) {
                        equivalentSets.get(i).addAll(equivalentSets.get(j));
                        equivalentSets.remove(j);
                        merged = true;
                        break;
                    }
                }
                if (merged) break;
            }
        }

        // 将输出结果转换为字符数组
        char[] outputCharArray = outputStringBuilder.toString().toCharArray();

        // 对每个等价集合进行处理，将等价集合中的字符替换为集合中的第一个字符
        for (TreeSet<Character> eq : equivalentSets) {
            Character firstChar = eq.first();
            for (int i = 0; i < outputCharArray.length; i++) {
                if (eq.contains(outputCharArray[i])) outputCharArray[i] = firstChar;
            }
        }

        // 将字符数组转换为字符串
        String resultString = new String(outputCharArray);

        // 如果结果字符串为空，则返回"0"，否则返回结果字符串
        String finalResult = resultString.length() == 0 ? "0" : resultString;
        System.out.println(finalResult);
    }
}
