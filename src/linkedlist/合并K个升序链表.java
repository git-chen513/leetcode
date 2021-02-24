package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个升序链表 {
    /**
     * 方法一：借助优先队列实现堆排序
     *  思路：维护一个根据链表的第一个节点的值进行排序的小根堆，首先将所有链表入堆，然后依次弹出堆中的堆顶元素
     *       由于是小根堆，所以每次出堆的都是所有链表中第一个节点值最小的那个链表
     *       将出堆的这个链表的第一个节点添加到结果链表中，并将该链表以第二个节点作为头结点的形式入堆，继续维护一个小根堆
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 创建一个大小为k的小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 所有链表入堆
        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            queue.offer(listNode);
        }
        // 创建一个带头结点的结果链表
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            // 堆顶元素弹出
            ListNode node = queue.poll();
            // 如果堆顶元素指针域不为空，那么后半部分链表继续入堆
            ListNode next = node.next;
            node.next = null;
            if (next != null) {
                queue.offer(next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return head.next;
    }
}
