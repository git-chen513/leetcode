package tree;

import java.util.Arrays;

/**
 * @Author Baker.chen
 * @create 2020/8/18 15:35
 *
 * 重建二叉树：
 *  输入某二叉树的前序遍历和中序遍历的结果，重建该二叉树。
 *  假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class RebuildBinaryTree {

    /**
     * @param preorder 先序遍历返回的结果数组
     * @param inorder  中序遍历返回的结果数组
     * @return
     */
    public static Node buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 先序遍历数组的第一个值为根节点
        int val = preorder[0];
        // 中间变量，用来保存根节点所在中序遍历数组的下标位置
        int temp = 0;
        // 查找根节点所在中序遍历数组的下标位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                temp = i;
                break;
            }
        }
        // 创建根节点
        Node root = new Node(val);
        // 递归对根节点的左子树处理
        root.leftChild = buildTree(Arrays.copyOfRange(preorder, 1, 1 + temp), Arrays.copyOfRange(inorder, 0, temp));
        // 递归对根节点的右子树处理
        root.rightChild = buildTree(Arrays.copyOfRange(preorder, 1 + temp, preorder.length), Arrays.copyOfRange(inorder, temp + 1, inorder.length));

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        Node root = buildTree(preorder, inorder);
        BinaryTree bt = new BinaryTree();
        bt.levelOrder(root);
    }
}
