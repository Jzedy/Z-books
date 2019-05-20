package desighPatterns.behaviorType.bt06MementoPattern.onceMemento;

/**
 * @author Jzedy
 * @time 19-5-20
 * @description
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}


