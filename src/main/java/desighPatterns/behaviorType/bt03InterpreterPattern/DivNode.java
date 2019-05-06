package desighPatterns.behaviorType.bt03InterpreterPattern;

/**
 * @author Jzedy
 * @time 19-5-6
 * @description
 */
public class DivNode extends NonTerminalNode {
    public DivNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret()/right.interpret();
    }
}
