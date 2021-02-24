package linkedlist;

public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 先判断链表是否有环
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 说明有环，进一步求出环的入口
                // 慢指针回到第一个节点，快指针保持在相遇位置，然后快慢指针各走一步，当再次相遇的时候，说明到了环的入口
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        // 代码执行到此处，说明无环
        return null;
    }
}
