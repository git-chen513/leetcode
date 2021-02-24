package hashtable;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    /**
     * 哈希法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // Map的key存放的是数组元素值，value存放的是对应的下标
        // 注意：相同的key会被覆盖，但是这种解法即使后面的元素覆盖了前面的，也不会影响结果
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 重新遍历一遍数组，判断Map中是否存在 target - nums[i] 的值，由于数组中同一个元素不能使用两遍，因此这个值对应的数组下标不能跟i相等
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[2];
    }
}
