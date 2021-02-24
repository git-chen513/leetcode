package linkedlist;

public class 链表的中间节点 {
    /**
     * 使用快慢指针，注意循环结束的条件
     * 注意：如果题目是要求当链表的节点数为偶数，返回第一个中间节点，那么循环结束的条件应该改成快指针的下一节点和下下节点都不为空
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
