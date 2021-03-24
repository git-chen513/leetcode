package jianzhioffer.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    /**
     * 哈希表法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > (len / 2)) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 排序法：排完序之后数组的中间元素一定是所求的元素
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length];
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        // 假设当前众数
        int x = 0;
        // 票数
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                // 当前总票数为0，重新指定一个众数
                x = nums[i];
            }
            sum += (nums[i] == x ? 1 : -1);
        }
        return x;
    }
}
