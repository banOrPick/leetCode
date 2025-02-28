import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class 预订酒店 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int x = Integer.parseInt(split[2]);
        String input2 = scanner.nextLine();
        List<Integer> priceList = Arrays.stream(input2.split(" ")).map(m -> Integer.parseInt(m)).
                collect(Collectors.toList());
        Map<Integer, List<Integer>> resultMap = new TreeMap<Integer, List<Integer>>();
        for (int i = 0; i < priceList.size(); i++) {
            Integer price = priceList.get(i);
            List<Integer> indexList = resultMap.get(Math.abs(x - price));
            if (indexList == null) {
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            resultMap.put(Math.abs(x - price), indexList);

        }
        List<Integer> resultList = new LinkedList<>();
        int tmp = k;
        for (Map.Entry<Integer, List<Integer>> entry :
                resultMap.entrySet()) {
            List<Integer> indexList = entry.getValue();
            for (int i = 0; i < indexList.size(); i++) {
                resultList.add(priceList.get(indexList.get(i)));
                k--;
            }
            if (k <= 0) {
                break;
            }

        }
        StringBuffer result = new StringBuffer();
        resultList.stream().sorted().collect(Collectors.toList()).subList(0, tmp).stream().forEach(s -> {
            result.append(s).append(" ");
        });
        System.out.println(result.toString().trim());
        scanner.close();
    }
}
