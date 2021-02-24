package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/10 15:58
 */
public class k个一组翻转链表 {
    /**
     * 使用递归解法
     * 思路：先对链表的前k个节点进行反转，然后将反转后链表的最后一个节点指向k个节点之后的剩余节点（这部分节点直接使用递归反转）
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 递归的出口，如果链表为空或者只有一个节点，无需反转
        if (head == null || head.next == null) {
            return head;
        }
        // 先对链表的前k个节点进行反转(由于是递归处理，因此这里需要考虑链表的节点数小于k的情况）
        // 1.定位到链表的第k个节点
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k - 1 && end != null; i++) {
            end = end.next;
        }
        // 退出循环，如果end为null，说明链表的节点数小于k，无需反转
        if (end == null) {
            return head;
        }
        // 2.保存第k个节点的后一个节点，防止链表断联
        ListNode temp = end.next;
        end.next = null;
        // 3.对k个节点进行反转操作
        ListNode reverse = reverse(start);
        // 4.对于已经反转好的k个节点，遍历到最后一个节点
        ListNode node = reverse;
        while (node.next != null) {
            node = node.next;
        }
        // 将反转后链表的最后一个节点指向k个节点之后的剩余节点（这部分节点直接使用递归反转）
        node.next = reverseKGroup(temp, k);
        return reverse;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
