package desighPatterns.structureType.st04DecoratorPattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
