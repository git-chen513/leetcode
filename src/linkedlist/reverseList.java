package linkedlist;

/**
 * @Author Baker.chen
 * @create 2020/8/9 15:06
 *
 * 反转链表：输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 *
 * 思路：定义一个节点cur用来遍历单链表，指向的是当前遍历的节点
 *      再创建一个新的单链表，将原来的链表一个个遍历之后以头插法的方式插入新链表
 *      最终再将原来的链表头节点指向新的链表即可
 *
 * 注意：要定义一个临时节点next来指向cur的下一个节点，否则的话当修改了cur节点的指针域，就会导致原来的链表断联，无法继续访问
 */
public class reverseList {

    /**
     * 方法一：双指针法，新建一个链表，遍历当前链表每个节点，使用头插法插入
     * 缺点：新开一个链表，占用额外的空间
     * @param head
     * @return
     */
    public static ListNode test1(ListNode head) {
        // 如果链表为空或者链表只有一个节点，那么就无需反转
        if (head.next ==null || head.next.next == null) {
            return head;
        }
        // 当前节点，用来遍历原来的链表
        ListNode cur = head.next;
        // 中间节点，表示当前节点的下一个节点，主要作用是为了防止当前节点修改了指针之后，链表断联
        ListNode next = null;
        // 表示新的链表头节点，新节点的插入以头插法的方式
        ListNode reverseHead = new ListNode();
        while (cur != null) {
            // 将当前节点的下一个节点赋给中间节点temp
            next = cur.next;
            // 头插法的方式插入新链表
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            // 遍历下一个节点
            cur = next;
        }
        // 将新链表赋给原来链表的头节点
        head.next = reverseHead.next;
        return head;
    }

    /**
     * 方法二：使用三指针，一个指向当前节点，一个指向当前节点前一个节点，一个指向当前节点的后一个节点
     * （之所以要有一个指针指向当前节点的后一个节点，是为了解决修改当前节点的指针域后链表断连的问题）
     * @param head
     * @return
     */
    public static ListNode test2(ListNode head) {
        // 如果链表为空或者链表只有一个节点，那么就无需反转
        if (head.next ==null || head.next.next == null) {
            return head;
        }
        // 当前节点的前一个节点，初始为null
        ListNode pre = null;
        // 当前节点，初始为链表的第一个节点
        ListNode cur = head.next;
        // 当前节点的后一个节点，初始为链表的第二个节点
        ListNode tail = head.next.next;
        while (tail != null) {
            cur.next = pre;
            pre = cur;
            cur = tail;
            tail = tail.next;
        }
        // 注意：退出循环时，原链表最后一个节点还没有执行指向前一个节点的操作
        cur.next = pre;
        // 将头节点指向原链表的最后一个节点
        head.next = cur;
        return head;
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

        handle.show();
        System.out.println();

        ListNode reverse = test2(handle.getHead());
        handle.setHead(reverse);
        handle.show();
    }
}
