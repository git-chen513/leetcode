package tree;

/**
 * @Author Baker.chen
 * @create 2020/8/19 15:45
 *
 * 二叉树的镜像
 * 思路：
 *  1. 当二叉树根节点为null或者根节点的左右节点都为空，那么无需处理，直接返回根节点
 *  2. 交换二叉树的左右节点，这里不用判断左右节点其中一个为空的情况，因为即使一个为null，交换位置也能达到我们要的效果
 *  3. 交换之后，再判断根节点的左节点是否为空，不为空再递归的对根节点的左节点做处理
 *  4. 判断根节点的右节点是否为空，不为空再递归的对根节点的右节点做处理
 */
public class MirrorTree {

    public static Node test(Node root) {
        if (root == null) {
            return null;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return root;
        }
        // 交换根节点的左右节点
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
        // 如果根节点的左节点不为空，递归处理
        if (root.leftChild != null) {
            test(root.leftChild);
        }
        if (root.rightChild != null) {
            // 如果根节点的右节点不为空，递归处理
            test(root.rightChild);
        }
        return root;
    }
}
