package linkedlist;

import java.util.LinkedList;

public class 两数相加II {
    /**
     * 方法一：先对链表进行翻转，最终将结果链表再翻转一次
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 先对链表l1和l2进行反转
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        // 对反转后的链表进行计算
        // 1.创建新链表的虚拟头结点
        ListNode head = new ListNode(0);
        // 2.辅助节点来定位新链表
        ListNode cur = head;
        // 3.辅助变量代表是否向上一位进1
        int count = 0;
        // 4.循环判断的条件不要忘了加上 count!=0 这个条件
        while (r1 != null || r2 != null || count != 0) {
            int val1 = r1 != null ? r1.val : 0;
            int val2 = r2 != null ? r2.val : 0;
            int sum = val1 + val2 + count;
            count = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            if (r1 != null) {
                r1 = r1.next;
            }
            if (r2 != null) {
                r2 = r2.next;
            }
        }
        // 对结果链表进行反转一次得到最终结果
        return reverse(head.next);
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

    /**
     * 方法二：使用栈
     *  思路：由于我们希望对链表的节点进行逆序操作，这时候可以想到栈
     *       将两个链表的所有节点先依次放到两个栈中，最后再分别弹出进行计算
     *       存放结果的链表再使用头插法插入节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 创建两个栈
        LinkedList<Integer> stack1 = new LinkedList();
        LinkedList<Integer> stack2 = new LinkedList();
        // 依次将两个链表的节点值push到栈中
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 创建一个带有头结点的链表，用来存放结果值
        ListNode head = new ListNode(0);
        // 辅助变量代表是否向上一位进1
        int count = 0;
        // 依次弹出两个栈中的元素进行计算
        while (!stack1.isEmpty() || !stack2.isEmpty() || count != 0) {
            int val1 = stack1.size() > 0 ? stack1.pop() : 0;
            int val2 = stack2.size() > 0 ? stack2.pop() : 0;
            int sum = val1 + val2 + count;
            count = sum / 10;
            ListNode node = new ListNode(sum % 10);
            // 使用头插法插入链表
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
}
