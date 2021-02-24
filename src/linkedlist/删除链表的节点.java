package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/9 21:58
 */
public class 删除链表的节点 {
    /**
     * 方法一：使用虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 定义一个虚拟头结点
        ListNode node = new ListNode(0);
        node.next = head;
        // 定义一个辅助节点来遍历链表
        ListNode cur = node;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        // 注意返回的链表头结点是虚拟节点的指针域
        return node.next;
    }

    /**
     * 方法二：直接在原链表上进行操作，但是需要分两种情况：
     *        1. 待删除节点是第一个节点，也就是头结点
     *        2. 待删除节点不是第一个节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 待删除节点是第一个节点，也就是头结点的情况
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 定义一个辅助节点来遍历链表
        ListNode cur = head;
        // 待删除节点不是第一个节点的情况
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
