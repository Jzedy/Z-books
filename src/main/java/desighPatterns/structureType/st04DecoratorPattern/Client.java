package desighPatterns.structureType.st04DecoratorPattern;

/**
 *装饰器模式：
 *  优点：
 *      1）对于拓展一个对象的功能，装饰器模式比继承更加灵活，不会导致类的个数急剧增加
 *      2）可以通过一种动态的方式来拓展一个对象的功能
 *      3）对于一个对象可以进行多次修饰，通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造很多不同行为的组合，得到功能更加强大的对象
 *      4）具体构件类和具体装饰类可以独立变化，用户可以根据需要增加新的具体类和修饰类，原有的代码无需改变，符合‘开闭原则’
 *  缺点：
 *      1）使用装饰器模式构建系统时候将产生很多小对象，在一定程度上影响程序的性能
 *      2）装饰器模式提供了一种比继承更加灵活机动的解决方案，但同时也意味着比继承更加易于出错，排错也很困难
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator(new ConcreteComponent());
        component.operation();
    }
}
