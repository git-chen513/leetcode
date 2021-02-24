package sort;

import java.util.Arrays;

/**
 * @Author Baker.chen
 * @create 2021/1/16 23:29
 */
public class 排序数组 {
    /**
     * 方法一：使用数组工具类的排序方法
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 方法二：归并排序
     * @param nums
     * @return
     */
    public static int[] sortArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 分治思想的分：也就是将一个大的数组每次拆分成两部分，直到拆分成每部分只有一个元素为止，然后再依次进行合并
     * @param nums
     * @param l
     * @param r
     */
    public static void divide(int[] nums, int l, int r) {
        // 递归出口
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        divide(nums, l, mid);
        divide(nums,mid + 1, r);
        merge(nums, l, mid, r);
    }
    /**
     * 分治算法思想的治：合并两个有序数组，在本题中是将数组从下标mid切分成两部分，并合并[l,mid]、[mid+1,r]这两部分
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[cur] = nums[i];
                i++;
            } else {
                temp[cur] = nums[j];
                j++;
            }
            cur++;
        }
        while (i <= mid) {
            temp[cur] = nums[i];
            i++;
            cur++;
        }
        while (j <= r) {
            temp[cur] = nums[j];
            j++;
            cur++;
        }
        // 将排好序的临时数组重新赋值给原数组，注意是下标从l-r
        for (int x = 0; x < temp.length; x++) {
            nums[l++] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,7,5,3,9};
        int[] res = sortArray2(nums);
        System.out.println(Arrays.toString(res));
    }
}
