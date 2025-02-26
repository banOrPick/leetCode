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
            TreeMap<Integer, Integer> resultMap = new TreeMap<>();
            list.stream().forEach(str -> {
//                HashMap<Integer, Integer> resultMap = new HashMap<>();
                int tmpIndex = index.getAndIncrement() ;
                if (lastChar == str.charAt(0)) {
                    resultMap.put(tmpIndex, str.length());
                }
            });
            if (resultMap.isEmpty() || resultMap.size() == 0) {
                flag = false;
                break;
            }
            Map.Entry<Integer, Integer> maxEntry= resultMap.entrySet().stream().sorted((a, b) -> {
                return b.getValue() - a.getValue();
            }).collect(Collectors.toList()).get(0);
            Integer maxLength = maxEntry.getValue();
//            Map.Entry<Integer, Integer> maxEntry = resultMap.lastEntry();
            for (Map.Entry<Integer, Integer> entry :
                    resultMap.entrySet()) {
                if (entry.getValue() == maxLength && entry.getKey() < maxEntry.getKey()) {
                    maxEntry = entry;
                }
            }
            wordIndex = maxEntry.getKey();
        }
        System.out.println(result);
    }
}
