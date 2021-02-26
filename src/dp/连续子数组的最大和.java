package dp;

/**
 * @Author Baker.chen
 * @create 2020/8/20 9:31
 *
 * 连续子数组的最大和：
 *  输入一个整型数组，数组中有正数也有负数
 *  数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值
 *  要求时间复杂度为O(n)
 *
 *  示例：
 *      输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *      输出: 6
 *      解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class 连续子数组的最大和 {

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int test(int[] nums) {
        // 创建一个dp一维数组，dp[i]表示以元素nums[i]为结尾的连续子数组的最大和
        // 之所以必须包含元素nums[i]，是因为题目要求是“连续子数组”，这样才能保证dp[i]递推到dp[i+1]的正确性
        int[] dp = new int[nums.length];
        // dp数组初始化
        dp[0] = nums[0];
        // max用来记录最大值，不断更新
        int max = dp[0];
        for (int i = 1; i < nums.length; i++){
            // 如果dp[i-1]<0，那么不管nums[i]大于0还是小于0，dp[i]都等于num[i]
            // 如果dp[i-1]>0，并且由于dp[i]必须包含nums[i]，所以dp[i]等于dp[i-1]+nums[i]
            dp[i] += Math.max(dp[i-1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
