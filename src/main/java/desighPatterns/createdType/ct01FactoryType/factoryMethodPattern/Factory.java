package desighPatterns.createdType.ct01FactoryType.factoryMethodPattern;

/**
 * 工厂方法模式
 * @author Jzedy
 * @time 19-3-30
 * @description
 *优点：
 *  1）对客户端隐藏具体实现细节
 *  2）工厂角色和产品角色多样性
 *  3）系统加入新产品时候，无需修改抽象工厂和抽象产品的接口，只需要添加具体工厂和具体产品就可以了
 *缺点：
 * 1）添加新产品时候，需要添加新的具体产品类，还需要添加具体的工厂类。系统类个数成对增加，一定程度上增加了类的复杂性
 * 2）考录到系统的可拓展性，客户端中均使用抽象层定义，增加了系统的抽象性和理解难度，且在实现时候可能需要使用DOM、反射技术，增加了系统的实现难度
 *
 */
public interface Factory {
    Car create();
}
