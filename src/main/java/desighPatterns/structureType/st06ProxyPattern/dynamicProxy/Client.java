package desighPatterns.structureType.st06ProxyPattern.dynamicProxy;

import desighPatterns.structureType.st06ProxyPattern.staticProxy.RealSubject;
import desighPatterns.structureType.st06ProxyPattern.staticProxy.Subject;

/**
 * jdk动态代理
 *  缺点： 目标对象需要实现接口
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Object proxy = new TargetProxy(new RealSubject()).targetProxy();
        ((Subject) proxy ).request();
    }
}
