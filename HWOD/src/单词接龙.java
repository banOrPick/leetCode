import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class 单词接龙 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordIndex = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            list.add(word);
        }
        boolean flag = true;
        StringBuffer result = new StringBuffer();
        while (flag) {
            String s = list.get(wordIndex);
            result.append(s);
            list.remove(wordIndex);
            char lastChar = s.charAt(s.length() - 1);
            AtomicInteger index = new AtomicInteger(0);
            TreeMap<Integer, String> resultMap = new TreeMap<>();
            list.stream().forEach(str -> {
//                HashMap<Integer, Integer> resultMap = new HashMap<>();
                int tmpIndex = index.getAndIncrement();
                if (lastChar == str.charAt(0)) {
                    resultMap.put(tmpIndex, str);
                }
            });
            if (resultMap.isEmpty() || resultMap.size() == 0) {
                flag = false;
                break;
            }
            Map.Entry<Integer, String> maxEntry = resultMap.entrySet().stream().sorted((a, b) -> {
                return b.getValue().length() == a.getValue().length() ? a.getValue().compareTo(b.getValue()) : (b.getValue().length() - a.getValue().length());
            }).collect(Collectors.toList()).get(0);
            wordIndex = maxEntry.getKey();
        }
        System.out.println(result);
    }
}
