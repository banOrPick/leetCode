import java.util.*;

public class 连续字母长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> resultMap = new HashMap<>();
        for (; right < string.length(); right++) {
            Character leftChar = string.charAt(left);
            Character rightChar = string.charAt(right);
            if (leftChar != rightChar) {
                Character key = leftChar;
                int max = right - left;
                if (resultMap.containsKey(key)) {
                    max = Math.max(max, resultMap.get(leftChar));
                }
                resultMap.put(leftChar, max);
                left = right;
            }
        }
        Character lastChar = string.charAt(left);
        int max = right - left;
        if (resultMap.containsKey(lastChar)) {
            max = Math.max(max, resultMap.get(lastChar));
        }
        resultMap.put(lastChar, max);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(resultMap.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        if (k > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1).getValue());
        }
    }
}
