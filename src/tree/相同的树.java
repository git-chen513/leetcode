package tree;

import java.util.LinkedList;

public class 相同的树 {
    /**
     * 递归法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两个节点都为空，true
        if (p == null && q == null) {
            return true;
        }
        // 一个为空，一个不为空，false
        if (p == null || q == null) {
            return false;
        }
        // 都不为空，但节点值不相等，false
        if (p.val != q.val) {
            return false;
        }
        // 递归判断p树的左子树与q树的左子树是否相同以及p树的右子树与q树的右子树是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 迭代法（使用队列或栈进行成对的比较）
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // 创建一个队列（队列也可以存放空节点）
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点先入队
        queue.offer(p);
        queue.offer(q);
        while (queue.size() > 0) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 两个节点都为空，true
            if (node1 == null && node2 == null) {
                continue;
            }
            // 一个为空，一个不为空，false
            if (node1 == null || node2 == null) {
                return false;
            }
            // 都不为空，但节点值不相等，false
            if (node1.val != node2.val) {
                return false;
            }
            // 子节点成对的入队
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }
}
