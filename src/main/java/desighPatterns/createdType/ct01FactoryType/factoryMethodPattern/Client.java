package desighPatterns.createdType.ct01FactoryType.factoryMethodPattern;

/**
 * @author Jzedy
 * @time 19-3-30
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new BenZFactory();
        Car car = factory.create();
        car.dispaly();
    }
}
