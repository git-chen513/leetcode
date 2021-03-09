package tree;

import java.util.LinkedList;

public class 找树左下角的值 {
    /**
     * 使用层序遍历，当遍历到最后一行，那么第一个节点就是所求的节点
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 求二叉树的层数
        int level = maxDepth(root);
        // 记录当前遍历的层数
        int count = 0;
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            count++;
            if (count == level) {
                return queue.poll().val;
            }
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }
    /**
     * 递归法求二叉树的最大深度（即二叉树的层数）
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 递归出口
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
