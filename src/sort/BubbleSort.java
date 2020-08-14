package sort;

import java.util.Arrays;

/**
 * @Author Baker.chen
 * @create 2020/8/13 14:12
 *
 * 冒泡排序
 *  属于交换排序，算法的时间复杂度是O(n^2)
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        // 作为交换数据的中间变量，如果声明在循环里面会导致多次定义，占用内存
        int temp = 0;
        // 用一个标志位来标识一轮比较下来是否有数据交换，如果一轮比较没有任何数据交换，说明已经是有序
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    // 交换数据
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            // 每一轮下来都会判断一下标志位是否为true
            if (!flag) {
                break;
            } else {
                // 一轮比较完需要将标志位再置为false，防止影响下一轮比较
                flag = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {12,15,1,18,2,35,30,11};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
