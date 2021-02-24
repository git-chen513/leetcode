package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的右视图 {
    /**
     * 思路：还是像层序遍历那样去遍历二叉树，只是当遍历到每一层的最右边一个节点，就将其加入List中
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (i == 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
