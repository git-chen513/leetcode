package backtracking;

import java.util.Arrays;

public class 组合总和IV {
    int result = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        backtracking(nums, target, 0);
        return result;
    }
    public void backtracking(int[] nums, int target, int sum) {
        if (sum == target) {
            result++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                break;
            }
            backtracking(nums, target, sum);
            sum -= nums[i];
        }
    }
}
