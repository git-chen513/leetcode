package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/9 11:14
 *
 * 注意：对于链表题目，我们需要区分head节点是第一个有效节点还是一个虚拟节点（不存放任何值，仅仅用来指向第一个有效节点）
 *      而对于leetcode中关于链表的题目，head头结点指的就是第一个有效节点，并不是虚拟节点
 *      通常在解题中，为了方便链表的一些操作，我们会给链表设置一个虚拟头结点
 */
public class 移除链表元素 {
    /**
     * 方法一：直接在原来的链表进行删除
     *       由于单链表的局限性，删除一个节点需要找到它的前一个节点
     *       那么如果待删除节点是第一个节点head，没有前一个节点，这种情况就得单独处理
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 特殊情况：链表的头结点值等于val，那么直接将head指针往后移
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 方法二：使用虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 创建一个节点，用来充当虚拟头结点
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = node;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        // 注意这里需要返回虚拟头结点的指针域
        return node.next;
    }
}

