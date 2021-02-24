package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 创建一个队列
        LinkedList<Node> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node node = queue.poll();
                temp.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    Iterator<Node> iterator = node.children.iterator();
                    while (iterator.hasNext()) {
                        queue.offer(iterator.next());
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}
