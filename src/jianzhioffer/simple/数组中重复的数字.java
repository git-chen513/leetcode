package jianzhioffer.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author Baker.chen
 * @create 2020/11/29 17:56
 */
public class 数组中重复的数字 {
    /**
     * 方法一：使用哈希表统计元素出现的次数
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            if (map.get(temp) > 1) {
                return temp;
            }
        }
        return -1;
    }

    /**
     * 方法二：使用set集合
     * 思路：利用set集合的不可重复性，遍历原数组，将元素添加到set集合中，如果添加失败，即为重复
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int temp : nums) {
            if (!set.add(temp)) {
                return temp;
            }
        }
        return -1;
    }

    /**
     * 方法三：原地置换（一个萝卜一个坑）
     * 思路：由于题干提及“在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内”
     *      所以，如果没有出现重复元素的话，那么数字i应该就位于下标为i的位置
     *      遍历数组，如果下标为i的元素值不为i，那么进行交换，交换到它应该在的位置
     *      如果要交换的位置的值已经是正确存在的，即出现了重复元素
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums) {
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,3,5,6,4};
        System.out.println(findRepeatNumber3(arr));
    }
}
