import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class 二叉树计算 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // 根据前序和中序遍历结果构建二叉树
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 创建根节点，根节点的值为前序遍历的第一个元素
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        // 在中序遍历中找到根节点的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        // 计算左子树的节点数量
        int leftTreeSize = inIndex - inStart;
        // 递归构建左子树
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, inIndex - 1);
        // 递归构建右子树
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }

    // 更新节点值为其所有子节点的和
    public static int updateTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归更新左子树和右子树，并计算子树的和
        int leftSum = updateTree(node.left);
        int rightSum = updateTree(node.right);
        int oldVal = node.val;
        // 更新当前节点的值为子树的和
        node.val = leftSum + rightSum;
        return node.val + oldVal;
    }

    // 中序遍历
    public static void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取中序遍历结果
        String[] inorderStr = scanner.nextLine().split(" ");
        int[] inorder = new int[inorderStr.length];
        for (int i = 0; i < inorderStr.length; i++) {
            inorder[i] = Integer.parseInt(inorderStr[i]);
        }
        // 读取前序遍历结果
        String[] preorderStr = scanner.nextLine().split(" ");
        int[] preorder = new int[preorderStr.length];
        for (int i = 0; i < preorderStr.length; i++) {
            preorder[i] = Integer.parseInt(preorderStr[i]);
        }

        // 根据中序和前序遍历的结果构造二叉树
        TreeNode root = buildTree(preorder, inorder);
        // 更新二叉树的节点值
        updateTree(root);
        // 创建列表，保存中序遍历的结果
        List<Integer> result = new ArrayList<>();
        // 中序遍历二叉树，保存结果
        inorderTraversal(root, result);

        // 输出结果
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(result.get(i));
        }
        System.out.println();
        scanner.close();
    }
}

