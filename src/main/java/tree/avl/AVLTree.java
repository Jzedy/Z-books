package tree.avl;

/**
 * @author zhangyin
 * @date 2019/3/1
 */
public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    class Node<T>{
        private T key;
        private Node<T> leftChild;
        private Node<T> rightChild;
        private Node<T> parent;

        public Node(T key, Node<T> parent) {
            this.key = key;
            this.parent = parent;
        }
    }

    /**
     * 获取树的高度
     * @return
     */
    public int height(){
        return height(root);
    }

    private int height(Node<T> tree) {
        if (tree == null){
            return 0;
        }else return Math.max(height(tree.leftChild),height(tree.rightChild))+1;
    }



    /**
     * 左左旋转
     * @param tree
     * @return
     */
    private Node<T> llRotation(Node<T> tree){
        Node<T> lTree = tree.leftChild;
        tree.leftChild = lTree.rightChild;
        lTree.rightChild = tree;
        return lTree;
    }

    /**
     * 右右旋转
     * @param tree
     * @return
     */
    private Node<T> rrRotation(Node<T> tree){
        Node<T> rTree = tree.rightChild;
        tree.rightChild = rTree.leftChild;
        rTree.leftChild = tree;
        return rTree;
    }

    /**
     * 左右旋转
     * @param tree
     * @return
     */
    private Node<T> lrRotation(Node<T> tree){
        rrRotation(tree.leftChild);
        return llRotation(tree);
    }

    /**
     * 右左旋转
     * @param tree
     * @return
     */
    private Node<T> rlRotation(Node<T> tree){
        llRotation(tree.rightChild);
        return rrRotation(tree);
    }


    public boolean insert(T key){
        Node<T> current = root;
        if (current == null){
            root = new Node<>(key,null);
        }else {
            Node<T> parent;
            int cmp;
           do {
               parent = current;
               cmp = key.compareTo(current.key);
               if (cmp < 0)current = current.leftChild;
               else if (cmp > 0)current = current.rightChild;
               else break;

           }while (current != null);
           if (cmp == 0){
               return false;
           }else {
               Node<T> newNode = new Node<>(key,parent);
               if (cmp < 0 ){
                   parent.leftChild = newNode;
               }else {
                   parent.rightChild = newNode;
               }

               fixAfterInsertion(newNode);
           }

        }
        return true;
    }

    private Node<T> fixAfterInsertion(Node<T> node) {
        Node<T> result = null;
        if (node.parent != null && node.parent.parent != null){
            Node<T> p = node.parent;
            Node<T> g = node.parent.parent;
            if (height(g.leftChild) -height(g.rightChild) == 2){
                if (p.leftChild == node){
                    result = llRotation(g);
                }else{
                    result =lrRotation(g);
                }
            }
            else if (height(g.rightChild)-height(g.leftChild) == 2){
                if (p.leftChild == node){
                   result = rlRotation(g);
                }else {
                    result = rrRotation(g);
                }
            }
        }
        return result;
    }

    private void inOrder(Node<T> current) {
        if (current != null){
            inOrder(current.leftChild);
            System.out.print(current.key);
            inOrder(current.rightChild);
        }
    }
    public void inOrder(){
        inOrder(root);
    }

    private void preOrder(Node current) {
        if (current!= null){
            System.out.print(current.key);
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    public void preOrder(){
        preOrder(root);
    }




    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
//        avlTree.insert(5);
//        avlTree.insert(2);
//        avlTree.insert(8);
//        avlTree.insert(1);
//        avlTree.insert(4);
//        avlTree.insert(7);
//        avlTree.insert(3);
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.inOrder();
        System.out.println();
        avlTree.preOrder();
        System.out.println();
    }
}
