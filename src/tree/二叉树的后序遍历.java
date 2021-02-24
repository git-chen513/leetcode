package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的后序遍历 {
    /**
     * 方法一：递归法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return postorderTraversal(root, list);
    }
    public List<Integer> postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
        return list;
    }

    /**
     * 方法二：迭代法
     *  思路：后序遍历的迭代法只需要在前序遍历的迭代法基础做一下修改即可
     *       前序遍历是中左右，后序遍历是左右中，我们可以先实现中右左，然后再用一个栈逆序打印出来，就是左右中了
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        // 根节点入栈1
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            // 出栈的节点值存放到栈2
            stack2.push(node.val);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        // 最后，将栈2的值一一出栈放到结果list中
        List<Integer> list = new ArrayList<>();
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        return list;
    }
}
