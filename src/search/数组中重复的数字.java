package search;

import java.util.HashMap;
import java.util.HashSet;

public class 数组中重复的数字 {
    /**
     * 借助Map进行统计
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }

    /**
     * 从概念出发：下标为i对应存放的值就为i，如果不是，那么应该进行交换，当要交换的位置已经存在一个正确的值了，说明出现重复
     */
    public static int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp != i) {
                if (nums[temp] == temp) {
                    return temp;
                }
                int a = nums[temp];
                nums[temp] = nums[i];
                nums[i] = a;
            }
        }
        return -1;
    }

    /**
     * 使用set集合的特性：遇到重复元素时添加失败
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2};
        System.out.println(findRepeatNumber2(nums));
    }
}
