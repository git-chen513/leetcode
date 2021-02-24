package search;

import java.util.HashMap;

// 统计一个数字在排序数组中出现的次数
public class 在排序数组中查找数字I {
    /**
     * 方法一：使用Map集合统计
     * 思路简单，但是需要遍历整个数组，没有使用到数组已排好序这个特性，时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
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
     * 方法二：使用非递归二分法
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int count = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 可能目标值不止一个，因此还需要继续往左和往右遍历，直到遍历到的值不等于目标值即可退出
                count++;
                int l = mid - 1;
                int r = mid + 1;
                while (l >= 0) {
                    if (nums[l] == target) {
                        count++;
                        l--;
                    } else {
                        break;
                    }
                }
                while (r <= nums.length - 1) {
                    if (nums[r] == target) {
                        count++;
                        r++;
                    } else {
                        break;
                    }
                }
                return count;//此处记得return，否则会死循环
            }
        }
        return count;
    }
    /**
     * 方法三：使用递归二分法
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target, int left, int right) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (left > right) {
            return 0;
        }
        int mid = (left + right) / 2;
        if (target < nums[mid]) {
            return search(nums, target, left, mid - 1);
        } else if (target > nums[mid]) {
            return search(nums, target, mid + 1, right);
        } else {
            return search(nums, target, left, mid - 1) + search(nums, target, mid + 1, right) + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,6,6,6,7,8,9};
        System.out.println(search(arr, 7, 0, arr.length - 1));
    }
}
