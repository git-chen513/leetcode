package sort;

/**
 * @Author Baker.chen
 * @create 2021/1/16 22:28
 */
public class 合并两个有序数组 {
    /**
     * 方法一：创建一个中间数组，空间复杂度较大
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge1(int[] A, int m, int[] B, int n) {
        int[] res = new int[m + n];
        int i = 0;    // 用来遍历A数组
        int j = 0;    // 用来遍历B数组
        int temp = 0; // 用来定位res数组的下标
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                res[temp] = A[i];
                i++;
            } else {
                res[temp] = B[j];
                j++;
            }
            temp ++;
        }
        while (i < m) {
            res[temp] = A[i];
            i++;
            temp++;
        }
        while (j < n) {
            res[temp] = B[j];
            j++;
            temp++;
        }
        // 把res数组的值一一复制给A数组
        for (int x = 0; x < m + n; x++) {
            A[x] = res[x];
        }
    }
    /**
     * 方法二（逆向双指针）：直接在原来的数组上进行操作，空间复杂度为1
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int i = m - 1;    // 用来从后往前遍历A数组中的有效元素
        int j =  n - 1;    // 用来从后往前遍历B数组
        int temp = m + n - 1; // 用来从后往前遍历A数组
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[temp] = A[i];
                i--;
            } else {
                A[temp] = B[j];
                j--;
            }
            temp --;
        }
        while (j >= 0) {
            A[temp] = B[j];
            j--;
            temp--;
        }
    }
}
