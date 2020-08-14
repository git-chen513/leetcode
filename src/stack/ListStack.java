package stack;

/**
 * @Author Baker.chen
 * @create 2020/8/7 11:47
 *
 * 基于链表实现的栈：就是插入和删除操作都在链表的同一端操作
 * 可以是在链表的尾部进行插入和删除，也就是所谓的尾插法
 * 也可以是在链表的头部进行插入和删除，也就是所谓的头插法
 * 如果是尾插法的话，那么top指向的是链表的最后一个元素（栈顶元素），由于单链表的局限性，依靠top节点就不好做出栈操作
 * 因此，基于链表实现的栈应该使用的是头插法，也就是插入和删除都在链表的头部进行
 */
public class ListStack {
	/**
	 * top节点用来指向链栈的栈顶
	 */
	ListNode top = null;

	/**
	 * 入栈：为了便于后面出栈的操作，我们在这里是把新插入节点的next域指向原来的top指向的节点，
	 * 		而不是像传统链表一样，将原来链表的最后一个节点的next域指向新节点
	 * @param x
	 */
	public void push(int x){
		ListNode newListNode = new ListNode(x);
		if(isEmpty()) {
			top = newListNode;
		} else {
			ListNode temp = top;
			top = newListNode;
			newListNode.next = temp;
		}
	}

	/**
	 * 出栈
	 * @return
	 */
	public int pop(){
		if(isEmpty()) {
			return -1;
		} else {
			int x = top.val;
			top = top.next;
			return x;
		}
	}

	/**
	 * 取栈顶元素
	 */
	public int peek(){
		if(isEmpty()) {
			return -1;
		} else {
			return top.val;
		}
	}

	/**
	 * 求栈的大小
	 * @return
	 */
	public int size(){
		int count = 0;
		if(isEmpty()) {
			return count;
		} else {
			ListNode temp = top;
			while(temp != null) {
				count++;
				temp = temp.next;
			}
			return count;
		}
	}

	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return top == null;
	}

	/**
	 * 清空栈
	 */
	public void clear(){
		top = null;
	}
}
