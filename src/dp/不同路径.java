package dp;

public class 不同路径 {
    /**
     * 动态规划解法一
     *  通俗易懂，但for循环需要嵌套多层判断，代码冗余，效率低
     * @param m：行数
     * @param n：列数
     * @return
     */
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // 1. 创建一个dp二维数组：dp[i][j]代表从左上角下标[0][0]到下标[i][j]的总路径数
        int[][]dp = new int[m][n];
        // 2. dp数组初始化
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // 已经初始化的直接跳过，不需要再次赋值
                    continue;
                } else if (i == 0) {
                    // 因为i==0时，i-1会越界
                    dp[i][j] = dp[i][j - 1] + 0;
                } else if (j == 0) {
                    // 因为j==0时，j-1会越界
                    dp[i][j] = dp[i - 1][j] + 0;
                } else {
                    // 正常递推公式
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划解法二
     *  合理对dp数组进行初始化，不存在数组越界的情况，每一次遍历无需进行判断，效率更高
     * @param m：行数
     * @param n：列数
     * @return
     */
    public int uniquePaths2(int m, int n) {
        // 1. 创建一个dp二维数组：dp[i][j]代表从左上角下标[0][0]到下标[i][j]的总路径数
        int[][]dp = new int[m][n];
        // 2. dp数组初始化（i==0 一整行和 j==0 一整列的值应该都为1，所以直接初始化即可）
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 3. 遍历直接从第二行和第二列开始遍历，也不存在特殊情况导致数组越界的情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 4. 递推公式
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划解法三
     *  给数组多增加一行一列，可以不用考虑数组越界的情况
     * @param m：行数
     * @param n：列数
     * @return
     */
    public int uniquePaths3(int m, int n) {
        // 1. 创建一个dp二维数组：dp[i][j]代表从左上角下标[0][0]到下标[i - 1][j - 1]的总路径数
        int[][]dp = new int[m + 1][n + 1];
        // 2. dp数组初始化（dp数组第一行和第一列不需要初始化，默认都为0）
        dp[1][1] = 1;
        // 3. 遍历直接从dp数组第二行和第二列开始遍历
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    // 已经初始化的直接跳过，不需要再次赋值
                    continue;
                }
                // 4. 递推公式
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
