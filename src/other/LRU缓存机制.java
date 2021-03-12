package other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用LinkedHashMap实现LRU算法
 * 关于LinkedHashMap：
 *      LinkedHashMap继承于HashMap并实现了Map接口，HashMap底层存放元素基于数组实现，LinkedHashMap底层是基于双链表和哈希表实现
 *      HashMap是无序的，LinkedHashMap是有序的，支持插入排序和访问排序
 *      默认是支持插入排序，所谓插入排序，即当迭代访问LinkedHashMap时，会按照我们put元素的顺序输出
 *      而访问排序指的是，当我们put一个元素时，是插入到双链表的尾部，当get访问一个元素时，如果该元素存在，会将该元素移动到链表尾部（其实是先删除再插入）
 *      而当我们迭代访问LinkedHashMap时，会按照从双链表的头部开始输出元素，即刚刚访问的元素会最后输出
 */
public class LRU缓存机制 {
    LinkedHashMap<Integer, Integer> map;
    private int capacity;
    public LRU缓存机制(int capacity) {
        // 要开启访问排序，需要使用携带三个参数的构造方法，并且最后一个参数为true代表开启访问排序
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            // 重写removeEldestEntry方法，当方法内返回true时，会移除最近最久未使用的元素
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // 不管map是否已经存在这个key，执行了put操作之后都会将对应的键值对插入双链表尾部
        map.put(key, value);
        // 这里也可以不重写removeEldestEntry方法，put一个元素之后，直接手动判断集合的大小是否已经超过最大容量
        // 超过则迭代遍历集合的第一个元素删除即可，如 map.remove(map.keySet().iterator().next());
    }
}