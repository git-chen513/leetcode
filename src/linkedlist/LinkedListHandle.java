package linkedlist;

/**
 * @Author Baker.chen
 * @create 2020/8/7 11:48
 *
 * 链表的处理类，包括链表添加节点，删除节点等
 */
public class LinkedListHandle {
    /**
     * 创建一个头节点，不存放任何具体数值，用于指向第一个节点
     */
    public ListNode head = new ListNode();

    /**
     * 在链表尾部添加新节点
     * @param node
     */
    public void add(ListNode node) {
        if (head.next == null) {
            head.next = node;
            return;
        }
        //找到链表的最后一个节点
        ListNode temp = head.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        //退出循环的时候,temp节点已经指向了链表的最后一个节点
        temp.next = node;
    }

    /**
     * 删除指定节点
     * @param val
     */
    public void del(int val) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
        }
        ListNode temp = head;
        // 用于标识链表中是否能找到指定值
        boolean flag = false;
        // 由于单链表的特性，这里我们应该找到待删除节点的前一个节点
        while (temp.next != null) {
            if (temp.next.val == val){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == false) {
            System.out.println("链表中找不到待删除的值i~");
        } else {
            temp.next = temp.next.next;
        }
    }

    /**
     * 遍历链表
     */
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空~");
            System.out.println();
        }
        ListNode node = head.next;
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.val + "->");
            } else {
                System.out.print(node.val);
            }
            node = node.next;
        }
    }

    /**
     * 设置链表的头节点
     * @param head
     */
    public void setHead(ListNode head) {
        this.head = head;
    }

    /**
     * 返回头节点
     */
    public ListNode getHead(){
        return head;
    }
}
