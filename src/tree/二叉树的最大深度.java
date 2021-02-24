package tree;

/**
 * @Author Baker.chen
 * @create 2021/1/22 0:10
 */
public class 二叉树的最大深度 {
    /**
     * 递归法
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
