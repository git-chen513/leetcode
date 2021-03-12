package other;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：双链表+哈希表
 *
 * 根据题目的要求，LRU指的是最近最久未使用算法，即以时间作为判断，并不是以使用的频次作为判断
 * 如果某个键值对刚刚执行了get方法或者put方法，说明它是刚刚使用的键值对，是活跃的
 * 可以这样设计，把最近常使用的放在左边，把最近没使用的放在右边
 * 当put添加一个元素之后，判断内存是否满了，如果内存满了，则移除最右边的元素
 * 当get获取一个元素时，如果不存在该键值对，返回-1，如果存在，则获取该值，并且要将该键值对移动到最左边
 *
 * 由于涉及到元素的插入和删除，并且希望时间复杂度是O(1)，那么我们应该选用链表这种数据结构，因为数组的插入删除需要涉及到元素的移动
 * 如果是单链表，当删除一个节点需要找到它的上一个节点，不方便操作，因此我们选择双链表
 *
 * 当put插入一个新节点之后，如果内存满了，则移除链表的第一个节点
 * 当get一个元素时，如果不存在，返回-1，如果存在，则将该节点移动到链表最后一个节点（可以先删除该节点，再将该节点重新插入链表的最后一个节点）
 *
 * 为了便于双向链表的头部删除和尾部插入，我们一般给双向链表定义一个虚拟头节点和虚拟尾节点
 * 虚拟头节点指的是假设是链表的第一个节点，实则是指向链表第一个有效节点
 * 虚拟尾节点指的是假设是链表的最后一个节点，实则是指向链表的最后一个有效节点
 */
public class LRU缓存 {
    private Integer capacity; // 最大容量
    private ListNode head; // 虚拟头节点
    private ListNode tail; // 虚拟尾节点
    private Map<Integer, ListNode> map; // 哈希表，value存放的是链表节点
    public LRU缓存(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        map = new HashMap<>();
        // 初始化链表
        head.next = tail;
        tail.pre = head;
    }
    /**
     * 通过哈希表判断key是否存在，不存在返回-1，存在则返回该key对应的节点的value值
     * 并将这个节点移动到双向链表的尾部
     * @param key
     * @return
     */
    public int get(int key) {
        // 不存在这个key
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        // 将这个节点移动到双向链表的尾部：先删除该节点，再在尾部插入该节点（这样才能保证时间复杂度为O(1)，因为链表的插入删除都是O(1)复杂度）
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 尾部插入该节点
        moveToTail(node);
        return node.value;
    }
    public void put(int key, int value) {
        // 直接调用这边的get方法，如果key已存在，它会在get内部被移动到尾部，不用再移动一遍,直接修改值即可
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        // 若不存在，new一个出来,如果超出容量，把头去掉
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);
        // 判断哈希表的键值对数量是否超过最大容量
        if (map.size() > capacity) {
            // 哈希表也需要移除该键值对
            map.remove(head.next.key);
            // 内存满，移除链表第一个节点
            head.next = head.next.next;
            head.next.pre = head;
        }
    }
    /**
     * 链表尾部插入新节点：插入到虚拟尾节点的前面
     * @param node
     */
    private void moveToTail(ListNode node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}
// 定义一个双链表节点类
// 使用双链表的好处就是删除节点时可以直接在当前节点处删除，无需通过上一个节点来删除
class ListNode {
    int key;
    int value;
    ListNode pre;
    ListNode next;
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
