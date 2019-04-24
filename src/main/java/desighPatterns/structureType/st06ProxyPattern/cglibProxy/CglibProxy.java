package desighPatterns.structureType.st06ProxyPattern.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Jzedy
 * @time 19-4-24
 * @description
 */
public class CglibProxy implements MethodInterceptor {

    private Target target;

    public CglibProxy(Target target) {
        this.target = target;
    }

    public Target proxyInstance(){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (Target) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy before...");
        Object invoke = method.invoke(target, args);
        System.out.println("cglib proxy post...");
        return invoke;
    }
}
