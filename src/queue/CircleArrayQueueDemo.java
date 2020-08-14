package queue;

/**
 * @Author Baker.chen
 * @create 2020/8/11 0:55
 *
 * 循环队列
 *
 * 由于普通队列可能出现队列“假满”的情况
 * 因此可以使用循环队列来实现队列的复用
 */
public class CircleArrayQueueDemo {

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

    public CircleArrayQueueDemo(int arrMaxSize) {
        this.maxsize = arrMaxSize;
        arr = new int[maxsize];
        /**
         * 初始情况：队列的头指针和尾指针都指向0
         *         头指针指向队首的那个元素
         *         尾指针指向队尾的后一个元素
         */
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否满（循环队列预留一个空间作为约定，用来区分队空和队满；即假设maxsize=4，队列最多只能存放三个元素）
     * @return
     */
    public boolean isFull() {
        return (rear+1)%maxsize==front;
    }

    /**
     * 入队
     * @param x
     */
    public void addQueue(int x) {
        // 先判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加了！");
            // 方法返回值为空，队列满的时候要结束方法可以直接使用return;
            return;
        }
        arr[rear] = x;
        //避免数组越界
        rear=(rear+1)%maxsize;
    }

    /**
     * 出队
     * @return
     */
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 方法返回值为int,队列为空要结束方法不能直接是return,必须是return一个int 值,因此可以使用抛出异常来结束方法
            throw new RuntimeException("队列为空，无法出队！");
        }
        int result=arr[front];
        front=(front+1)%maxsize;
        return result;
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
        return arr[front];
    }

    /**
     * 遍历输出队列的元素
     */
    public void show() {
        // 判断队列是否空
        if (isEmpty()) {
            System.out.println("队列为空！");
        }
        for (int i = front; i < front+sum(); i++) {
            System.out.println(arr[i%maxsize]);
        }
    }

    /**
     * 计算队列有效数据的个数
     * @return
     */
    public int sum(){
        return (rear+maxsize-front)%maxsize;
    }

}
