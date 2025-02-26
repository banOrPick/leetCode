import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 单向链表中间节点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] s = firstLine.split(" ");
        List<String> firstLineList = Arrays.stream(s).collect(Collectors.toList());
        String currentAddress = s[0];
        int n = Integer.parseInt(s[1]);
        List<Integer> dataLinkedList = new LinkedList<>();
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dataList.add(scanner.nextLine());
        }
        while (dataList.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {
                String data = dataList.get(i);
                String[] temp = data.split(" ");
                if (temp[0].equals(currentAddress)) {
                    dataLinkedList.add(Integer.parseInt(temp[1]));
                    currentAddress = temp[2];
                    dataList.remove(i);
                    break;
                }
            }
        }
        System.out.println(dataLinkedList.get(n/2));
    }
}
