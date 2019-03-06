package tree.rbTree;

/**
 * @author zhangyin
 * @date 2019/3/5
 */
public class RBTree<T extends Comparable<T>> {

    private Node<T> root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    class Node<T>{
        private T key;
        private Node<T> left;//左子节点
        private Node<T> right;//右子节点
        private Node<T> parent;//父节点
        private boolean color;//颜色

        public Node(T key, Node<T> parent) {
            this.key = key;
            this.parent = parent;
        }
    }

    private Node<T> parentOf(Node<T> node){
        return node == null ? null : node.parent;
    }

    private Node<T> leftOf(Node<T> node){
        return node == null ? null : node.left;
    }

    private Node<T> rightOf(Node<T> node){
        return node == null ? null : node.right;
    }

    private boolean colorOf(Node<T> node){
        return node == null ? BLACK : node.color;
    }

    private void setColor(Node<T> node,boolean color){
        if (node != null){
            node.color = color;
        }
    }

    /**
     * 左旋(对x左旋) 下图为x为父节点的左子节点
     *        px                             px
     *       /                              /
     *     x             ==>              y
     *   / \                            / \
     * lx   y                         x   ry
     *    / \                       / \
     *  ly  ry                    lx  ly
     * @param x
     */
    private void leftRotation(Node<T> x){
        if (x != null){
            Node<T> y = x.right;
            x.right = y.left;
            if (y.left != null){
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null){
                root = y;
            }else if (x.parent.left == x){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
            x.parent = y;
            y.left = x;
        }
    }

    /**
     *右旋(对x右旋) 下图为x为父节点的左子节点
     *             px                              px
     *           /                                /
     *         x                                y
     *       / \                             /  \
     *     y   rx          ==>             ly   x
     *   / \                                  / \
     * ly  ry                               ry  rx
     *
     * @param x
     */
    private void rightRotation(Node<T> x){
        if (x != null){
            Node<T> y = x.left;
            x.left = y.right;
            if (y.right != null){
                y.right.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null){
                root = y;
            }else if (x.parent.left == x){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
            y.right = x;
            x.parent = y;
        }
    }

    public boolean add(T key){
        Node<T> current = root;
        if (current == null){
            root = new Node<>(key,null);
            return true;
        }

        Node<T> parent;int cmp;
        do {
            parent = current;
            cmp = key.compareTo(current.key);
            if (cmp < 0){
                current = current.left;
            }else if (cmp > 0){
                current = current.right;
            }else return false;//红黑树中已经有对应的节点
        }while (current != null);
        Node<T> e = new Node<>(key,parent);
        if (cmp < 0){
            parent.left = e;
        }else parent.right = e;
        fixAfterOperation(e);
        return true;
    }

    private void fixAfterOperation(Node<T> x) {
        x.color = RED;
        while (parentOf(x) != null && parentOf(x).color == RED){
           if (parentOf(x) == leftOf(parentOf(parentOf(x)))){//父节点是祖父节点的左子节点
               Node<T> y = rightOf(parentOf(parentOf(x)));//叔叔节点
               if (colorOf(y) == RED){//叔叔节点也是红色
                   setColor(parentOf(x),BLACK);
                   setColor(y,BLACK);
                   setColor(parentOf(parentOf(x)),RED);
                   x = parentOf(parentOf(x));
               }else {//叔叔节点是黑色
                   if (x == rightOf(parentOf(x))){//当前节点是父节点的右子节点
                        x=parentOf(x);
                        leftRotation(x);
                   }
                   setColor(parentOf(x),BLACK);
                   setColor(parentOf(parentOf(x)),RED);
                   rightRotation(parentOf(parentOf(x)));
               }
           }else {//父节点是祖父节点的右子节点
               Node<T> y = leftOf(parentOf(parentOf(x)));//叔叔节点
               if (colorOf(y) == RED){
                   setColor(y,BLACK);
                   setColor(parentOf(x),BLACK);
                   setColor(parentOf(parentOf(x)),RED);
                   x = parentOf(x);
               }else {
                   if (x == leftOf(parentOf(x))){
                       x = parentOf(x);
                       rightRotation(x);
                   }
                   setColor(parentOf(x),BLACK);
                   setColor(parentOf(parentOf(x)),RED);
                   leftRotation(parentOf(parentOf(x)));
               }
           }
        }

        setColor(root,BLACK);
    }


    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        System.out.println();
    }
}
