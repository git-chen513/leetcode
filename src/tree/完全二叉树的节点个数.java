package tree;

public class 完全二叉树的节点个数 {
    /**
     * 递归法
     *
     * 也可以使用层序遍历，每遍历一个节点，值加一
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 递归的求左子树的节点数
        int left = countNodes(root.left);
        // 递归的求右子树的节点数
        int right = countNodes(root.right);
        // 总节点数等于左子树的节点数加上右子树的节点数加上根节点
        return left + right + 1;
    }
}
