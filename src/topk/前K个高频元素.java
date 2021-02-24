package topk;

import java.util.*;

/**
 * @Author Baker.chen
 * @create 2020/12/21 0:20
 *
 * 思路：先用HashMap统计每个元素的出现次数，再转换成top k问题
 */
public class 前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 将map集合转换成存放了所有键值对的set集合（Entry内部类）
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        // 要进行排序，需要将其转换成list
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
        // 借助PriorityQueue，构建一个大小为k的小根堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> t1, Map.Entry<Integer, Integer> t2) {
                return t1.getValue() - t2.getValue();
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
        // 比较完毕，堆中的k个键值对就是top k，顺序将键值对的key赋给数组即可
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(num, 2)));
    }
}
