package desighPatterns.createdType.ct01FactoryType.simpleFactory;

/**
 * @author Jzedy
 * @time 19-3-30
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Product product = ProductFactory.create(1);
        product.display();
    }
}
