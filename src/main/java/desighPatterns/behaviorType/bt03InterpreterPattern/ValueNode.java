package desighPatterns.behaviorType.bt03InterpreterPattern;

/**
 * @author Jzedy
 * @time 19-5-6
 * @description
 */
public class ValueNode implements Node {

    private int value;

    public ValueNode(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
