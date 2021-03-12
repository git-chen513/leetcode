package tree;

import java.util.Arrays;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int len1 = inorder.length;
        int len2 = postorder.length;
        // 后序遍历数组的最后一个节点为根节点
        int val = postorder[len2 - 1];
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
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, temp), Arrays.copyOfRange(postorder, 0, temp));
        // 递归构建根节点的左子树
        root.right = buildTree(Arrays.copyOfRange(inorder, temp + 1, len1), Arrays.copyOfRange(postorder, temp, len2 - 1));
        return root;
    }
}
