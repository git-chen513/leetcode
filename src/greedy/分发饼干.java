package greedy;

import java.util.Arrays;

public class 分发饼干 {
    /**
     * 贪心算法：如果能通过局部最优推出整体最优，就可以使用贪心算法
     * 分发饼干如果每次都将大饼干分给胃口值大的小孩，最终就可以满足更多数量的小孩
     * 因此我们对小孩胃口值数组以及饼干数组进行排序，然后从后往前遍历数组
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) {
            return 0;
        }
        // 对数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 统计满足小孩的数量
        int sum = 0;
        // 遍历饼干数组的下标
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                sum++;
                index--;
            }
        }
        return sum;
    }
}
