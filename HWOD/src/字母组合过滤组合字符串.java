import java.util.*;

public class 字母组合过滤组合字符串 {
    public static HashMap<Integer, char[]> map = new HashMap<>();
    public static int[] indexList;

    public static void main(String[] args) {
        map.put(0, new char[]{'a', 'b', 'c'});
        map.put(1, new char[]{'d', 'e', 'f'});
        map.put(2, new char[]{'g', 'h', 'i'});
        map.put(3, new char[]{'j', 'k', 'l'});
        map.put(4, new char[]{'m', 'n', 'o'});
        map.put(5, new char[]{'p', 'q', 'r'});
        map.put(6, new char[]{'s', 't'});
        map.put(7, new char[]{'u', 'v'});
        map.put(8, new char[]{'w', 'x'});
        map.put(9, new char[]{'y', 'z'});
        Scanner scanner = new Scanner(System.in);
        indexList = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        StringBuilder result = new StringBuilder();
        String filter = scanner.nextLine();
        dfs(0, new StringBuilder(), result, filter, new HashSet<>());
        System.out.println(result.toString().trim());
    }

    private static void dfs(int index, StringBuilder tmp, StringBuilder result, String filter, HashSet<Character> used) {
        if (index == indexList.length) {
            if (!tmp.toString().contains(filter)) {
                result.append(tmp).append(",");
            }
            return;
        }
        Integer poll = indexList[index];
        char[] chars = map.get(poll);
        for (int i = 0; i < chars.length; i++) {
            if (!used.contains(chars[i])) {
                used.add(chars[i]);
                tmp.append(chars[i]);
                dfs(index + 1, tmp, result, filter, used);
                tmp.deleteCharAt(tmp.length() - 1);
                used.remove(chars[i]);
            }

        }
    }
}
