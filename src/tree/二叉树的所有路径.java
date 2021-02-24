package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Baker.chen
 * @create 2021/1/24 15:07
 */
public class 二叉树的所有路径 {
    /**
     * 递归法：深度优先遍历（前序遍历）
     * 隐式的使用了回溯算法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        return binaryTreePaths(root, "", list);
    }
    public List<String> binaryTreePaths(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return res;
        }
        // 先处理根节点
        path = path + String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(path);
        } else {
            path = path + "->";
            // 递归处理左子树
            binaryTreePaths(root.left, path, res);
            // 递归处理右子树
            binaryTreePaths(root.right, path, res);
        }
        return res;
    }
    /**
     * 迭代法：深度优先遍历（前序遍历）
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 创建一个栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 根节点入栈
        stack.push(root);
        // 创建一个辅助容器，便于回溯
        List<Integer> temp = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.add(node.val);
            if (node.left == null && node.right == null) {
                String path = "";
                for (int i = 0; i < temp.size() - 1; i++) { // 将path里记录的路径转为string格式
                    path += String.valueOf(temp.get(i));
                    path += "->";
                }
                path += String.valueOf(temp.get(temp.size() - 1)); // 记录最后一个节点（叶子节点）
                list.add(path);
                // 需要回溯，将temp集合里的最后一个元素移除
                temp.remove(temp.size() - 1);
            }
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
