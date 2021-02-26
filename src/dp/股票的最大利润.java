package dp;

public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 创建一个dp一维数组，dp[i]指的是以prices[i]结尾的子数组的最大利润，也就是前i日的最大利润
        int dp[] = new int[prices.length];
        // dp数组初始化，第一天买入不卖出，利润为0
        dp[0] = 0;
        // 辅助变量min用来记录数组的最小值，不断更新
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            // 递推公式
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}
