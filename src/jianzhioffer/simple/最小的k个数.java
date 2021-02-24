package jianzhioffer.simple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Baker.chen
 * @create 2020/11/29 16:30
 *
 */
public class 最小的k个数 {
    /**
     * 方法一：选择排序
     * 思路：选择排序每一轮排序之后都可以得到一个最小值
     *      由于只需要返回k个最小的数，所以无需进行完整的n-1趟排序
     *      只需要进行k趟排序，并最终输出数组的前k个数即可
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        // 外层循环，控制排序的趟数，如果是正常的选择排序，则需要进行n-1趟排序
        // top k 问题则只需要进行k趟排序即可
        for (int i = 0; i < k; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        // 创建一个新数组，将该数组的前k个元素依次赋值新数组
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    /**
     * 方法二：堆排序
     * 思路：借助优先队列PriorityQueue实现堆排序
     *      将数组中的元素依次入到优先队列中，默认就会构建一个小根堆
     *      再顺序的从堆中弹出k个元素赋值给数组即可
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int temp : arr) {
            queue.offer(temp);
        }
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = queue.poll();
        }
        return a;
    }

    /**
     * 方法三：TOP K
     * 思路：借助优先队列PriorityQueue构建一个大小为k的大根堆（由于是大根堆，需要传入一个比较器，并重写compare方法）
     *      然后从第k+1个元素开始顺序遍历数组，如果元素值小于大根堆堆定元素，则该元素入堆，并且堆顶元素移除
     *      最后再将大根堆中的元素依次赋值给数组即可
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers3(int[] arr, int k) {
        if (k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        // 首先构建一个大小为k的大根堆
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        // 从第k+1个元素开始遍历，与堆定元素进行比较
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        // 将堆中的元素依次赋值给数组
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = queue.poll();
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,2,0,8};
        int[] a = getLeastNumbers3(arr, 0);
        System.out.println(Arrays.toString(a));
    }
}
