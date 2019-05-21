package desighPatterns.behaviorType.bt07ObserverPattern;

/**
 * @author Jzedy
 * @time 19-5-21
 * @description
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name+"---->接收到消息:"+msg);
    }
}
