package tree.avl;

/**
 * @author Jzedy
 * @time 2019/3/2 16:21
 * @description
 */
public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;

    class Node<T>{
        private T key;
        private Node<T> left;
        private Node<T> right;


        public Node(T key) {
            this.key = key;
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node<T> tree) {
        if (tree == null) return 0;
        else {
            return Math.max(height(tree.left),height(tree.right))+1;
        }
    }

    /**
     * 左左旋转
     * @param tree
     * @return
     */
    private Node<T> llRotation(Node<T> tree){
        Node<T> lTree = tree.left;
        tree.left = lTree.right;
        lTree.right = tree;
        return lTree;
    }

    /**
     * 右右旋转
     * @param tree
     * @return
     */
    private Node<T> rrRotation(Node<T> tree){
        Node<T> rTree = tree.right;
        tree.right = rTree.left;
        rTree.left = tree;
        return rTree;
    }

    /**
     * 左右旋转
     * @param tree
     * @return
     */
    private Node<T> lrRotation(Node<T> tree){
        rrRotation(tree.left);
        return llRotation(tree);
    }

    /**
     * 右右旋转
     * @param tree
     * @return
     */
    private Node<T> rlRotation(Node<T> tree){
        llRotation(tree.right);
        return rrRotation(tree);
    }


    public void add(T key){
        if (root == null){
            root = new Node<>(key);
        }else {
            add(root,key);
            root = fixAfterOperation(root);
        }
    }

    private Node<T> fixAfterOperation(Node<T> tree) {
        if (tree != null) {
            if (height(tree.left) - height(tree.right) == 2) {
                if (height(tree.left.left) > height(tree.left.right)) {
                    tree = llRotation(tree);
                } else {
                    tree = lrRotation(tree);
                }

            }

            if (height(tree.right) - height(tree.left) == 2) {
                if (height(tree.right.left) > height(tree.right.right)) {
                    tree = rlRotation(tree);
                } else {
                    tree =rrRotation(tree);
                }
            }
        }
        return tree;
    }

    private Node<T> add(Node<T> tree, T key) {
        int tmp;
        if (tree == null){
            tree = new Node<>(key);
        }else {
            tmp = key.compareTo(tree.key);
            if (tmp < 0){
                tree.left = add(tree.left,key);
            }else if (tmp > 0){
                tree.right = add(tree.right,key);
            }else {
                return tree;
            }
        }
        return tree;
    }

    public void remove(T key){
        if (root != null && key != null){
            remove(root,key);
            root = fixAfterOperation(root);
        }
    }

    private Node<T> remove(Node<T> tree, T key) {
        if (tree == null || key == null) return tree;
        int tmp = key.compareTo(tree.key);
        if (tmp < 0){
            tree.left = remove(tree.left,key);
        }else if (tmp > 0){
            tree.right = remove(tree.right,key);
        }else {
                Node<T> successor = successor(tree);
                if (successor == null){//删除节点的右子树为空
                    Node<T> l = tree.left;//查看左子树
                    if (l == null){
                        tree = null;
                    }else {
                        tree.key = l.key;
                        tree.left = remove(tree.left,l.key);
                    }
                }else {
                    tree.key = successor.key;
                    tree.right = remove(tree.right,successor.key);
                }
        }
        return tree;
    }

    private Node<T> successor(Node<T> tree) {
        Node<T> result = tree.right;
        while (result != null && result.left != null){
            result = result.left;
        }
        return result;
    }

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
//        tree.add(5);
        tree.remove(1);
        System.out.println();
    }

}
