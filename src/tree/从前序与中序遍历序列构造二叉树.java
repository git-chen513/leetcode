package tree;

import java.util.Arrays;

public class 从前序与中序遍历序列构造二叉树 {
    /**
     * 递归法：
     * 先通过先序遍历数组找出根节点，再通过根节点在中序遍历数组中的位置切分左子先序遍历数组和左子中序遍历数组以及右子先序遍历数组和右子中序遍历数组
     * 然后通过左子先序遍历数组和左子中序遍历数组递归创建左子树
     * 通过右子先序遍历数组和右子中序遍历数组递归创建右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 先序遍历数组的第一个节点为根节点
        int val = preorder[0];
        // 找出根节点在中序遍历数组的位置，用一个变量记录该下标
        int temp = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                temp = i;
                break;
            }
        }
        // 创建一个根节点
        TreeNode root = new TreeNode(val);
        // 递归构建根节点的左子树
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + temp), Arrays.copyOfRange(inorder, 0, temp));
        // 递归构建根节点的左子树
        root.right = buildTree(Arrays.copyOfRange(preorder, temp + 1, preorder.length), Arrays.copyOfRange(inorder, temp + 1, inorder.length));
        return root;
    }
}
