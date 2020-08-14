package linkedlist;

/**
 * @Author Baker.chen
 * @create 2020/8/9 12:11
 *
 * 环路检测：给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 * 思路：先让快指针一次走两步，慢指针一次走一步，如果最终快指针指向了null，说明不存在环
 *      如果快慢指针相遇，说明存在环；那么让慢指针回到原点（第一个节点），快指针保持不动（第一次相遇的位置）
 *      接下来快指针走一步，慢指针也走一步，直到再次相遇，就来到了环的入口了（环路的开头节点）
 */
public class detectCycle {

    public static ListNode test(ListNode head) {
        if (head.next == null) {
            return null;
        }
        // 快慢指针指向链表的第一个节点
        ListNode quick = head.next;
        ListNode slow = head.next;
        // 用来标识是否有环
        boolean flag = false;
        while (quick != null && quick.next != null) {
            // 快指针一次走两步，慢指针一次走一步
            quick = quick.next.next;
            slow = slow.next;
            // 快慢指针相遇说明有环
            if (quick == slow) {
                flag = true;
                break;
            }
        }
        if (flag == true) {
            // 有环，慢指针重新回到链表的第一个节点，快指针还在第一次相遇的地方
            slow = head.next;
            // 接下来快指针走一步，慢指针走一步，再次相遇的时候就是环的入口
            while (slow != quick) {
                quick = quick.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
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
        node5.next = node1;

        ListNode node = test(handle.getHead());
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("无环~");
        }
    }
}
