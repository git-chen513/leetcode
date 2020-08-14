package sort;

import java.util.Arrays;

/**
 * @Author Baker.chen
 * @create 2020/8/13 16:07
 *
 * 选择排序：时间复杂度是O(n^2)
 */
public class SelectSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            int temp = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
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
