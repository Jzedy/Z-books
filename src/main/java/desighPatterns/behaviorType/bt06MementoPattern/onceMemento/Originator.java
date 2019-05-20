package desighPatterns.behaviorType.bt06MementoPattern.onceMemento;

/**
 * @author Jzedy
 * @time 19-5-20
 * @description
 */
public class Originator {
    //需要保存的状态
    private String state;

    public Memento loadMemento(){
        return new Memento(state);
    }

    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
