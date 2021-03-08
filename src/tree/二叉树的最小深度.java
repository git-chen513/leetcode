package tree;

import java.util.LinkedList;

// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量（注意是最近叶子节点）
public class 二叉树的最小深度 {
    /**
     * 迭代法：使用层次遍历，当遇到第一个叶子节点就返回当前层数
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // 记录层数，遇到第一个叶子节点就退出，返回该值
        int res = 0;
        while (queue.size() > 0) {
            res++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    queue.offer(root.left);
                }
                if (node.right != null) {
                    queue.offer(root.right);
                }
            }
        }
        return res;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 如果根节点的左节点为空，右节点不为空，那么二叉树的最小深度等于右子树的最小深度加1
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // 如果根节点的右节点为空，左节点不为空，那么二叉树的最小深度等于左子树的最小深度加1
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        // 如果根节点的左右节点都不为空，那么二叉树的最小深度等于左右子树的最小深度加1
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }
}
