package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Baker.chen
 * @create 2020/8/17 15:47
 *
 * 定义一个二叉树操作类：包括先序遍历，中序遍历，后序遍历，层次遍历，求树的高度，求叶子节点数
 *
 */
public class BinaryTree {

	/**
	 * 先序遍历：先输出根节点，再递归处理左孩子，最后递归处理右孩子
	 * @param root
	 */
	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root + "->");
		if (root.leftChild != null) {
			preOrder(root.leftChild);
		}
		if (root.rightChild != null) {
			preOrder(root.rightChild);
		}
	}

	/**
	 * 中序遍历：先递归处理左孩子，然后输出根节点，最后递归处理右孩子
	 * @param root
	 */
	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		if (root.leftChild != null) {
			inOrder(root.leftChild);
		}
		System.out.print(root + "->");
		if (root.rightChild != null) {
			inOrder(root.rightChild);
		}
	}

	/**
	 * 后序遍历：先递归处理左孩子，再递归处理右孩子，最后输出根节点
	 * @param root
	 */
	public void afterOrder(Node root) {
		if (root == null) {
			return;
		}
		if (root.leftChild != null) {
			afterOrder(root.leftChild);
		}
		if (root.rightChild != null) {
			afterOrder(root.rightChild);
		}
		System.out.print(root + "->");
	}

	/**
	 * 层次遍历：从左到右依次访问节点
	 * 可以使用队列这种数据结构
	 * @param root
	 */
	public void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		// 创建一个队列
		Deque<Node> queue = new LinkedList<>();
		// 根节点入队
		queue.offer(root);
		// 只要队列不为空，则依次出队
		while (!queue.isEmpty()) {
			// 出队
			Node node = queue.poll();
			// 访问出队的节点值
			System.out.print(node.getData() + "->");
			// 如果出队的这个节点的左节点不为空，则让左节点入队
			if (node.leftChild != null) {
				queue.offer(node.leftChild);
			}
			// 如果出队的这个节点的右节点不为空，则让右节点入队
			if (node.rightChild != null) {
				queue.offer(node.rightChild);
			}
		}
	}

	/**
	 * 求二叉树的高度
	 * @param root
	 * @return
	 */
	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return 1;
		}
		return height(root.leftChild) > height(root.rightChild) ? height(root.leftChild) + 1 : height(root.rightChild) + 1;
	}

	/**
	 * 求二叉树的叶子节点数
	 * @param root
	 * @return
	 */
	public int num_leaf(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return 1;
		}
		return num_leaf(root.leftChild) + num_leaf(root.rightChild);
	}

	public static void main(String[] args) {
		// 创建几个节点
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		// 手动构建一颗二叉树
		node4.setLeftChild(node3);
		node4.setRightChild(node9);
		node9.setLeftChild(node7);
		node9.setRightChild(node8);
		node7.setLeftChild(node1);
		
		BinaryTree findTree = new BinaryTree();
		System.out.println("先序遍历的结果为……");
		//4,3,9,7,1,8
		findTree.preOrder(node4);
		System.out.println();
		System.out.println("中序遍历的结果为……");
		// 3,4,1,7,9,8
		findTree.inOrder(node4);
		System.out.println();
		System.out.println("后序遍历的结果为……");
		// 3,1,7,8,9,4
		findTree.afterOrder(node4);
		System.out.println();
		System.out.println("层次遍历的结果为……");
		//4,3,9,7,8,1
		findTree.levelOrder(node4);
		System.out.println();
		System.out.println("二叉树的高度为：" + findTree.height(node4));
		System.out.println("二叉树的叶子节点数为：" + findTree.num_leaf(node4));
	}
}