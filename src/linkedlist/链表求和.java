package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/12 22:26
 */
public class 链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建新链表的虚拟头结点
        ListNode head = new ListNode(0);
        // 辅助节点来定位新链表
        ListNode cur = head;
        // 辅助变量代表是否向上一位进1
        int count = 0;
        // 循环判断的条件不要忘了加上 count!=0 这个条件
        while (l1 != null || l2 != null || count != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + count;
            count = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 注意返回的是第一个节点，而不是虚拟头结点
        return head.next;
    }
}
