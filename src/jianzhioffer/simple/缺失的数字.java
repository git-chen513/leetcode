package jianzhioffer.simple;

// 0~n-1缺失的数字
public class 缺失的数字 {
    /**
     * 直接遍历整个数组，遇到第一个元素值不等于所对应的下标时，即返回
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    /**
     * 二分法（数组有序，就应该想到二分法）
     * 不缺失数字的情况下，每个数的值都应该对应所在位置的下标
     * 注意：如果数组所给的元素都是连续的，那么缺失的就是最后一个元素，例如[0,1,2,3]，那么缺失的元素是4
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                // 说明缺失的数一定在右边
                left = mid + 1;
            } else {
                // 说明缺失的数一定在中间元素的左边（nums[mid]也是有可能的）
                right = mid;
            }
        }
        // 考虑特殊情况，如果退出循环时left指向数组最后一个元素，那么有两种情况：
        // 一是left指向的位置就是缺失的那个数
        // 二是left指向的后一个位置才是缺失的那个数
        if (left == nums.length - 1 && nums[left] == left) {
            return left + 1;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        System.out.println(missingNumber1(arr));
    }
}


