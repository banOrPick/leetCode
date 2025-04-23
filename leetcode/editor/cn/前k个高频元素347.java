import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 前k个高频元素347 {
    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toList());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = collect.get(i).getKey();
        }
        return result;
    }
}
