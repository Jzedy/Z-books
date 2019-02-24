package treeStart;

import org.junit.Test;

/**
 * @author Jzedy
 * @time 2019/1/26 18:52
 * @description
 */
public class TreeTest {
    @Test
    public void test1(){
        Tree tree = new BinaryTree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        Node node = tree.find(3);
//        node.display();
        tree.inOrder(tree.find(2));
        System.out.println();
        tree.preOrder(tree.find(2));
        System.out.println();
        tree.postOrder(tree.find(2));
        System.out.println();

//        System.out.println(tree.findMax().getData());
//        System.out.println(tree.findMin().getData());
    }

    @Test
    public void test2(){
        Tree tree = new BinaryTree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        System.out.println(tree.delete(2));
        tree.inOrder(tree.find(3));
        System.out.println();
        System.out.println(tree.findMin().getData());
        System.out.println(tree.findMax().getData());
    }
}
