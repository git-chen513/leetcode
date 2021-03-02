package dp;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 创建一个dp二维数组，dp[i][j]指的是以i结尾的text1子字符串和以j结尾的text2子字符串的最长公共子序列
        // dp数组多创建一行一列，可以避免考虑第一行以及第一列的特殊情况
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // dp数组无需显示初始化
        // 从下标为1开始遍历
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 递推公式
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 递推公式
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
