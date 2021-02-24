package linkedlist;

/**
 * @Author Baker.chen
 * @create 2021/1/9 16:03
 *
 * 思路：这道题看得懂题意的人会说他出的非常巧妙，可以让我们深刻的理解链表关于删除节点的操作
 *      看不懂题意的人会觉得这是在玩文字游戏，是一道脑筋急转弯
 *      一般来说，我们要删除一个节点需要先得到该节点的前一个节点才可以执行删除操作
 *      这道题目给出的参数是待删除节点本身，也没有给出链表的头结点，所以按照传统的思路我们无法删除该节点
 *      这时候我们可以取巧，也就是将待删除节点的后一个节点的值赋给待删除节点，然后删除待删除节点的后一个节点
 *      （相当于替换了后一个节点）
 */
public class 删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
