package topk;

import java.util.*;

/**
 * @Author Baker.chen
 * @create 2020/12/21 0:20
 *
 * 思路：先用HashMap统计每个单词的出现次数，再转换成top k问题
 */
public class 前K个高频单词 {
    public static List<String> topKFrequent(String[] words, int k) {
        // 统计每个单词出现的次数
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        // 将map集合转换成存放了所有键值对的set集合（Entry内部类）
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        // 要进行排序，需要将其转换成list
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        // 借助PriorityQueue，构建一个大小为k的小根堆
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                if (t1.getValue() != t2.getValue()) {
                    return t1.getValue() - t2.getValue();
                } else {
                    return t2.getKey().compareTo(t1.getKey());
                }
            }
        });
        // 往优先队列中存放前k个键值对
        for (int i = 0; i < k; i++) {
            queue.offer(list.get(i));
        }
        // 剩余的键值对顺序和堆顶元素进行比较
        for (int i = k; i < list.size(); i++) {
            // 如果键值对的value值比堆顶大，那么堆顶元素弹出，该元素入堆
            if (list.get(i).getValue() > queue.peek().getValue()) {
                // 替换堆顶元素
                queue.poll();
                queue.offer(list.get(i));
            } else if (list.get(i).getValue() == queue.peek().getValue() && list.get(i).getKey().compareTo(queue.peek().getKey()) < 0) {
                // 如果键值对的value值跟堆顶元素一样大，并且key值小于堆顶元素，那么堆顶元素弹出，该元素入堆
                // 替换堆顶元素
                queue.poll();
                queue.offer(list.get(i));
            }
        }
        // 比较完毕，堆中的k个键值对就是top k，顺序将键值对的key赋给集合即可
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(0, queue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 2));
    }
}
