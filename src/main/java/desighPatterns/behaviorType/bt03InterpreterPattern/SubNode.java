package desighPatterns.behaviorType.bt03InterpreterPattern;

/**
 * @author Jzedy
 * @time 19-5-6
 * @description
 */
public class SubNode extends NonTerminalNode {
    public SubNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret()-right.interpret();
    }
}
