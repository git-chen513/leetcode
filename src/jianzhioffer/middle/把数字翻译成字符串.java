package jianzhioffer.middle;

import java.util.Arrays;

public class 把数字翻译成字符串 {
    /**
     * 动态规划
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        if (num < 26) {
            return 2;
        }
        // 将整数num先转换成字符串，方便处理
        String s = String.valueOf(num);
        // 创建一个dp一维数组，dp[i]代表以下标i结尾的子整数有多少种转换方式
        int[] dp = new int[s.length()];
        // dp数组初始化
        dp[0] = 1;
        dp[1] = Integer.valueOf(s.substring(0, 2)) < 26 ? 2 : 1;
        for (int i = 2; i < s.length(); i++) {
            if (Integer.valueOf(s.substring(i - 1, i + 1)) >= 10 && Integer.valueOf(s.substring(i - 1, i + 1)) < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length() - 1];
    }
}
