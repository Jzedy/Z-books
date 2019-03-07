package tree.rbTree;

/**
 * @author Jzedy
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
        fixAfterAdd(e);
        return true;
    }

    private void fixAfterAdd(Node<T> x) {
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

    public boolean remove(T key){
        if (root == null){
            return false;
        }else {
            Node<T> current = root;
            int cmp;
            do {
                cmp = key.compareTo(current.key);
                if (cmp < 0){
                    current = current.left;
                }else if (cmp > 0){
                    current = current.right;
                }else break;
            }while (current != null);

            if (current == null){//未找到对应的节点
                return false;
            }else {
                if (leftOf(current) != null && rightOf(current) != null){//当前删除节点左/右子节点不为空
                    Node<T> s = successor(current);//获取当前删除节点的后继节点
                    current.key = s.key;//后继节点的值赋给当前删除节点
                    current = s;//当前删除节点指向后继节点
                }

                /**
                 * 若开始的删除节点左右子节点都不为空，现在的删除节点指向了后继节点
                 * 若开始的删除节点左/右节点至少有一个为空，现在的删除节点未做改变
                 * 下面的replace节点为当前删除节点的左子节点或右子节点
                 */
                Node<T> replace = leftOf(current) != null ? leftOf(current) : rightOf(current);

                if (replace != null){
                    replace.parent = current.parent;
                    if (parentOf(current) == null){//删除节点是根节点，且根节点只有一个子节点
                        root = replace;//将根节点指向原来根节点的那个子节点
                    }else if (current == leftOf(parentOf(current))){//当前删除节点是父节点的左子节点
                        current.parent.left = replace;
                    }else {
                        current.parent.right = replace;
                    }

                    current.left = current.right = current.parent = null;
                    if (colorOf(current) == BLACK){
                        fixAfterRemove(replace);
                    }

                }else if (current.parent == null){//删除节点为根节点 且没有子节点
                    root = null;
                }else {//删除节点没有子节点，但是不为根节点
                    if (current.color == BLACK){
                        fixAfterRemove(current);
                    }

                    if (current.parent != null){
                        if ( current == parentOf(current).left){
                            parentOf(current).left = null;
                        }else {
                            parentOf(current).right = null;
                        }
                        current.parent = null;
                    }
                }


            }
        }
        return true;
    }

    private void fixAfterRemove(Node<T> node) {

    }

    private Node<T> successor(Node<T> node) {
        Node<T> result = rightOf(node);
        while (result != null && leftOf(result) != null){
            result = leftOf(result);
        }
        return result;
    }


    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        System.out.println();
    }
}
