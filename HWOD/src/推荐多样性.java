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


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 读取窗口数量N
//        int numberOfRows = Integer.parseInt(scanner.nextLine());
//        // 读取每个窗口需要的元素数量K
//        int numberOfColumns = Integer.parseInt(scanner.nextLine());
//
//        // 创建队列列表，用于存储每个列表的元素
//        List<Queue<Integer>> queueList = new ArrayList<>();
//
//        // 循环读取输入的每个列表，并将其转换为队列存储在queueList中
//        while (scanner.hasNextLine()) {
//            String inputLine = scanner.nextLine();
//            Queue<Integer> numberQueue = Arrays.stream(inputLine.split(" "))
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toCollection(LinkedList::new));
//
//            queueList.add(numberQueue);
//        }
//
//        // 创建一个数组，用于存储最终的元素排列
//        int[] matrix = new int[numberOfColumns * numberOfRows];
//        int matrixIndex = 0; // 用于标记当前填充到matrix数组中的位置
//        int queueIndex = 0; // 用于标记当前处理的队列索引
//
//        // 循环，直到matrix数组被完全填满
//        while (matrixIndex < matrix.length) {
//            boolean didRemoveQueue = false; // 标记本轮循环中是否有队列被移除
//
//            // 遍历每个窗口，并尝试从当前队列中为每个窗口提取一个元素
//            for (int i = 0; i < numberOfRows && !queueList.isEmpty(); i++) {
//                // 如果当前队列为空，则移除该队列
//                if (queueList.get(queueIndex).isEmpty()) {
//                    queueList.remove(queueIndex);
//                    if (queueList.isEmpty()) break; // 如果所有队列都已处理完毕，则退出循环
//                    queueIndex %= queueList.size(); // 调整队列索引，防止索引越界
//                    didRemoveQueue = true;
//                }
//                // 如果当前队列不为空，则从队列中取出一个元素填充到matrix数组中
//                if (!queueList.get(queueIndex).isEmpty()) {
//                    matrix[matrixIndex++] = queueList.get(queueIndex).poll();
//                    if (matrixIndex >= matrix.length) break; // 如果matrix数组已填满，则退出循环
//                }
//            }
//
//            // 如果本轮循环没有队列被移除，并且队列列表不为空，则处理下一个队列
//            if (!didRemoveQueue && !queueList.isEmpty()) {
//                queueIndex = (queueIndex + 1) % queueList.size();
//            }
//        }
//
//        // 使用StringBuilder构建最终的输出字符串
//        StringBuilder sb = new StringBuilder();
//        // 遍历matrix数组，按照窗口顺序构建输出字符串
//        for (int row = 0; row < numberOfRows; row++) {
//            for (int col = 0; col < numberOfColumns; col++) {
//                sb.append(matrix[col * numberOfRows + row]).append(" ");
//            }
//        }
//
//        // 输出最终的元素排列，去除末尾的空格
//        System.out.println(sb.toString().trim());
//    }

}

