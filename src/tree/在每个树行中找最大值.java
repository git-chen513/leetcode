package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            // max初始化为每一层第一个节点的值（不可以初始化为0，因为节点值可能为负）
            int max = queue.peek().val;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
