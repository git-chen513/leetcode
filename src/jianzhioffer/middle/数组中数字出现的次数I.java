package jianzhioffer.middle;

import java.util.Arrays;

public class 数组中数字出现的次数I {
    /**
     * 分组异或
     *
     * 异或操作的性质：对于两个操作数的每一位，相同结果为0，不同结果为1。那么在计算过程中，成对出现的数字的所有位会两两抵消为 0
     * 异或运算的几个特点：
     *      交换律
     *      结合律（即(a^b)^c == a^(b^c)）
     *      对于任何数x，都有x^x=0，x^0=x
     *
     * 如果题目是数组中一个数出现一次，其他数都出现了两次（偶数次），那么可以直接对数组中的全部元素进行异或运算，最终的结果就是只出现一次的那个数
     * 而如果题目是数组中一个数只出现一次，其他数都出现了奇数次，那么就不适用异或运算这种思路，因为奇数次异或出来的结果还是这个数本身
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        // res的值为对整个数组异或出来的结果，也就是数组中两个出现次数不为2的数异或出来的结果
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        // 一个数和它的相反数进行与操作，可以找到这个数的二进制形式从右到左第一个值为1的位
        // index的二进制形式为：只有一位为1，其余位都为0
        int index = res & (-res);
        // 表示第一组的异或结果
        int a = 0;
        // 表示第二组的异或结果
        int b = 0;
        for (int n : nums) {
            if ((n & index) == 0) {
                // 说明对应的位为0，为一组
                a = a ^ n;
            } else {
                // 说明对应的位为1，为一组
                b = b ^ n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3,3,4,5,5,6};
        System.out.println(Arrays.toString(singleNumbers(arr)));
    }
}
