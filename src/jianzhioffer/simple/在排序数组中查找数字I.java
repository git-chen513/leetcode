package jianzhioffer.simple;

import java.util.HashMap;

/**
 * @Author Baker.chen
 * @create 2020/12/4 22:36
 */
public class 在排序数组中查找数字I {
    /**
     * 方法一：使用HashMap
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        if (map.containsKey(target)) {
            return map.get(target);
        } else {
            return 0;
        }
    }

    /**
     * 方法二：使用二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }
        //return binarySearch1(nums, 0, nums.length - 1, target);
        return binarySearch2(nums, target);
    }

    // 二分查找-递归
    public static int binarySearch1(int[] nums, int left, int right, int target) {
        if (left > right) {
            return 0;
        }
        int mid = (left + right)/2;
        int temp = nums[mid];
        if (target == temp) {
            return binarySearch1(nums, left, mid - 1, target) + binarySearch1(nums, mid + 1, right, target) + 1;
        } else if (target < temp) {
            return binarySearch1(nums, left, mid - 1, target);
        } else {
            return binarySearch1(nums, mid + 1, right, target);
        }
    }

    // 二分查找-非递归
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            int mid = (left + right)/2;
            int temp = nums[mid];
            if (target < temp) {
                right = mid - 1;
            } else if (target > temp) {
                left = mid + 1;
            } else {
                count++;
                // 从左边顺序遍历统计
                int a = mid - 1;
                while (a >= 0) {
                    if (nums[a] == target) {
                        count++;
                    }
                    a--;
                }
                // 从右边顺序遍历统计
                int b = mid + 1;
                while (b < nums.length) {
                    if (nums[b] == target) {
                        count++;
                    }
                    b++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search2(nums, 8));
    }
}
