package linkedlist;

public class 设计链表 {
    // 定义一个链表节点内部类
    class ListNode {
        int val;
        ListNode next;
    }
    // 定义一个虚拟头结点
    ListNode head;
    public 设计链表() {
        head = new ListNode();
    }

    public int get(int index) {
        if (head == null || head.next == null) {
            return -1;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null && count <= index) {
            cur = cur.next;
            count++;
        }
        if (cur != null) {
            return cur.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode();
        node.val = val;
        if (head.next == null) {
            head.next = node;
            return;
        }
        // 定义到链表的最后一个结点
        ListNode cur = head.next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void addAtIndex(int index, int val) {
        // 计算链表的长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if (index == len) {
            // 该节点将附加到链表的末尾
            addAtTail(val);
        } else if (index < 0) {
            // 在头部插入节点
            addAtHead(val);
        } else if (index > len) {
            return;
        } else {
            // 定位到位置为index-1的节点
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode node = new ListNode();
            node.val = val;
            node.next = cur.next;
            cur.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        // 定位到位置为index-1的节点
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < index) {
            cur = cur.next;
            count++;
        }
        if (cur == null || cur.next == null) {
            return;
        } else {
            cur.next = cur.next.next;
        }
    }

    public static void main(String[] args) {
        设计链表 linkedList = new 设计链表();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));
    }
}

