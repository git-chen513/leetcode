package linkedlist;

/**
 * @Author Baker.chen
 * @create 2020/9/11 0:54
 *
 * k个一组翻转链表
 */
public class ReverseKGroup {

    /**
     * k个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 如果链表为空或者链表只有一个节点，那么就无需反转
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode end = head;
        for (int i = 1; i < k && end != null; i++) {
            end = end.next;
        }
        if (end == null) {
            // 说明链表的节点数小于k，无需反转
            return head;
        }
        ListNode temp = end.next;
        end.next = null;
        ListNode reverse = reverse(start);
        ListNode tail = reverse;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 反转后链表的最后一个节点指向后面递归进行反转返回的第一个节点
        tail.next = reverseKGroup(temp, k);
        return reverse;
    }

    /**
     * 反转链表，传入的参数head为链表的第一个节点
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        // 如果链表为空或者链表只有一个节点，那么就无需反转
        if (head == null || head.next == null) {
            return head;
        }
        // 当前节点的前一个节点，初始为null
        ListNode pre = null;
        // 当前节点，初始为链表的第一个节点
        ListNode cur = head;
        // 当前节点的后一个节点，初始为链表的第二个节点
        ListNode tail = head.next;
        while (tail != null) {
            cur.next = pre;
            pre = cur;
            cur = tail;
            tail = tail.next;
        }
        // 注意：退出循环时，原链表最后一个节点还没有执行指向前一个节点的操作
        cur.next = pre;
        // 将头节点指向原链表的最后一个节点
        head = cur;
        return head;
    }

    /**
     * 根据链表的第一个节点遍历链表
     */
    public static void ListNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode node = head;
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.val + "->");
            } else {
                System.out.print(node.val);
            }
            node = node.next;
        }
    }
    public static void main(String[] args) {
        LinkedListHandle handle = new LinkedListHandle();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        handle.add(node1);
        handle.add(node2);
        handle.add(node3);
        handle.add(node4);
        handle.add(node5);
        handle.add(node6);

        ListNode(node1);
        System.out.println();

        ListNode reverse = reverseKGroup(node1, 3);
        ListNode(reverse);
    }
}
