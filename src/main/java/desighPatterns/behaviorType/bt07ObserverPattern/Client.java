package desighPatterns.behaviorType.bt07ObserverPattern;

/**
 * 观察者模式：
 *  优点：
 *      1）观察者模式可以实现表现层和数据逻辑层的分离，定义了稳定的消息更新传递机制，并抽象了更新接口，使得可以有各种不同的表现层充当具体观察者角色
 *      2）观察者模式在观察目标和观察者之间建立一个抽象的耦合。观察目标和观察者没有紧密的联系在一起
 *      3）观察者模式支持广播模式，简化了一对多系统设计的难度
 *  缺点：
 *      1）如果一个观察目标有很多个观察者，将所有观察者都通知会花费很多时间
 *      2）如果观察目标和观察者存在循环依赖，可能导致系统崩溃
 *      3）观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的,而仅仅只
 * 是知道观察目标发生了变化
 * @author Jzedy
 * @time 19-5-21
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("jzedy");
        Observer observer2 = new ConcreteObserver("zoe");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.notifyObserver("msg1");
        System.out.println("-----------------");
        subject.detach(observer2);

        subject.notifyObserver("msg2");


    }
}
