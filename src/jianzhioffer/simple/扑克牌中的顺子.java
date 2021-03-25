package jianzhioffer.simple;

import java.util.Arrays;

/**
 * @Author Baker.chen
 * @create 2020/12/5 23:09
 */
public class 扑克牌中的顺子 {
    // 1. 除了大小之外，不能有对子出现，例如不能出现两个2
    // 2. 扑克牌中的最大值和最小值的差值需要小于5（大小王不参与判断最大值最小值）
    // 注：即使有大小王的存在，第二点的结论也是符合的
    public boolean isStraight(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历一遍数组，看看是否有重复的元素（遇到0则跳过）
        // 同时查找扑克牌的最小值（注意：最大值一定是排序之后的最后一个元素，但最小值不一定是数组的第一个元素，因为0不算入其中）
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                continue;
            }
            min = (min == 0 ? nums[i] : Math.min(min, nums[i]));
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        // 代码执行到这，说明扑克牌没有对子出现，再次判断最大值和最小值的差值是否小于5
        return nums[nums.length - 1] - min < 5;
    }
}
