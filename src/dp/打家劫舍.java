package dp;

public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 创建一个dp一维数组，dp[i]代表下标为[0,i]的子数组的最大和
        int[] dp = new int[nums.length];
        // dp数组初始化：如果数组只有一个元素，那么最大和为这个元素值，如果数组只有两个元素，那么最大和为这两个元素的最大值
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 从下标为2开始遍历
        for (int i = 2; i < nums.length; i++) {
            // 递推公式
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
