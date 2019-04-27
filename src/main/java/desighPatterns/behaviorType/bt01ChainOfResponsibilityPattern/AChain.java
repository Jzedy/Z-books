package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class AChain extends Chain {

    public AChain(String name) {
        super(name);
    }

    @Override
    public boolean method(Request request) {

        if (request.getPrise() < 5000){
            System.out.println(this.name+" resolve,for "+request.getName());
            return true;
        }

        return false;
    }
}
