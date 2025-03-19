import java.util.*;

public class 空栈压数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        Stack<Integer> queue = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            queue = getNewQueue(array[i], queue);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + " ");
        }

    }

    private static Stack<Integer> getNewQueue(int i, Stack<Integer> queue) {

        if (queue.isEmpty()) {
            queue.push(i);
            return queue;
        } else if (queue.peek() == i) {
            queue.pop();
            queue.push(i * 2);
            return queue;
        } else {
            Stack<Integer> newQueue = new Stack<Integer>();
            newQueue.addAll(queue);
            HashMap<Boolean, Stack<Integer>> map = new HashMap<>();
            Map<Boolean, Stack<Integer>> dfs = dfs(i, queue, 0, newQueue, map);
            if (dfs.get(true) == null || dfs.get(true).isEmpty()) {
                Stack<Integer> list = dfs.get(false);
                list.push(i);
                return list;
            } else {
                return dfs.get(true);
            }
        }
    }

    private static Map<Boolean, Stack<Integer>> dfs(int i, Stack<Integer> queue, int sum, Stack<Integer> newQueue, HashMap<Boolean, Stack<Integer>> map) {
        if (sum < i && !newQueue.isEmpty()) {
            Integer poll = newQueue.pop();
            return dfs(i, queue, sum + poll, newQueue, map);
        } else if (sum == i) {
            newQueue.push(i * 2);
            map.put(true, newQueue);
            return map;
        }
        map.put(false, queue);
        return map;

    }
}
