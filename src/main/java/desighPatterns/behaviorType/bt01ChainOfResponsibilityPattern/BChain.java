package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class BChain extends Chain {
    public BChain(String name) {
        super(name);
    }

    @Override
    boolean method(Request request) {
        if (request.getPrise() >= 5000 && request.getPrise() < 10000){
            System.out.println(this.name+" resolve,for "+request.getName());
            return true;
        }
        return false;
    }
}
