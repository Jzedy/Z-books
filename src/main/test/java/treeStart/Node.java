package treeStart;

/**
 * @author Jzedy
 * @time 2019/1/26 18:11
 * @description
 */
public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;


    public Node(int data) {
        this.data = data;
    }

    public void display(){
        System.out.println(data);
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
}
