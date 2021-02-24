package stack;

import java.util.LinkedList;

// 注意：由于栈中存放的是数组的下标，所以需要用到柱子的高度时，记得转换过来
public class 接雨水 {
    public static int trap(int[] height) {
        // 创建一个单调栈，为了便于后面计算，栈中存放的是数组的下标
        LinkedList<Integer> stack = new LinkedList<>();
        // 第一个元素先直接入栈
        stack.push(0);
        // 保存雨水的数量
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                // 出栈的元素需要保存起来，作为底部参考值
                int temp = height[stack.pop()];
                // 判断栈是否为空，为空，接不到雨水，直接break
                if (stack.isEmpty()) {
                    break;
                }
                // 不为空，计算雨水
                int w = i - stack.peek() - 1; // 宽度
                int h = Math.min(height[i], height[stack.peek()]) - temp; // 高度
                sum += w * h;
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(trap(arr));
    }
}
