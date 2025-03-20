import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 生成哈夫曼树 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        Tree root = buildTree(input);
        StringBuilder result = new StringBuilder();
        inorderTraversal(root, result);
        System.out.println(result.toString().trim());
        scanner.close();
    }

    private static Tree buildTree(String[] input) {
        LinkedList<Tree> linkedList = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            Tree tree = new Tree();
            tree.value = Integer.parseInt(input[i]);
            tree.height = 0;
            tree.left = null;
            tree.right = null;
            linkedList.add(tree);
        }
        while (linkedList.size() > 1) {
            linkedList.sort((a,b)->{
                return a.value!=b.value?a.value-b.value:a.height-b.height;
            });
            Tree left = linkedList.get(0);
            Tree right = linkedList.get(1);
            int parentValue = right.getValue() + left.getValue();
            Tree parent = new Tree();
            parent.left = left;
            parent.right = right;
            parent.value = parentValue;
            parent.height = Math.max(right.height, left.height) + 1;
            linkedList.remove(left);
            linkedList.remove(right);
            linkedList.add(parent);
        }

        return linkedList.get(0);
    }

    // 中序遍历哈夫曼树，并将遍历结果保存为字符串
    public static void inorderTraversal(Tree root, StringBuilder result) {
        if (root != null) {
            inorderTraversal(root.left, result);  // 遍历左子树
            result.append(root.value).append(" ");  // 访问当前节点
            inorderTraversal(root.right, result);  // 遍历右子树
        }
    }


    static class Tree {
        Tree left;
        Tree right;
        int value;
        int height;

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }


        public Tree() {
        }
    }
}
