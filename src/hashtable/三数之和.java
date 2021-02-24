package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    /**
     * 双指针解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历一遍数组，初始时：左指针left指向当前遍历到的元素的下一位，右指针right指向数组的最后一位，三数之和即为nums[i]+nums[left]+nums[right]
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前遍历到的元素值大于0，直接结束循环
            if (nums[i] > 0) {
                return res;
            }
            // 第一次去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    // 左指针收缩，让整体值变大
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    // 右指针收缩，让整体值变小
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 左右指针同时收缩
                    left++;
                    right--;
                    // 第二次去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
