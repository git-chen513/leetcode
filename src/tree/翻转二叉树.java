package tree;

/**
 * @Author Baker.chen
 * @create 2021/1/21 0:42
 */
public class 翻转二叉树 {
    /**
     * 递归法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归终止的条件
        if (root == null) {
            return root;
        }
        // 交换左右节点（即使左右节点为空或者有一方为空都满足下面的代码）
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        // 递归处理左子树
        root.left = invertTree(root.left);
        // 递归处理右子树
        root.right = invertTree(root.right);
        return root;
    }
}
