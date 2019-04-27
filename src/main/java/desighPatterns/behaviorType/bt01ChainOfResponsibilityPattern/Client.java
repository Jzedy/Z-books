package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

/**
 *
 * 责任链模式：
 *      优点：
 *          1）使对象无须知道是其他哪一个对象处理请求，对象只需要知道请求会被处理，降低系统的耦合度
 *          2）动态的添加或删除责任对象
 *      缺点：
 *          1）对于比较长的责任链，请求处理涉及多个处理对象，系统性能有一定影响
 *          2）如果出错，不容易排错
 *          3）如果建链不当，可能造成循环引用，导致死循环
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class Client {
    public static void main(String[] args) {
        ChainHandle handle = new ChainHandle()
                .addChain(new AChain("a"))
                .addChain(new BChain("b"))
                .addChain(new CChain("c"));

        Request request1 = new Request(3000, "购物1");
        Request request2 = new Request(6000, "购物2");
        Request request3 = new Request(12000, "购物3");
        handle.doHandle(request1);
        handle.doHandle(request2);
        handle.doHandle(request3);
    }
}
