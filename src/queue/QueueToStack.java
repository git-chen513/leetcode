package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Baker.chen
 * @create 2020/8/11 1:08
 *
 * 双队列实现栈
 */
public class QueueToStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public QueueToStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * 入栈：因为每一次出栈操作之后都会使得一个队列为空
     *      所以入栈操作是直接插入到不为空的那个队列
     *      如果两个队列都为空，则插入任一个队列都可
     * @param x
     */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.isEmpty();
        }
    }

    /**
     * 出队：如果队列1为空，则将队列2的n-1个元素入队到队列1中，最终队列2出队即实现出栈操作；
     *     同样，如果队列2为空，则将队列1的n-1个元素入队到队列2中，最终队列1出队即实现出栈操作；
     */
    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
}
