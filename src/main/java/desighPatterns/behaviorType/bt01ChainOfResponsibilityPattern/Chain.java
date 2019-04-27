package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public abstract class Chain {

    protected String name;

    public Chain(String name) {
        this.name = name;
    }

    abstract boolean method(Request request);
}
