package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, 0, 0, list, res);
        return res;
    }
    public void backtracking(int[] candidates, int target, int sum, int startIndex, List<Integer> list, List<List<Integer>> res) {
        // 递归终止的条件：当sum大于等于target的时候递归终止（由于candidates 中的数字可以无限制重复被选取，因此最终sum是不会小于target的）
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
            return;
        }
        // 遇到这一类相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索。具体的做法是：每一次搜索的时候设置 下一轮搜索的起点 startIndex
        for (int j = startIndex; j < candidates.length; j++) {
            sum += candidates[j];
            list.add(candidates[j]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是j（往常的写法是j+1，这里要特别注意）
            backtracking(candidates, target, sum, j, list, res);
            sum -= candidates[j];
            list.remove(list.size() - 1);
        }
    }

    /**
     * 改进：对candidates数组进行排序，可减少回溯的次数（对组合求和通常都是先对数组进行排序，方便剪枝）
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking1(candidates, target, 0, 0, list, res);
        return res;
    }
    public void backtracking1(int[] candidates, int target, int sum, int startIndex, List<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
            return;
        }
        for (int j = startIndex; j < candidates.length; j++) {
            sum += candidates[j];
            // 剪枝：由于数组是从小到大排好序的，因此如果sum加上前面的元素值已经超过了target，那么可以直接退出本层for循环了
            if (sum > target) {
                break;
            }
            list.add(candidates[j]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是j（往常的写法是j+1，这里要特别注意）
            backtracking1(candidates, target, sum, j, list, res);
            sum -= candidates[j];
            list.remove(list.size() - 1);
        }
    }

    /**
     * 方法二：每选一个数，target就减去对应的值，例如要在[1,3,5,7]中找到和为4的集合，那么选了1之后，下一层就要在[1,3,5,7]中找到和为3的集合
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking2(candidates, target, 0, list, res);
        return res;
    }
    public void backtracking2(int[] candidates, int target, int startIndex, List<Integer> list, List<List<Integer>> res) {
        // 递归终止的条件：当target小于0，直接退出；当target等于0，添加到结果列表中
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
            return;
        }
        // 遇到这一类相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索。具体的做法是：每一次搜索的时候设置 下一轮搜索的起点 begin
        for (int j = startIndex; j < candidates.length; j++) {
            list.add(candidates[j]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是j（往常的写法是j+1，这里要特别注意）
            backtracking2(candidates, target - candidates[j], j, list, res);
            list.remove(list.size() - 1);
        }
    }
}
