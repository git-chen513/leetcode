package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {
    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preorderTraversal(root, list);
    }

    public List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
        return list;
    }

    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 根节点先入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
