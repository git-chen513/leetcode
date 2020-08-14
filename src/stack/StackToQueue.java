package stack;

import java.util.Stack;

/**
 * @Author Baker.chen
 * @create 2020/8/9 23:13
 *
 * 用两个栈实现一个队列
 */
public class StackToQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public StackToQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    /**
     * 入队操作：始终将新元素push到stack1
     */
    public void add(int value){
        stack1.push(value);
    }

    /**
     * 出队操作：
     *    如果两个栈都为空，返回-1
     *    如果stack2不为空，返回stack2的栈顶元素
     *    如果stack2为空，则依次弹出stack1的元素到stack2中，并最终返回stack2的栈顶元素
     */
    public int del(){
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.del());
        System.out.println(queue.del());
        System.out.println(queue.del());
        System.out.println(queue.del());
    }
}
