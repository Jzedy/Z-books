package desighPatterns.behaviorType.bt05MediatorPattern;

/**
 * @author Jzedy
 * @time 19-5-13
 * @description
 */
public abstract class Colleague {
    protected String name;
    protected Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void out(String msg);
}
