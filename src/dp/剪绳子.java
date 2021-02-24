package dp;

public class 剪绳子 {
    public int cuttingRope(int n) {
        // 1. 定义dp数组，dp[i]表示数字i拆分之后的最大乘积
        int[]dp = new int[n + 1];
        // 2. dp数组初始化（因为至少拆分成两个正整数，所以数字0和数字1无法满足拆分条件，最大乘积为0）
        dp[2] = 1; // 2 = 1 + 1; 1 * 1 = 1
        // 3. 从前往后遍历
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                // 4. 递推公式
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
