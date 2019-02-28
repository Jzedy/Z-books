package treeStart.avlT;

/**
 * @author Jzedy
 * @time 2019/2/28 20:55
 * @description
 */
public class AVLTree<T extends Comparable<T>>  {
    private Node<T> root;//根节点

    class Node<T extends Comparable<T>> {
        private T key;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T key, Object data, Node<T> leftChild, Node<T> rightChild) {
            this.key = key;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }


    private int height(Node<T> tree){
        if (tree == null){
            return 0;
        }else return Math.max(height(tree.leftChild),height(tree.rightChild))+1;
    }

    private Node<T> llRotation(Node<T> k){
            Node<T> lk = k.leftChild;
            k.leftChild = lk.rightChild;
            lk.rightChild= k;
            return lk;
    }

    private Node<T> rrRotation(Node<T> k){
        Node<T> rk = k.rightChild;
        k.rightChild = rk.leftChild;
        rk.leftChild = k;
        return rk;
    }


}
