package tree;

import java.util.LinkedList;

public class 对称二叉树 {
    /**
     * 解法一（迭代）：使用队列
     *  把左右两个子树要比较的元素顺序放进一个容器，然后成对成对的取出来进行比较（这里使用栈也是可以的，只需要把队列改成栈即可）
     *  这种迭代法并不是严格的前中后遍历，也不是层序遍历
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // 如果二叉树为空或者左右子树都为空，直接返回true
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点的左右节点入队（注意：节点为null也会入队，出队的时候再进行判断即可）
        queue.offer(root.left);
        queue.offer(root.right);
        while (queue.size() > 0) {
            // 出队两个节点进行判断
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 待比较的两个节点都为空，跳出本层循环，继续往后比较
            if (node1 == null && node2 == null) {
                continue;
            }
            // 待比较的两个节点一个为空一个不为空，不满足，直接返回false
            if (node1 == null || node2 == null) {
                return false;
            }
            // 待比较的两个节点值不相等，不满足，直接返回false
            if (node1.val != node2.val) {
                return false;
            }
            // 节点node1的左节点和节点node2的右节点依次入队
            queue.offer(node1.left);
            queue.offer(node2.right);
            // 节点node1的右节点和节点node2的左节点依次入队
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    /**
     * 解法二：递归法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root==null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left,root.right);
    }
    // 对根节点的左右子树进行判断
    boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        //再递归的比较左节点的左孩子和右节点的右孩子
        //以及比较左节点的右孩子和右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
