package backtracking;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(k, n, 1, list, res);
        return res;
    }
    public void backtracking(int k, int n, int startIndex, List<Integer> list, List<List<Integer>> res) {
        // 递归终止的条件：list集合中的元素个数等于k时终止，并判断此时list集合中的元素之和是否等于n，是则添加到res集合中
        if (list.size() == k) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
                temp.add(list.get(i));
            }
            if (sum == n) {
                res.add(temp);
            }
            return;
        }
        for (int j = startIndex; j <= 9; j++) {
            list.add(j);
            backtracking(k, n, j + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 改进：把sum提取出来，方便剪枝
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3II(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrackingII(k, n, 1,0, list, res);
        return res;
    }
    public void backtrackingII(int k, int n, int startIndex, int sum, List<Integer> list, List<List<Integer>> res) {
        // 递归终止的条件：list集合中的元素个数等于k时终止，并判断此时list集合中的元素之和是否等于n，是则添加到res集合中
        if (list.size() == k) {
            if (sum == n) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    temp.add(list.get(i));
                }
                res.add(temp);
            }
        }
        for (int j = startIndex; j <= 9; j++) {
            sum += j;
            // 剪枝：如果总和sum已经大于n了，就直接退出for循环
            if (sum > n) {
                break;
            }
            list.add(j);
            backtrackingII(k, n, j + 1, sum, list, res);
            list.remove(list.size() - 1);
            sum -= j;
        }
    }
}
