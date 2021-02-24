package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Baker.chen
 * @create 2021/1/12 22:32
 */
public class 排序链表 {
    /**
     * 方法一：堆排序
     *  思路：维护一个根据链表的节点值进行排序的小根堆，遍历链表中的每个节点，让每个节点一次入堆
     *  （注意：入堆的节点应该将其指针域设置为空，让该节点成为一个独立的节点方可入堆，否则会导致整条链表入堆，产生死循环）
     *  待所有节点入堆完毕之后，再依次弹出堆中的每个节点插入到新链表的尾部即可，由于是小根堆，因此会根据节点值从小到大出堆
     * @param head
     * @return
     */
    public static ListNode sortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        // 创建小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        // cur节点用来遍历链表
        ListNode cur = head;
        // temp节点用来保存当前节点的下一节点，防止链表断联，因为要将当前节点的指针域置空
        ListNode temp = null;
        // 链表中所有节点依次入堆
        while (cur != null) {
            temp = cur.next;
            cur.next = null;
            queue.offer(cur);
            cur = temp;
        }
        // 创建一个带有虚拟头结点的链表
        ListNode newNode = new ListNode(0);
        cur = newNode;
        // 依次出堆，使用尾插法插入链表的尾部
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }

        return newNode.next;
    }

    /**
     * 方法二：归并排序/自顶向下的归并排序（使用递归实现，时间复杂度是O(nlogn)，空间复杂度不为O(1))
     *  思路：归并排序使用分治思想，先将链表分成两半，分别进行排序，再将排好序的两个有序链表进行合并
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        // 递归终止的条件
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针法定位到链表的中间节点（如果链表节点数是偶数，返回第一个中间节点）
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 退出循环时，slow节点为中间节点
        // 用一个辅助节点来保存中间节点的下一个节点
        ListNode temp = slow.next;
        // 将链表从中间节点断开成两部分
        slow.next = null;
        // 递归对中间节点左右两部分链表继续进行拆分
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(temp);
        // 合并有序链表
        ListNode res = mergeTwoLists(l1, l2);
        return res;
    }

    /**
     * 方法三：归并排序/自底向上的归并排序（使用循环实现，时间复杂度是O(nlogn)，空间复杂度为O(1))
     *  思路：
     * @param head
     * @return
     */
    public static ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 计算链表的长度
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        // 创建一个虚拟头结点方便操作
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        // 第一次循环步长为1、第二次为2、第三次为4……直至步长大于等于链表长度退出循环
        for (int step = 1; step < len; step *= 2) {
            // 辅助节点cur用来遍历链表，辅助节点pre用来指向每次排好序的子链表
            // 每次循环开始，cur和pre都得回到链表头
            // 注意：这里cur必须是指向虚拟头结点的下一个节点，不能指向head，因为head指向的是初始链表的第一个节点
            //      排序之后链表的第一个节点可能发生改变了，也就是head不一定是再指向链表第一个节点了
            ListNode cur = newNode.next;
            ListNode pre = newNode;
            while (cur != null) {
                ListNode node1 = cur; // 第一部分头结点
                ListNode node2 = split(node1, step); // 第二部分头结点
                cur = split(node2, step); // 更新cur
                ListNode listNode = mergeTwoLists(node1, node2); // 对两部分有序链表进行合并，并返回头结点
                pre.next = listNode; // pre的指针域指向排好序的子链表
                // pre节点移动到排好序的子链表最后一个节点
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return newNode.next;
    }

    /**
     * 链表断链操作：并返回断链后第二部分链表头
     * @param head
     * @param step：步长（可以理解成断开的第一部分链表节点数）
     * @return
     */
    public static ListNode split(ListNode head,int step){
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        // 不要忘记步长大于链表节点数的情况
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode temp = cur.next;
        cur.next = null; // 切断连接
        return temp;
    }
    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = sortList3(node1);
        while (node != null) {
            System.out.print(node.val + "->");

            node = node.next;
        }
    }
}
