package desighPatterns.createdType.ct01FactoryType.factoryMethodPattern;

/**
 * @author Jzedy
 * @time 19-3-30
 * @description
 */
public class BenZFactory implements Factory {
    @Override
    public Car create() {
        return new BenZ();
    }
}
