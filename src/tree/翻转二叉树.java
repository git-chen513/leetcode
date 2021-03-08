package tree;

import java.util.LinkedList;

/**
 * @Author Baker.chen
 * @create 2021/1/21 0:42
 */
public class 翻转二叉树 {
    /**
     * 递归法——前序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归终止的条件
        if (root == null) {
            return root;
        }
        // 先处理根节点——交换左右节点（即使左右节点为空或者有一方为空都满足下面的代码）
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        // 递归处理左子树
        root.left = invertTree(root.left);
        // 递归处理右子树
        root.right = invertTree(root.right);
        return root;
    }
    /**
     * 迭代法——前序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 创建一个栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 对于每个节点，交换其左右孩子
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 对于每个节点，交换其左右孩子
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
