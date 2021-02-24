package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Baker.chen
 * @create 2021/1/28 23:46
 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 对数组进行排序，方便去重
        Arrays.sort(nums);
        backtracking(nums, used, list, res);
        return res;
    }
    public void backtracking(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        // 递归终止的条件：list集合的长度等于nums数组的长度
        if (list.size() == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 注意：这里跳过此次循环的条件还需要加上used[i - 1] == false，因为如果used[i - 1] == true是不可以跳过的
            // 这个需要自己在纸上画出一颗树形结构来方便理解，并且这里要和组合问题中的组合总和II区分开
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtracking(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
