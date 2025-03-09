import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boss的收入 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> allNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            List<Node> nodes = getNode(allNodes, id);
            Node node = null;
            if (!nodes.isEmpty()) {
                node = nodes.get(0);
            }
            int parentId = scanner.nextInt();
            int shouRu = scanner.nextInt();
            if (node == null) {
                node = new Node();
                node.id = id;
                node.shouRu = shouRu;
                node.children = null;
                node.parentId = parentId;
                allNodes.add(node);
            } else {
                allNodes.remove(node);
                node.shouRu = shouRu;
                node.parentId = parentId;
                allNodes.add(node);
            }
            List<Node> parentNodeNodes = getNode(allNodes, parentId);
            Node parentNode = null;
            if (!parentNodeNodes.isEmpty()) {
                parentNode = parentNodeNodes.get(0);
            }
            if (parentNode == null) {
                parentNode = new Node();
                parentNode.id = parentId;
                List<Node> children = new ArrayList<Node>();
                children.add(node);
                parentNode.children = children;
                allNodes.add(parentNode);
            } else {
                allNodes.remove(parentNode);
                parentNode.children.add(node);
                allNodes.add(parentNode);
            }
        }
        Node root = null;
        for (Node node : allNodes) {
            if (node.parentId == null) {
                root = node;
            }
        }
        int result = 0;
        result = getRootShouRu(result, root);
        StringBuffer str = new StringBuffer();
        str.append(root.id).append(" ").append(result);
        System.out.println(str);
    }

    private static int getRootShouRu(int result, Node node) {
        if (node.children != null) {
            for (Node child : node.children) {
                result = getRootShouRu(result, child);
            }
        }
        result += node.shouRu / 100 * 15;
        return result;
    }

    private static List<Node> getNode(List<Node> allNodes, int id) {
        return allNodes.stream().filter(n ->
                n.id == id
        ).collect(Collectors.toList());
    }

    static class Node {
        Integer parentId;
        int id;
        int shouRu;
        List<Node> children;

        public Node() {
        }
    }
}
