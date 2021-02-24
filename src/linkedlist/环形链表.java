package linkedlist;

/**
 * 判断链表是否有环，可以使用快慢指针法，快指针一次走两步，慢指针一次走一步，如果最终快慢指针相遇，说明有环，如果快指针为null，说明无环
 * 只要存在环，那么快慢指针一定会相遇，因为相对于快指针来说，慢指针是每次一步一步的去靠近快指针，那么迟早会相遇
 * 而如果快指针每次不是走两步，而是三步或者四步，那么快慢指针就有可能错过，不会相遇
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
