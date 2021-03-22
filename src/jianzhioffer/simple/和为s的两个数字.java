package jianzhioffer.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 和为s的两个数字 {
    /**
     * 哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // map存放每个数及其对应的下标（相同的key，后面的元素会覆盖前面的）
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && (map.get(target - nums[i]) != i)) {
                return new int[]{nums[i], target - nums[i]};
            }
        }
        return new int[0];
    }

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[i] + nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[i] + nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return new int[]{nums[i], nums[mid]};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] res = twoSum2(arr, 18);
        System.out.println(Arrays.toString(res));
    }
}
