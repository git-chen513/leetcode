package linkedlist;

/**
 * @Author Baker.chen
 * @create 2020/8/8 23:14
 *
 * 问题：返回链表的中间结点，如果有两个中间结点，则返回第二个中间结点。
 *
 *
 */
public class middleNode {

    public static ListNode test(ListNode head) {
        if (head.next == null) {
            return null;
        }
        // 快慢指针初始状态都指向了链表的第一个节点
        ListNode quick = head.next;
        ListNode slow = head.next;
        // 快指针走两步，慢指针走一步
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListHandle handle = new LinkedListHandle();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        handle.add(node1);
        handle.add(node2);
        handle.add(node3);
        handle.add(node4);
        handle.add(node5);

        ListNode middleNode = test(handle.getHead());
        System.out.println(middleNode.val);
    }
}
