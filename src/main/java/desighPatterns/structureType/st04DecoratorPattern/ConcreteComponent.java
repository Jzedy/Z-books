package desighPatterns.structureType.st04DecoratorPattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("具体的方法");
    }
}
