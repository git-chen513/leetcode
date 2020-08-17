package tree;

/**
 * @Author Baker.chen
 * @create 2020/8/17 15:47
 *
 * 定义一个二叉树的节点类
 */
class Node {
    public int data;
    public Node leftChild;
    public Node rightChild;

    public Node(){
    }

    public Node(int data) {
        super();
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }
}