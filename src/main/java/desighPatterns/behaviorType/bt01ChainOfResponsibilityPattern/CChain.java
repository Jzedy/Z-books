package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class CChain extends Chain {
    public CChain(String name) {
        super(name);
    }

    @Override
    boolean method(Request request) {
        System.out.println(this.name +" resolve ,for "+ request.getName());
        return false;
    }
}
