package queue;

/**
 * @Author Baker.chen
 * @create 2020/8/11 0:36
 *
 * 基于数组实现的队列
 */
public class ArrayQueue {

    /**
     * 因为队列的相关方法都在此类中声明，外部类不需要直接访问该类的成员变量，所以成员变量可以用private修饰
     */
    private int maxsize;
    /**
     * 队列的头指针，元素出队，头指针加一
     */
    private int front;
    /**
     * 队列的尾指针，元素入队，尾指针加一
     */
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxsize = arrMaxSize;
        arr = new int[maxsize];
        /**
         * 初始情况：队列的头指针和尾指针都指向-1
         *         头指针指向队首的前一个元素
         *         尾指针指向队尾的那个元素
         */
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxsize - 1;
    }

    /**
     * 入队：队尾插入，rear+1
     * @param x
     */
    public void addQueue(int x) {
        // 先判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加了！");
            return;
        }
        rear++;
        arr[rear] = x;
    }

    /**
     * 出队：队首删除，front+1
     */
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 方法返回值为int,队列为空要结束方法不能直接是return,必须是return一个int 值,因此可以使用抛出异常来结束方法
            throw new RuntimeException("队列为空，无法出队！");
        }
        front++;
        return arr[front];
    }

    /**
     * 访问队首元素
     * @return
     */
    public int headQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取队首元素！");
        }
        return arr[front + 1];
    }

    /**
     * 遍历输出队列的元素
     */
    public void show() {
        // 判断队列是否空
        if (isEmpty()) {
            System.out.println("队列为空！");
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }
}
