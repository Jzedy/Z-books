package desighPatterns.createdType.ct01FactoryType.simpleFactory;

/**
 * 简单工厂模式
 * @author Jzedy
 * @time 19-3-30
 * @description 根据传入的不同参数创建不同的产品，
 *
 * 优点：
 *  1）客户端只需要指定不同的参数就可以获取不同的对象
 *  2）工厂类包含了具体创建不同对象的逻辑，客户端免除了直接创建对象的职责，实现了客户端创建和使用对象的隔离
 *  3）使用配置文件，可以在不修改客户端源码的情况下更换和增加新的产品类，在一定的程度上提高了系统的灵活性
 * 缺点：
 *  1）工厂类职责过重，一旦不能工作，整个系统受到影响
 *  2）增加了系统类的个数，增加了系统的复杂
 *  3）系统拓展苦难，一旦添加新的产品，都需要修改工厂类，可能造成过于复杂，不便于维护
 *  4）简单工厂模式使用静态工厂方法，造成工厂角色无法形成继承的等级结构
 */
public class ProductFactory {

    public static Product create(int type){
        Product result = null;
        if (type == 0){
            result = new ProductA();
        }if (type == 1){
            result = new ProductB();
        }
        return result;
    }
}
