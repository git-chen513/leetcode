package linkedlist;

/**
 * @Author Baker.chen
 * @create 2020/8/7 10:18
 *
 * 问题：返回倒数第k个节点的值
 * 前提：保证输入的k都是有效的，也就是在正确的范围内，所以这里不用对k值进行校验
 *
 * 快慢指针法：定义两个指针，一个为快指针，走在前面；一个为慢指针，走在后面
 * 初始状态下，快慢指针都指向链表的第一个节点，也就是头节点的下一节点
 * 快指针先走k-1步，慢指针保持不动
 * 当快指针走第k步的时候，慢指针也跟着走，以后快指针走一步，慢指针也跟着走一步
 * 当快指针走到链表的最后一个节点时，慢指针就指向了链表的倒数第k个节点
 */
public class kthToLast {

    public static int test(ListNode head, int k) {
        if (head.next == null) {
            return 0;
        }
        //快慢指针初始态下都指向链表的第一个节点
        ListNode quick = head.next;
        ListNode slow = head.next;
        // 快指针先走k-1步，慢指针保持不动
        for (int i = 1; i < k; i++) {
            quick = quick.next;
        }
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow.val;
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

        int result = test(handle.getHead(), 3);
        System.out.println(result);
    }
}



