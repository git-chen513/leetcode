package search;

public class 二分查找 {
    /**
     * 递归法
     */
    public static int search(int[] arr, int target, int left, int right) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 递归终止的条件
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target < arr[mid]) {
            return search(arr, target, left, mid - 1);
        } else if (target > arr[mid]) {
            return search(arr, target, mid + 1, right);
        } else {
            return mid;
        }
    }

    /**
     * 非递归法/循环法
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9,11};
        System.out.println(search(arr, 19, 0, arr.length - 1));
        System.out.println(search(arr, 19));
    }
}
