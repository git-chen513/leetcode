package dp;

/**
 * 动态规划的套路：
 *  1. 确定dp数组以及下标的含义，例如要明确 dp[i]指的是什么
 *  2. 确定递推公式，动态规划每一阶段的值都是由上一状态推导出来的
 *  3. dp数组如何初始化，例如要给dp[0]、dp[1]赋初始值
 *  4. 确定遍历顺序，从前往后遍历还是从后往前遍历
 *  5. 举例推导dp数组
 */
public class 斐波那契数 {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        // 1. 创建一个dp数组，dp[i]指的是第i个数的斐波那契数值
        int[] dp = new int[n + 1];
        // 3. dp数组初始化
        dp[0] = 0;
        dp[1] = 1;
        // 4. 遍历顺序：从前往后
        for (int i = 2; i < n + 1; i++) {
            // 2. 递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int fib1(int n) {
        // 递归终止的条件
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
}
