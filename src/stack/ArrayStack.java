package stack;

/**
 * @Author Baker.chen
 * @create 2020/8/7 11:47
 *
 * 基于数组实现的栈
 */
public class ArrayStack {
	/**
	 * 栈的最大容量
	 */
	private int maxsize;
	/**
	 * 数组模拟栈
	 */
	private int[] stack;
	/**
	 * 栈顶指针，栈为空时等于-1
	 */
	private int top = -1;

	public ArrayStack(int size){
		this.maxsize = size;
		stack = new int[this.maxsize];
	}

	/**
	 * 判断栈是否满
	 */
	public boolean isFull(){
		return top == maxsize-1;
	}

	/**
	 * 判断栈是否空
	 * @return
	 */
	public boolean isEmpty(){
		return top == -1;
	}

	/**
	 * 入栈
	 * @param x
	 */
	public void push(int x){
		if(isFull()){
			System.out.println("栈已满~");
			return;
		}
		top++;
		stack[top] = x;
	}

	/**
	 * 出栈
	 * @return
	 */
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("栈为空~");
		}
		return stack[top--];
	}

	/**
	 * 取栈顶元素，栈顶元素并不出栈
	 * @return
	 */
	public int peek(){
		if(isEmpty()){
			throw new RuntimeException("栈为空~");
		}
		return stack[top];
	}

	/**
	 * 遍历栈
	 */
	public void list(){
		if (isEmpty()) {
			System.out.println("栈为空~");
			return;
		}
		for(int i = top; i >= 0; i--){
			System.out.println(stack[i]);
		}
	}
}
