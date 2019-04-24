package desighPatterns.structureType.st06ProxyPattern.dynamicProxy;

import desighPatterns.structureType.st06ProxyPattern.staticProxy.Subject;

import java.lang.reflect.Proxy;

/**
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class TargetProxy  {
    private Subject target;

    public TargetProxy(Subject target) {
        this.target = target;
    }

    public Subject targetProxy(){
        return (Subject) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("proxy before...");
                    Object result = method.invoke(target,args);
                    System.out.println("proxy post ...");
                    return result;
                });
    }
}
