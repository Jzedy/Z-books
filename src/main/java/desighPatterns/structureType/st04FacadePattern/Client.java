package desighPatterns.structureType.st04FacadePattern;

/**
 *外观模式：
 *  优点：
 *      1）它对客户端屏蔽类子系统，减少类客户端所需处理的子系统处理的对象数目，并使得子系统使用起来更加容易
 *      2）实现了子系统和客户端之间的松耦合关系
 *      3）一个子系统的修改对其他子系统的修改没有影响，而且子系统内部变化也不会影响外观对象
 *  缺点：
 *      1）不能很好的限制客户端直接使用子系统类
 *      2）如果设计不当，增加新的子系统可能需要修改外观类的源代码，不符合‘开闭原则’
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
