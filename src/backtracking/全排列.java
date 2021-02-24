package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Baker.chen
 * @create 2021/1/28 23:35
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        // 排列问题一般都要设置一个used数组，来判断数组中的元素是否已经被访问过
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
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
