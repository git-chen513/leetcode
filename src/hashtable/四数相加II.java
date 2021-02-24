package hashtable;

import java.util.HashMap;
import java.util.Map;

public class 四数相加II {
    /**
     * 哈希法
     * 思路：将两个数组看成一组进行处理，首先创建一个Map集合，key存放AB数组中各元素的和，value存放相同和的个数
     *      然后分别遍历CD数组，并查看Map集合中是否存在值等于 0-(C+D) 的key，存在则结果值加上对应的value
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        // 先分别遍历AB数组，填充map集合
        for (int a : A) {
            for (int b : B) {
                if (map.containsKey(a + b)) {
                    map.put(a + b, map.get(a + b) + 1);
                } else {
                    map.put(a + b, 1);
                }
            }
        }
        int sum = 0;
        // 分别遍历CD数组
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(0 - c - d)) {
                    sum += map.get(0 - c - d);
                }
            }
        }
        return sum;
    }
}
