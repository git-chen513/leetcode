package tree;

import java.util.LinkedList;

public class 左叶子之和 {
    /**
     * 递归法（前序遍历）
     *
     * 判断一个节点是否为左叶子节点，需要通过它的父亲节点来判断
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int temp = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            temp += root.left.val;
        }
        return temp + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * 迭代法（前序遍历）
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 创建一个栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 根节点入栈
        stack.push(root);
        // 计算总和
        int sum = 0;
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }
}
