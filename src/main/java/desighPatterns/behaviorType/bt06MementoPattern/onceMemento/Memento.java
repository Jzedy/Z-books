package desighPatterns.behaviorType.bt06MementoPattern.onceMemento;

/**
 * @author Jzedy
 * @time 19-5-20
 * @description
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
