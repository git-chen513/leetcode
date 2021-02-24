package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Baker.chen
 * @create 2021/1/21 0:27
 */
public class N叉树的后序遍历 {
    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return postorder(root, list);
    }
    public List<Integer> postorder(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        if (root.children != null && root.children.size() > 0) {
            Iterator<Node> iterator = root.children.iterator();
            while (iterator.hasNext()) {
                postorder(iterator.next(), list);
            }
        }
        list.add(root.val);
        return list;
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer>  postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        // 根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(0, node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
}
