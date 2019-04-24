package desighPatterns.structureType.st06ProxyPattern.staticProxy;

/**
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("proxy pre....");
        subject.request();
        System.out.println("proxy post....");
    }
}
