package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合 {
    /**
     * 使用回溯算法：回溯算法其实也是暴力搜索，只不过有些题目想通过多层for循环去暴力搜索都写不出来，就只能使用回溯算法了
     *             例如本题中，如果k=2，那么可以通过两层for循环解决，但是k是一个参数，无法确定大小，再者如果k=50，那么也写不出50层for循环
     *             回溯算法一般用于解决：组合问题、排列问题、切割问题、子集问题、棋盘问题
     *             回溯算法本质也是递归，通常是递归一次，就得回溯一次，而回溯的操作一般也是递归之前的一个逆操作
     *             （比如递归之前往集合添加了一个元素，那么回溯操作就要移除这个元素）
     *             回溯问题都可以抽象成树形结构（N叉树），集合的大小就是树的宽度，递归的深度就是树的深度
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, 1, temp, res);
        return res;
    }
    /**
     *
     * @param n
     * @param k
     * @param startIndex：代表每次for循环的子集起始下标，组合问题通常都要有这个参数
     * @param temp：保存中间结果，每次回溯时，都应该remove最后一个元素
     * @param res：结果列表
     */
    public void backtracking(int n, int k, int startIndex, List<Integer> temp, List<List<Integer>> res) {
        // 递归结束的条件：当temp集合的长度等于k时，递归终止
        if (temp.size() == k) {
            // 注意：不能直接执行res.add(temp);这行代码，这样会导致最终的结果都是空集合
            // 因为这行代码代表res集合的引用指向temp集合，而temp集合又是不断改变的，所以会导致最终的结果不正确

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                list.add(temp.get(i));
            }
            res.add(list);
            // 递归出口记得return，否则可能发生死循环
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            // 递归前的操作
            temp.add(i);
            // 递归
            backtracking(n, k, i + 1, temp, res);
            // 回溯操作：递归前的逆操作
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 改进：对该回溯问题进行剪枝，提高效率（剪枝通常都是在for循环做操作）
     * 如果for循环选择的起始位置之后的元素个数已经不足我们需要的元素个数了，那么就没有必要搜索了
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine1(int n, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking1(n, k, 1, stack, res);
        return res;
    }
    /**
     *
     * @param n
     * @param k
     * @param startIndex：代表每次for循环的子集起始下标
     * @param stack：保存中间结果，利用栈先进后出的特性，方便回溯
     * @param res：结果列表
     */
    public void backtracking1(int n, int k, int startIndex, LinkedList<Integer> stack, List<List<Integer>> res) {
        // 递归结束的条件
        if (stack.size() == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < stack.size(); i++) {
                list.add(0,stack.get(i));
            }
            res.add(list);
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            // 还需要的元素个数
            int x = k - stack.size();
            // for循环选择的起始位置之后的元素个数
            int y = n - startIndex + 1;
            // 剪枝
            if (y < x) {
                break;
            }
            // 递归前的操作
            stack.push(i);
            // 递归
            backtracking1(n, k, i + 1, stack, res);
            // 回溯操作：递归前的逆操作
            stack.pop();
        }
    }
}
