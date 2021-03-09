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
    public List<String> binaryTreePaths1(TreeNode root) {
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
            // 递归处理左子树（这种传递变量的方式其实隐式的进行了回溯，因为每个path字符串递归结束之后的状态都不会影响下一个状态）
            binaryTreePaths(root.left, path, res);
            // 递归处理右子树
            binaryTreePaths(root.right, path, res);
        }
        return res;
    }

    /**
     * 回溯法：深度优先遍历（前序遍历）
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtracking(root, list, res);
        return res;
    }
    public void backtracking(TreeNode root, List<Integer> list, List<String> res) {
        if (root == null) {
            return;
        }
        // 先处理根节点
        list.add(root.val);
        // 递归终止的条件（遇到叶子节点）
        if (root.left == null && root.right == null) {
            String s = "";
            for (int i = 0; i < list.size() - 1; i++) {
                s += list.get(i) + "->";
            }
            s += list.get(list.size() - 1);
            res.add(s);
            // 记得return
            return;
        }
        // 递归处理左子树
        if (root.left != null) {
            backtracking(root.left, list, res);
            // 回溯
            list.remove(list.size() - 1);
        }
        // 递归处理右子树
        if (root.right != null) {
            backtracking(root.right, list, res);
            // 回溯
            list.remove(list.size() - 1);
        }
    }

    /**
     * 迭代法：深度优先遍历（前序遍历）
     * @param root
     * @return
     */
    public List<String> binaryTreePaths3(TreeNode root) {
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
