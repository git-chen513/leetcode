package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Baker.chen
 * @create 2020/8/19 16:38
 *
 * 树的子结构：
 *  输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *  如果B是A的子结构， 即A中有出现和B相同的结构和节点值。
 *
 * 示例1：
 *  输入：A = [1,2,3], B = [3,1]
 *  输出：false
 *
 * 示例2：
 *  输入：A = [3,4,5,1,2], B = [4,1]
 *  输出：true
 *
 * 思路：
 *  1. 先根据B树的根节点的值去A树查找，是否能查找到值相同的节点,将查找到的节点保存到一个集合list中
 *  (因为A树中节点值等于B树根节点的节点可能有多个）
 *  2. 对于这个查找，可以借助队列进行层次遍历，这样可以避免使用递归节省内存
 *  3. list集合为空，表示查找不到，return false
 *  4. list集合不为空，表示查找到了，再去遍历这个list集合，取出集合中的每个节点作为A子树的根节点
 *  调用recur方法判断树A中以B的根节点为根节点的子树中是否包含B树，集合中只要有一个相等的情况，return true
 */
public class IsSubStructure {

    public static boolean test(Node A, Node B) {
        if(A == null || B == null) {
            return false;
        }
        // B树的根节点的值
        int temp = B.getData();
        // 该集合用来存放A树中节点值等于B树根节点的节点
        List<Node> list = new ArrayList<>();
        // A树查找是否有B树根节点,使用层次遍历（可以避免使用递归）
        Queue<Node> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (tempNode.getData() == temp) {
                list.add(tempNode);
            }
            if (tempNode.leftChild != null) {
                queue.offer(tempNode.leftChild);
            }
            if (tempNode.rightChild != null) {
                queue.offer(tempNode.rightChild);
            }
        }
        // 集合为空，表示A树没有节点值等于B树根节点的情况
        if (list.size() == 0) {
            return false;
        } else {
            // 遍历list集合，判断是否有相等的情况
            for (Node node : list) {
                if (recur(node, B)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断树A中以B的根节点为根节点的子树中是否包含B树
     * @param A
     * @param B
     * @return
     */
    public static boolean recur(Node A, Node B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.getData() != B.getData()) {
            return false;
        }
        return recur(A.leftChild, B.leftChild) && recur(A.rightChild, B.rightChild);
    }
}
