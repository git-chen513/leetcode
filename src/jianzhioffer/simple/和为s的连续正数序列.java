package jianzhioffer.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列 {
    /**
     * 滑动窗口
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        // 整个区间为：[1,2,3……target-1]
        int left = 1;
        int right = left;
        int sum = right;
        while (right < target) {
            if (sum > target) {
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                int[] arr = new int[right - left + 1];
                int x = 0;
                for (int i = left; i <= right; i++) {
                    arr[x] = i;
                    x++;
                }
                list.add(arr);
                sum -= left;
                left++;
                right++;
                sum += right;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
