package desighPatterns.behaviorType.bt03InterpreterPattern;

/**
 * @author Jzedy
 * @time 19-5-6
 * @description
 */
public class MulNode extends NonTerminalNode {
    public MulNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret()*right.interpret();
    }
}
