package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    /**
     * 双指针法
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 双重循环遍历一遍数组，初始时：左指针left指向第二层循环当前遍历到的元素的下一位，右指针right指向数组的最后一位，四数之和即为nums[i]+nums[j]+nums[left]+nums[right]
        for (int i = 0; i < nums.length - 3; i++) {
            // 第一次去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 第二次去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        // 左指针收缩，让整体值变大
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        // 右指针收缩，让整体值变小
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        // 左右指针同时收缩
                        left++;
                        right--;
                        // 第三次去重
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
