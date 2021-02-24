package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/10 16:52
 */
public class 反转链表II {
    /**
     * 思路：把链表分成三条(前部分链表,反转链表和后部分链表)
     *      找到前部分链表的尾节点(第m-1个节点)就可以开始反转,最后把三个链表拼接
     *      前部分链表(1~m-1)
     *      反转链表(m~n)
     *      后部分链表(n~最后)
     *
     * 由于1<=m<=n<=链表长度
     * 所以应该注意m=1和n=链表长度这两种特殊情况
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        // 注意：m=1和m!=1要区分处理
        if (m == 1) {
            // 定位到第n个节点
            ListNode node = head;
            for (int i = m; i < n; i++) {
                node = node.next;
            }
            // 保存第n+1个节点
            ListNode tail = node.next;
            node.next = null;
            // 对m-n部分节点进行反转
            ListNode reverse = reverse(head);
            // 遍历到反转后的链表的最后一个节点（后面需要用到）
            ListNode end = reverse;
            while (end.next != null) {
                end = end.next;
            }
            // 让反转后的链表的最后一个节点指向第n+1个节点
            end.next = tail;
            return head;
        }
        // 首先定位到第m-1个节点
        ListNode cur = head;
        for (int i = 1; i < m - 1; i++) {
            cur = cur.next;
        }
        // 保存第m个节点
        ListNode temp = cur.next;
        cur.next = null;
        // 定位到第n个节点
        ListNode node = temp;
        for (int i = m; i < n; i++) {
            node = node.next;
        }
        // 保存第n+1个节点
        ListNode tail = node.next;
        node.next = null;
        // 对m-n部分节点进行反转
        ListNode reverse = reverse(temp);
        // 遍历到反转后的链表的最后一个节点（后面需要用到）
        ListNode end = reverse;
        while (end.next != null) {
            end = end.next;
        }
        // 让第m-1个节点指向反转后的链表
        cur.next = reverse;
        // 让反转后的链表的最后一个节点指向第n+1个节点
        end.next = tail;
        return head;
    }

    /**
     * 使用虚拟头结点：好处是不需要对m=1和m!=1区分讨论
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义一个虚拟头结点
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        // 首先定位到第m-1个节点
        ListNode cur = newNode;
        for (int i = 1; i < m - 1; i++) {
            cur = cur.next;
        }
        // 保存第m个节点
        ListNode temp = cur.next;
        cur.next = null;
        // 定位到第n个节点
        ListNode node = temp;
        for (int i = m; i < n; i++) {
            node = node.next;
        }
        // 保存第n+1个节点
        ListNode tail = node.next;
        node.next = null;
        // 对m-n部分节点进行反转
        ListNode reverse = reverse(temp);
        // 遍历到反转后的链表的最后一个节点（后面需要用到）
        ListNode end = reverse;
        while (end.next != null) {
            end = end.next;
        }
        // 让第m-1个节点指向反转后的链表
        cur.next = reverse;
        // 让反转后的链表的最后一个节点指向第n+1个节点
        end.next = tail;
        return newNode.next;
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
