package tree;

/**
 * @Author Baker.chen
 * @create 2020/8/19 16:18
 *
 * 二叉树的最大深度：根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepth {

    public static int test(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }
        // 返回左右子树高度最大的一个，结果加1（根节点也算1）
        int leftCount = test(root.leftChild);
        int rightCount = test(root.rightChild);
        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;
    }
}
