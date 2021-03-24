package jianzhioffer.middle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 数组中数字出现的次数II{
    /**
     * 使用哈希表统计
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int a = map.getOrDefault(x, 0);
            map.put(x, a + 1);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> temp = iterator.next();
            if (temp.getValue() == 1) {
               return temp.getKey();
            }
        }
        return -1;
    }

    /**
     * 位运算
     *  思路：如果一个数字出现三次,那么它的二进制表示的每一位(0或者1)也出现三次。
     *      如果把所有出现三次的数字的二进制表示的每一位都分别加起来,那么每一位的和都能被3整除。
     *      如果某一位的和能被3整除,那么那个只出现一次的数字二进制表示中对应的那一位是0;否则就是1
     *
     * 这种思路适用于数组中一个数字出现一次，其他数字出现奇数次的问题(如果是偶数次，直接用异或就可)
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        // 一个int型整数占4个字节，共32位，因此创建一个长度为32的数组，统计每一位出现的次数
        // 由于数组的长度固定是32，因此空间复杂度为O(1)
        int[] temp = new int[32];
        for (int x : nums) {
            // 对数组中的每个数进行统计，index变量都必须初始化为1
            int index = 1;
            // 从右往左统计
            for (int i = 31; i >= 0; i--) {
                if ((x & index) != 0) {
                    // 说明对应二进制位的值为1
                    temp[i]++;
                }
                // 对index左移一位，统计x的上一位
                // 这里虽然也可以对x进行右移来比较下一位，但是右移左补位需要考虑正数负数的情况，并且数组中的元素也会被改变
                // 因此我们换一种思路：对index变量进行左移，左移只需右补位0，不用考虑正负，并且数组中的元素也不会被改变
                index = index << 1;
            }
        }
        // 从二进制数组构建出十进制整数
        int res = 0;
        for(int i  =0; i < 32; i++){//这种做法使得本算法同样适用于负数的情况
            res = res << 1;
            res += temp[i] % 3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,1,1,4,3,3,3};
        System.out.println(singleNumber1(arr));
    }
}
