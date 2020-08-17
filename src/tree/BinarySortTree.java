package tree;

/**
 * @Author Baker.chen
 * @create 2020/8/17 15:47
 *
 * 二叉排序树，也叫二叉查找树，BST（Binary Sort Tree/Binary Search Tree）
 *
 * 二叉排序树的特点是若它的左子树不为空，则左子树上所有节点的值均小于根节点的值；
 * 若它的右子树不为空，则右子树上所有节点的值均大于根节点的值；
 * 对二叉排序树进行中序遍历可以得到一个按关键字排序的有序序列，
 * 因此一个无序序列可以通过构造一颗二叉排序树而成为有序序列。
 */
public class BinarySortTree {

	/**
	 * 给定一颗二叉排序树，查找指定值的节点
	 * @param root
	 * @param val
	 * @return
	 */
	public Node search(Node root, int val) {
		if (root == null) {
			return null;
		}
		// 如果根节点的值等于要查找的值，直接返回根节点
		if (root.getData() == val) {
			return root;
		}
		// 如果待查找的值小于根节点，且根节点的左子树不为空，那么递归向左子树查找
		if (val < root.getData()) {
			if (root.leftChild != null) {
				return search(root.leftChild,val);
			} else {
				return null;
			}
		} else {
			if (root.rightChild != null) {
				return search(root.rightChild,val);
			} else {
				return null;
			}
		}
	}

	/**
	 * 添加节点
	 * @param root
	 * @param node
	 */
	public void addNode(Node root, Node node) {
		if (root == null) {
			root = node;
			return;
		}
		// 如果新插入节点的值小于根节点的值,则将新节点插入到根节点的左子树
		if (node.getData() < root.getData()) {
			// 进一步判断根节点的左子树是否为空
			if (root.leftChild == null) {
				// 为空，则直接将新节点赋给根节点的左节点
				root.leftChild = node;
			} else {
				// 不为空，继续递归处理
				addNode(root.leftChild,node);
			}
		} else {
			// 如果新插入节点的值大于根节点的值,则将新节点插入到根节点的左子树
			// 进一步判断根节点的右子树是否为空
			if (root.rightChild == null) {
				// 为空，则直接将新节点赋给根节点的右节点
				root.rightChild = node;
			} else {
				// 不为空，继续递归处理
				addNode(root.rightChild,node);
			}
		}
	}

	/**
	 * 中序遍历：返回一个有序序列
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

	public static void main(String[] args) {
		// 创建几个节点
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		// 创建一颗二叉排序树
		BinarySortTree bst = new BinarySortTree();
		bst.addNode(null, node3);
		bst.addNode(node3, node1);
		bst.addNode(node3, node9);
		bst.addNode(node3, node4);
		bst.addNode(node3, node8);
		bst.addNode(node3, node7);

		System.out.println("根据中序遍历返回的有序序列为…………");
		bst.inOrder(node3);
		System.out.println();

		System.out.println("查找的结果为…………");
		Node search = bst.search(node3, 1);
		System.out.println(search);
	}
}
