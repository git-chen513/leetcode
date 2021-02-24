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
                // 先根据value进行排序，如果value值相等，则根据key进行排序
                if (!t1.getValue().equals(t2.getValue())) {
                    return t1.getValue() - t2.getValue();
                } else {
                    return t1.getKey().compareTo(t2.getKey());
                }

            }
        });
        // 往优先队列中存放前k个键值对
        for (int i = 0; i < k; i++) {
            queue.offer(list.get(i));
        }
        // 剩余的键值对顺序和堆顶元素进行比较，如果键值对的value值比堆顶大，那么堆顶元素弹出，该元素入堆
        for (int i = k; i < list.size(); i++) {
            if (list.get(i).getValue() > queue.peek().getValue()) {
                // 替换堆顶元素
                queue.poll();
                queue.offer(list.get(i));
            }
        }
        // 比较完毕，堆中的k个键值对就是top k，由于是根据value值进行排序的小根堆，因此顺序输出此堆，得到的是一个根据value升序排序的序列
        // 将堆中的键值对存放到一个list集合中，再根据题意对这个list集合进行排序
        ArrayList<Map.Entry<String, Integer>> temp = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = queue.iterator();
        while (iterator.hasNext()) {
            temp.add(iterator.next());
        }
        // 对temp集合进行排序
        temp.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                // 先根据value进行降序排序，value相等的话再根据key进行升序排序
                if (t1.getValue().equals(t2.getValue())) {
                    return t1.getKey().compareTo(t2.getKey());
                } else {
                    return t2.getValue() - t1.getValue();
                }
            }
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            res.add(temp.get(i).getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words, 4));
    }
}
