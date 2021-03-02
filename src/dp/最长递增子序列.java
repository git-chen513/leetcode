package dp;

import java.util.Arrays;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // 创建一个dp一维数组，dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度。
        // 即：在 [0, ..., i] 的范围内，选择以数字 nums[i] 结尾可以获得的最长上升子序列的长度。
        // 说明：以 nums[i] 结尾，是子序列动态规划问题的经典设计状态思路，思想是动态规划的无后效性（定义得越具体，状态转移方程越好推导）。
        int[] dp = new int[nums.length];
        // dp数组初始化：dp[i]所有元素初始值置为1，因为每个元素都至少可以单独成为子序列
        Arrays.fill(dp, 1);
        // 存储最大值，不断更新
        int res = dp[0];
        // 从下标为1开始往后遍历
        for (int i = 1; i < nums.length; i++) {
            // 遍历区间[0,i-1]
            //当nums[i] > nums[j]时：nums[i]可以接在nums[j]之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1
            //当nums[i] <= nums[j]时：nums[i]无法接在nums[j]之后，此情况上升子序列不成立，跳过。
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
