package stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author Baker.chen
 * @create 2020/12/22 22:59
 */
public class 每日温度 {
    /**
     * 暴力法：双重for循环
     * @param T
     * @return
     */
    public static int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1;j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 使用单调栈：对于每一个数来说，要找到右边第一个比他大的数，并求出他们的下标差
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        // 创建一个栈，当做单调递减栈来用（栈中存放的是每个元素在T数组中的下标值）
        LinkedList<Integer> stack = new LinkedList<>();
        // 第一个元素下标值入栈
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            // 如果当前要入栈的元素值大于栈顶元素，那么违反单调栈的特性，需要出栈，直至符合条件才可入栈
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures2(T)));
    }
}
