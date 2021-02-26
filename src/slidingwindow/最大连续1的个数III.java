package slidingwindow;

public class 最大连续1的个数III {
    /**
     * 滑动窗口：右边无脑滑动，左边看情况收缩
     *
     * 滑动窗口的限制条件是：窗口内最多有 K 个 0
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int count = 0; // 记录滑动窗口中0的个数
        int max = 0; // 记录最大值，不断更新
        int left = 0; // 左指针
        // right是右指针，不断右移至数组的最后一个元素（注意right必须从下标0开始移动，因为第一个元素的值可能就是0）
        for (int right = 1; right < A.length; right++) {
            if (A[right] == 0) {
                count++;
            }
            if (count > K) {
                // 滑动窗口中0的个数超过了K，左指针收缩，使得count <= K
                while (A[left] == 1) {
                    left++;
                }
                // 注意：左指针还需要再移动一次
                left++;
                // 滑动窗口中0的个数减一
                count--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
