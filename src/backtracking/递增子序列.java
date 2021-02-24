package backtracking;

import java.util.*;

public class 递增子序列 {
    /**
     * 本题求递增子序列，是不能对原数组进行排序的，因为排完序的数组都是自增子序列了。
     * 所以就不能用排序的方法来进行去重，这里我们借助set集合去重
     *
     * 改进：使用set集合效率会比较低，数组，set，map都可以做哈希表，而且数组干的活，map和set都能干，但如果数值范围小的话能用数组尽量用数组。
     * 题目中说了，数值范围[-100,100]，所以完全可以用数组来做哈希
     * 因此，我们可以将原先每一层定义的一个set集合替换成定义一个长度为201的数组，int[] arr = new int[201];每个元素默认值为0
     * 在本层访问过，则修改值为1即可
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, list, res);
        return res;
    }
    public void backtracking(int[] nums, int startIndex, List<Integer> list, List<List<Integer>> res) {
        // 子序列问题也类似于子集问题，需要收集整颗树的所有节点，并不仅仅是叶子节点
        // 由于题目要求递增子序列的长度至少是2，因此只有当list集合的长度大于等于2才可以加入到结果集合中
        if (list.size() >= 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
        }
        // 递归终止的条件：当startIndex大于等于数组长度时（可加可不加，因为startIndex >= nums.length时，for循环也不会执行）
        if (startIndex >= nums.length) {
            return;
        }
        // 使用set集合去重：如果某个元素已经在本层出现过了，直接跳过
        // 注意：这里定义的set集合只负责本层，记录本层元素是否重复使用
        // 由于递归调用，每次调用都会在虚拟栈中开辟一块独立的空间来存放本地调用的一些数据信息；因此每层声明的set集合都是独立的，互不影响
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            // 如果当前元素小于list集合的最后一个元素，不满足递增，那么也直接跳过
            if (list.size() != 0 && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            list.add(nums[i]);
            backtracking(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
