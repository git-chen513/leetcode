package dp;

import java.util.Arrays;

public class 打家劫舍II {
    /**
     * 打家劫舍II和之前的打家劫舍是类似的，区别在于打家劫舍II规定第一个房屋和最后一个房屋是紧挨着的
     * 也就是第一个房屋和最后一个房屋不能一起选，那么我们可以把这道题分成两种情况：
     *      一、不考虑最后一个房屋，计算除了最后一个房屋的最大值
     *      二、不考虑第一个房屋，计算除了第一个房屋的最大值
     *      然后选出这两种情况计算出来的最大值
     * @param nums
     * @return
     */
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
        // 不考虑第一个房屋
        int res1 = robs(Arrays.copyOfRange(nums, 1, nums.length));
        // 不考虑最后一个房屋
        int res2 = robs(Arrays.copyOfRange(nums, 0, nums.length - 1));
        return Math.max(res1, res2);
    }

    /**
     * 指定nums数组范围的打家劫舍
     * @return
     */
    public int robs(int[] nums) {
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
