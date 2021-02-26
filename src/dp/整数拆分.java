package dp;

public class 整数拆分 {
    /**
     * 当 i≥2 时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
     *  将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j×(i−j)
     *  将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // 1. 定义dp数组，dp[i]表示数字i拆分之后的最大乘积
        int[]dp = new int[n + 1];
        // 2. dp数组初始化（因为至少拆分成两个正整数，所以数字0和数字1无法满足拆分条件，最大乘积为0）
        dp[2] = 1; // 2 = 1 + 1; 1 * 1 = 1
        // 3. 从前往后遍历
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 4. 递推公式
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
