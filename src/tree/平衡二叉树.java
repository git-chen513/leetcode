package tree;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        // 求解根节点左子树的最大深度
        int left = maxDepth(root.left);
        // 求解根节点左子树的最大深度
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        // 递归判断左右子树是否满足平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }
    /**
     * 递归法求二叉树的最大深度（也可以说求根节点的高度）
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
