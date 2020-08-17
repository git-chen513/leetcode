package dp;

/**
 * @Author Baker.chen
 * @create 2020/8/15 11:54
 *
 * 动态规划之选数问题：
 * 假设给定一串数字{1, 2, 4, 1, 7, 8, 3}，我们要从中选择若干个数，使最后的和达到最大。
 * 选择的规则是，不能选相邻的数字。比如：如果我们选了第一个数字1，那么我们就不能选2，如果我们选择了数字4，那么我们就不能选择与它相邻的2和1。
 *
 * 思路：
 *  1. 对于每个数，都有选和不选两种状态，如果选了这个数，那么就不能选他相邻的那个数，那么最大和就等于本身加上他相邻的那位数之前那些数的最大和，
 *  如果不选这个数，那么便可以选它相邻的那个数，那么最大和就等于这个数之前的那些数的最大和。最终的结果就是取这两种选择的最大值
 *  这里就可以使用递归，即Math.max(dp(arr, x-2)+arr[x], dp(arr, x-1))；
 *
 *  2.递归的出口：
 *  如果只有一个数，那么最大和就是本身
 *  如果只有两个数，那么最大和就是这两个数中的最大值
 */
public class SelectionDp {

    /**
     *  递归解法：代码简洁，要多次重复计算相同的值，效率低
     * @param arr 将给定的一串数字放在数组中
     * @param x 数组下标，也就是求出数组第一个元素到这个下标之间的最大和
     * @return
     */
    public static int test1(int[] arr, int x) {
        if (x == 0) {
            return arr[0];
        }
        if (x == 1) {
            return Math.max(arr[0], arr[1]);
        }
        return Math.max(test1(arr,x-2) + arr[x],test1(arr,x-1));
    }

    /**
     * 非递归解法：创建一个数组来保存计算过的值，由此提高效率。
     *  例如temp[0]用来保存数组中只有一个数的最大和，temp[1]用来保存数组中只有两个数的最大和；
     *  temp[arr.length()-1]用来保存整个数组的最大和
     * @param arr
     * @return
     */
    public static int test2(int[] arr) {
        int[] tempArr = new int[arr.length];
        tempArr[0] = arr[0];
        tempArr[1] = Math.max(arr[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            tempArr[i] = Math.max(tempArr[i-2] + arr[i],tempArr[i-1]);
        }
        return tempArr[arr.length-1];
    }
}
