package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Baker.chen
 * @create 2021/1/20 0:59
 */
public class 二叉树的中序遍历 {
    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorderTraversal(root, list);
    }
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }

    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
