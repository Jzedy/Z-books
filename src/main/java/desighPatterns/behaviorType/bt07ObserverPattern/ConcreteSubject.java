package desighPatterns.behaviorType.bt07ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-21
 * @description
 */
public class ConcreteSubject implements Subject {

    private List<Observer> lists = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        lists.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        lists.remove(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer list : lists) {
            list.update(msg);
        }
    }
}
