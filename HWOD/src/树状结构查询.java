import java.util.*;

public class 树状结构查询 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            Node node = new Node();
            node.childNode= split[0].charAt(0);
            node.parentNode = split[1].charAt(0);
            nodes.add(node);
        }
        char root = scanner.nextLine().charAt(0);
        List<Character> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        list.add(root);
        getResult(list, result, nodes);
        result.sort(Comparator.naturalOrder());

        result.forEach(System.out::println);
    }

    private static void getResult(List<Character> root, List<Character> result, List<Node> nodes) {
        List<Character> tmpRoot = new ArrayList<>();
        if (root.size() == 0) {
            return;
        }
        for (Node node : nodes) {
            if (root.contains(node.parentNode)) {
                tmpRoot.add(node.childNode);
                result.add(node.childNode);
            }
        }
        getResult(tmpRoot, result, nodes);
    }

    static class Node {
        char parentNode;
        char childNode;
    }
}
