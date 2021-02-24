package tree;

import java.util.Iterator;

/**
 * @Author Baker.chen
 * @create 2021/1/22 0:23
 */
public class N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        if (root.children != null && root.children.size() > 0) {
            Iterator<Node> iterator = root.children.iterator();
            while (iterator.hasNext()) {
                int temp = maxDepth(iterator.next());
                max = Math.max(max, temp);
            }
        }
        return max + 1;
    }
}
