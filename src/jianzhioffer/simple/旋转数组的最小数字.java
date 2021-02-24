package jianzhioffer.simple;

/**
 * @Author Baker.chen
 * @create 2020/12/6 11:16
 */
public class 旋转数组的最小数字 {
    /**
     * 方法一：接近暴力法
     *  思路：该数组可以看作是两个有序递增数组组合成的，遍历数组，如果遇到后面的数比前面的数小，就是数组中最小的数
     * @param numbers
     * @return
     */
    public static int minArray1(int[] numbers) {
        if (numbers == null ||numbers.length == 0) {
            return -1;
        }
        // 遍历数组，如果遇到后面的数比前面的数小，就是数组中最小的数
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 方法二：二分法+暴力法
     *  思路：将mid元素与right元素进行比较，如果mid元素小于right元素，说明最小元素在mid左边（包括nid）
     *      如果mid元素大于right元素，说明最小元在mid右边（不包括mid）
     *      如果mid元素等于right元素，即数组中有重复元素，那么不好直接判断出最小元素在mid左边还是右边
     *      可以将right--，相当于删除right元素，再将mid元素与right前面的一个元素进行比较
     *
     *  注意：数组中比较特殊的元素就是第一个元素和最后一个元素，这里为什么不用第最左边的元素和mid元素进行呢
     *       因为用
     * @param numbers
     */
    public static int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = {5,5,4,4,4};
        System.out.println(minArray2(arr));
    }
}
