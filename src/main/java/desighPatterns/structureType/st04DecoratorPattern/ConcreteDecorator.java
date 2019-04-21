package desighPatterns.structureType.st04DecoratorPattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        decoratorMethod();
    }

    private void decoratorMethod(){
        System.out.println("具体的修饰方法");
    }
}
