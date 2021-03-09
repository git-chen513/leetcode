package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 另一个树的子树 {
    /**
     * 方法一：
     *  思路：
     *      1. 先遍历一遍s二叉树，找出节点值等于t二叉树根节点值的所有节点，存放于list集合中
     *      2. 遍历这个list集合，依次判断以list集合中的节点作为根节点的s子树与t二叉树是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        List<TreeNode> res = new ArrayList<>();
        // 先找出节点值等于val的那部分节点
        findNode(s, t.val, res);
        // 遍历res集合，找出是否有满足要求的节点
        for (TreeNode node : res) {
            boolean flag = isSameTree(node, t);
            if (flag == true) {
                return true;
            }
        }
        return false;
    }
    /**
     * 对于给定的二叉树，找出节点值等于val的那部分节点，并将节点存放在list集合中
     * 使用递归的前序遍历遍历整颗二叉树
     * @param root
     * @param val
     * @return
     */
    public void findNode(TreeNode root, int val, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        // 先处理根节点
        if (root.val == val) {
            res.add(root);
        }
        // 递归处理左子树
        findNode(root.left, val, res);
        // 递归处理右子树
        findNode(root.right, val, res);
    }
    /**
     * 判断两颗树是否相同
     * 使用迭代法（使用队列或栈进行成对的比较）
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
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

    /**
     * 方法二：递归判断
     *  思路：判断一棵树t是否为另一棵树s的子树，有三种情况：这两棵树要么相同，要么s是t的左树的子树，要么s是t的右树的子树
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree2(s.left, t) || isSubtree2(s.right, t);
    }
}
