package dp;

public class 背包问题 {
    public static void main(String[] args) {
        // weight数组代表物品的重量，value数组代表物品的价值，下标一一对应
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        // 背包总重量
        int w = 4;
        // 创建一个dp二维数组，二维数组的行对应物品，二维数组的列对应背包的容量（dp[i][j]代表加入物品i，背包容量为j的最大价值）
        // 这里多创建一行一列，可以避免考虑数据越界的问题
        int[][] dp = new int[weight.length + 1][w + 1];
        // dp数组初始化，第一行和第一列都默认为0，无需显示初始化
        // 遍历顺序，从前往后遍历，并且从第二行和第二列开始遍历，也就是下标为1开始
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (weight[i - 1] > j) {
                    // 如果当前加入商品i的价值大于j，那么dp[i][j]的值就等于不加入商品i之前，容量为j的最大价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果当前加入商品i的价值小于j，那么dp[i][j]的值就等于 dp[i - 1][j] 和 value[i - 1] + dp[i - 1][j - weight[i - 1]] 二者的最大值
                    //value[i-1]表示当前商品的价值，注意下标要减一
                    //j - weight[i - 1]表示当前容量减去当前物品的容量后剩余容量
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        // 输出最大价值
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
