package treeStart;

/**
 * @author Jzedy
 * @time 2019/1/26 18:12
 * @description
 */
public interface Tree {
    /**
     * 查找节点
     * @param data
     * @return
     */
    Node find(int data);

    /**
     * 插入节点
     * @param data
     * @return
     */
    boolean insert(int data);

    /**
     * 删除节点
     * @param key
     * @return
     */
    boolean delete(int key);

    /**
     * 中序遍历  左子树-》根节点-》右子树
     * @param current
     */
    void inOrder(Node current);

    /**
     * 前序遍历：根节点-》左子树-》右子树
     * @param current
     */
    void preOrder(Node current);

    /**
     * 后序遍历：左子树-》右子树-》根节点
     * @param current
     */
    void postOrder(Node current);

    /**
     * 查找最大值节点
     * @return
     */
    Node findMax();

    /**
     * 查找最小值节点
     * @return
     */
    Node findMin();
}
