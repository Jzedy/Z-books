package desighPatterns.behaviorType.bt03InterpreterPattern;

/**
 * @author Jzedy
 * @time 19-5-6
 * @description
 */
public abstract class NonTerminalNode implements Node {
    protected Node left;
    protected Node right;

    public NonTerminalNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}
