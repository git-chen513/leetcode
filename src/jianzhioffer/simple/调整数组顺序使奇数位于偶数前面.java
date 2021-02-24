package jianzhioffer.simple;

import java.util.Arrays;

/**
 * @Author Baker.chen
 * @create 2020/12/6 14:50
 */
public class 调整数组顺序使奇数位于偶数前面 {
    /**
     * 方法一：使用额外的空间+前后指针
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int[] arr = new int[nums.length];
        int front = 0; // 用来指示奇数所在数组下标
        int rear = nums.length - 1; // 用来指示偶数所在数组下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
               // 奇数
               arr[front] = nums[i];
               front++;
            } else {
                // 偶数
                arr[rear] = nums[i];
                rear--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] arr = exchange(nums);
        System.out.println(Arrays.toString(arr));
    }
}
