package dp;

/**
 * 最长公共子串与最长公共序列是易混的概念，公共子串和公共子序列不同，公共子序列不要求连续，但是公共子串必须是连续的。
 * 例如：String s1=“helloworld”；String s2=“loop”；则s1和s2的最长公共子序列是“loo"，但是最长公共子串是"lo"
 *
 * 最长公共子串问题也是动态规划算法的经典例题，解题思路和最长公共子序列类似，
 * 和LCS问题唯一不同的地方在于当c1[i] != c2[j]时，p[i] [j]就直接等于0了，
 * 因为子串必须连续，且p[i] [j]表示的是以c1[i]，c2[j]截尾的公共子串的长度。
 * 这个和LCS问题还有一点不同的就是，需要设置一个max，每一步都更新得到最长公共子串的长度。
 */
public class 最长公共子串 {
    public int f(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp= new int[c1.length + 1][c2.length + 1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (c1[i - 1] == c2[j -1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max)
                        max = dp[i][j];
                }
            }
        }
        return max;
    }
}
