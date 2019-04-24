package desighPatterns.structureType.st06ProxyPattern.staticProxy;

/**
 *静态代理：
 *  优点：
 *      在不修改目标对象的功能前提下，对目标功能拓展
 *  缺点：
 *      1）因为代理对象与目标对象实现一样的接口，所有会有许多代理类，一旦接口增加方法，目标对象和代理对象都要维护
 *
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Subject subject  = new Proxy(new RealSubject());
        subject.request();
    }
}
