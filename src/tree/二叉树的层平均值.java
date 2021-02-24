package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int count = 0;
            for (int i = queue.size(); i > 0; i--) {
                count++;
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / count);
        }
        return res;
    }
}
