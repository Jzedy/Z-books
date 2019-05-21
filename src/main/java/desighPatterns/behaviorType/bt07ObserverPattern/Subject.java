package desighPatterns.behaviorType.bt07ObserverPattern;

/**
 * @author Jzedy
 * @time 19-5-21
 * @description
 */
public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver(String msg);
}
