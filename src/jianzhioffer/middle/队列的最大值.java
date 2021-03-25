package jianzhioffer.middle;

// 未通过
public class 队列的最大值 {
    // 使用一个数组模拟队列
    int[] queue;
    // 队尾插入，尾指针rear指向当前元素的上一个元素
    int rear = 0;
    // 队首删除，头指针front指向当前元素
    int front = 0;
    // 代表队列的最大值，不断更新
    int max = 0;
    public 队列的最大值() {
        queue = new int[10];
    }

    public int max_value() {
        // 判断队列是否为空
        if (rear == 0) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        max = (max == 0 ? value : Math.max(max, value));
        queue[rear] = value;
        rear++;
    }

    public int pop_front() {
        // 判断队列是否为空
        if (rear == 0) {
            return -1;
        }
        return queue[front++];
    }


}
