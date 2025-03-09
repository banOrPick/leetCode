import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 计算三叉搜索树的高度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(m -> Integer.parseInt(m)).collect(Collectors.toList());
        ThreeTree root=new ThreeTree(list.get(0),null,null,null);
        for (int i = 1; i < list.size(); i++) {
            root.insert(root,list.get(i));
        }
        System.out.println(root.getHeight(root));

    }


}

 class ThreeTree {

    public int value;
    public ThreeTree leftNode;
    public ThreeTree midNode;
    public ThreeTree rightNode;

    public ThreeTree(int value, ThreeTree leftNode, ThreeTree midNode, ThreeTree rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.midNode = midNode;
        this.rightNode = rightNode;
    }

    public ThreeTree(int value) {
        this.value = value;
    }

    public void insert(ThreeTree node, int value) {
        int rootValue = node.value;
        if (value < rootValue - 500) {
            if (node.leftNode != null) {
                insert(node.leftNode, value);
            } else {
                ThreeTree leftNode = new ThreeTree(value, null, null, null);
                node.leftNode = leftNode;
            }
        } else if (value > rootValue + 500) {
            if (node.rightNode != null) {
                insert(node.rightNode, value);
            } else {
                ThreeTree rightNode = new ThreeTree(value, null, null, null);
                node.rightNode = rightNode;
            }
        } else {
            if (node.midNode != null) {
                insert(node.midNode, value);
            } else {
                ThreeTree midNode = new ThreeTree(value, null, null, null);
                node.midNode = midNode;
            }
        }
    }

    // 获取树的高度
    public int getHeight(ThreeTree root) {
        if (root == null) {
            return 0; // 如果根节点为空，高度为0
        }
        int leftHeight = getHeight(root.leftNode); // 计算左子树的高度
        int midHeight = getHeight(root.midNode); // 计算中间子树的高度
        int rightHeight = getHeight(root.rightNode); // 计算右子树的高度
        return Math.max(Math.max(leftHeight, midHeight), rightHeight) + 1; // 返回三者中最大的高度加1
    }
}
