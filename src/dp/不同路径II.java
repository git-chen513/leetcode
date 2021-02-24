package dp;

public class 不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        // 行数
        int m = obstacleGrid.length;
        // 列数
        int n = obstacleGrid[0].length;
        // 1. 创建一个dp二维数组：dp[i][j]代表从左上角下标[0][0]到下标[i][j]的总路径数
        int[][]dp = new int[m][n];
        // 2. dp数组初始化（i==0 一整行和 j==0 一整列的值在遇到障碍物之前都为1，之后都为0）
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 3. 遍历直接从第二行和第二列开始遍历，如果遇到障碍物，则dp[i][j]=0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
