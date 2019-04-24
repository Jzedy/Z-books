package desighPatterns.structureType.st06ProxyPattern.staticProxy;

/**
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("request....");
    }
}
