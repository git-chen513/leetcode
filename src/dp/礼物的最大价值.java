package dp;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        // 创建一个dp二维数组，dp[i][j]指的是从数组左上角移动到下标为[i][j]所得到的最大价值
        // dp数组多创建一行一列，可以避免考虑第一行和第一列数组越界异常
        int dp[][] = new int[grid.length + 1][grid[0].length + 1];
        // dp数组初始化，第一行和第一列默认为0
        // 从第二行和第二列开始遍历
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 递推公式
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }

    /**
     * 改进：直接将grid数组作为dp数组，不需要重新创建dp数组，空间复杂度降为O(1)
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
