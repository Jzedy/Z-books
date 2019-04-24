package desighPatterns.structureType.st06ProxyPattern.cglibProxy;

/**
 *
 * cglib代理
 *  需引入jar包
 *  优点：
 *      目标不需要实现接口
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Target target = new CglibProxy(new Target()).proxyInstance();
        target.method();
    }
}
