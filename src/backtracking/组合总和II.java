package backtracking;

import java.util.*;

public class 组合总和II {
    /**
     * 不要遗漏了数组中可能出现重复元素的情况，会导致结果出现重复
     * 可以通过一个set集合进行去重，因为list1=[1,2,3],list2=[1,2,3]，添加到set集合中，会去除掉一个重复的list
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        // 对数组进行排序，可以剪枝减少回溯次数
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0, list, res);
        List<List<Integer>> result = new ArrayList<>();
        Iterator<List<Integer>> iterator = res.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
    public void combinationSum2(int[] candidates, int target, int sum, int startIndex, List<Integer> list, Set<List<Integer>> res) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
        }
        for (int j = startIndex; j < candidates.length; j++) {
            sum += candidates[j];
            // 剪枝
            if (sum > target) {
                break;
            }
            list.add(candidates[j]);
            // 因为candidates 中的每个数字在每个组合中只能使用一次，因此这里j要加一（要和组合总和这道题目区分开）
            combinationSum2(candidates, target, sum, j + 1, list, res);
            sum -= candidates[j];
            list.remove(list.size() - 1);
        }
    }

    /**
     * 改进：不需要使用set集合对结果列表进行去重，直接在遍历的过程中去重
     * 使用set集合去重效率太低了，因为是在求得结果列表之后再进行一遍去重，而我们完全可以在遍历的过程中就去重
     * 因为已经对数组进行排序了，所以如果当前元素值等于上一个元素值就可以直接跳过处理，避免重复
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2II(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 对数组进行排序，可以剪枝减少回溯次数
        Arrays.sort(candidates);
        backtrackingII(candidates, target, 0, 0, list, res);
        return res;
    }
    public void backtrackingII(int[] candidates, int target, int sum, int startIndex, List<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
        }
        for (int j = startIndex; j < candidates.length; j++) {
            if (j > startIndex && candidates[j] == candidates [j - 1]) {
                continue;
            }
            sum += candidates[j];
            // 剪枝
            if (sum > target) {
                break;
            }
            list.add(candidates[j]);
            backtrackingII(candidates, target, sum, j + 1, list, res);
            sum -= candidates[j];
            list.remove(list.size() - 1);
        }
    }
}
