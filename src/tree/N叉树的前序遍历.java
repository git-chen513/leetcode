package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class N叉树的前序遍历 {
    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return preorder(root, list);
    }
    public List<Integer> preorder(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.children != null && root.children.size() > 0) {
            Iterator<Node> iterator = root.children.iterator();
            while (iterator.hasNext()) {
                preorder(iterator.next(), list);
            }
        }
        return list;
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        // 根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
}
