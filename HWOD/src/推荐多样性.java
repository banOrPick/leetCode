import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 推荐多样性 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        List<Queue<Integer>> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            Queue<Integer> array = Arrays.stream(input.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
            list.add(array);

        }
        int size = list.size();
        int[][] ints = new int[k][n];

        for (int i = 0; i < k; i++) {
            Queue<Integer> linkedList = list.get(i % size);
            for (int j = 0; j < n; j++) {
                ints[i][j] = linkedList.poll();
                if (linkedList.isEmpty()) {
                    linkedList = list.get((i + 1) % size);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                result.append(ints[j][i]).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }


}

