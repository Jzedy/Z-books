package treeStart;

/**
 * @author Jzedy
 * @time 2019/1/26 18:15
 * @description
 */
public class BinaryTree implements Tree {

    private Node root;


    @Override
    public Node find(int key) {
        Node current = root;
        if (current == null) return null;
        while (current != null){
            if (current.getData()>key){
                current = current.getLeftChild();
            }else if (current.getData() < key){
                current =  current.getRightChild();
            }else return current;
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null){
            root = newNode;
            return true;
        }else {
            Node current = root;
            Node parentNode = null;
            while (current != null){
                parentNode = current;
                if (current.getData() > data){
                    current = current.getLeftChild();
                    if (current == null){
                        parentNode.setLeftChild(newNode);
                        return true;
                    }
                }else {
                    current = current.getRightChild();
                    if (current == null){
                        parentNode.setRightChild(newNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(int key) {
        if (root == null) return false;//树为空，返回false
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;//用于判断需要删除的节点是其父节点的左/右子节点
        while (current.getData() != key){
            parent = current;
            if (key > current.getData()){
                isLeftChild = false;
                current = current.getRightChild();
            }else {
                isLeftChild = true;
                current = current.getLeftChild();
            }
            if (current == null)return false;//未找到，返回false
        }
        if (current.getRightChild() == null &&
            current.getLeftChild() == null){//需要删除的节点不包含子节点

            if (current == root){
                root = null;
            }else if (isLeftChild){
                parent.setLeftChild(null);
            }else parent.setRightChild(null);

        }else if (current.getRightChild() == null &&
                  current.getLeftChild() != null){//需要删除的节点包含一个节点，且为左节点

            if (current == root){
                root = current.getLeftChild();
            }else if (isLeftChild){
                parent.setLeftChild(current.getLeftChild());
            }else parent.setRightChild(current.getLeftChild());

        }else if (current.getRightChild() != null &&
                  current.getLeftChild() == null){//需要删除的节点包含一个节点，且为右节点

            if (current == root){
                root = current.getRightChild();
            }else if (isLeftChild){
                parent.setLeftChild(current.getRightChild());
            }else {
                parent.setRightChild(current.getRightChild());
            }

        }else {//需要删除的节点包含两个节点
            Node successor = geSuccessor(current);//获得后继节点
            if (current == root){
                root = successor;
            }else if (isLeftChild){
                parent.setLeftChild(successor);
            }else parent.setRightChild(successor);
            successor.setLeftChild(current.getLeftChild());
        }

        return true;
    }

    private Node geSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != delNode.getRightChild()){//后继节点不是需要删除节点的右节点,调整结构
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    @Override
    public void inOrder(Node current) {
        if (current != null){
            inOrder(current.getLeftChild());
            System.out.print(current.getData());
            inOrder(current.getRightChild());
        }
    }

    @Override
    public void preOrder(Node current) {
        if (current!= null){
            System.out.print(current.getData());
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    @Override
    public void postOrder(Node current) {
        if (current!= null){
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.print(current.getData());
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = root;
        while (current != null){
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = root;
        while (current != null){
            minNode = current;
            current = current.getLeftChild();
        }
        return minNode;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node node){
        if (node == null){
            return 0;
        }else return Math.max(height(node.getLeftChild()),height(node.getRightChild()))+1;
    }


}
