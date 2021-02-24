package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/10 1:00
 */
public class 反转链表 {
    /**
     * 双指针法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 指向当前节点的前一个节点
        ListNode cur = head; // 指向当前节点
        ListNode next = head.next; // 指向当前节点的后一个节点
        while (cur.next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        // 退出循环的时候，最后一个节点的指针域还没有指向上一个节点
        cur.next = pre;
        return cur;
    }

    /**
     * 双指针的另一种写法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 指向当前节点的前一个节点
        ListNode cur = head; // 指向当前节点
        ListNode next = null; // 指向当前节点的后一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
