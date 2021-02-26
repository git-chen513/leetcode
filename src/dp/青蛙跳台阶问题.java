package dp;

public class 青蛙跳台阶问题 {
    /**
     * 动态规划解法一
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        // 创建一个dp二维数组，dp[i]指的是青蛙跳上i级台阶有多少种跳法
        int[]dp = new int[n + 1];
        // dp数组初始化
        dp[1] = 1;
        dp[2] = 2;
        // 从前往后遍历，填充dp数组
        for (int i = 3; i < n + 1; i++) {
            // 递推公式（答案需要取模 1e9+7（1000000007））
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 动态规划解法二：用两个变量来存放中间值即可，无需用数组保存，节省空间
     * @param n
     * @return
     */
    public int numWays1(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i < n + 1; i++) {
            // 递推公式（答案需要取模 1e9+7（1000000007））
            int sum  = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
