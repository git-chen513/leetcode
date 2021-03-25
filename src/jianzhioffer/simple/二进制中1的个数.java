package jianzhioffer.simple;

/**
 * @Author Baker.chen
 * @create 2020/11/28 15:36
 */
public class 二进制中1的个数 {
    public static int hammingWeight(int n) {
        int index = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & index) != 0) {
                res++;
            }
            index = index << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }
}
