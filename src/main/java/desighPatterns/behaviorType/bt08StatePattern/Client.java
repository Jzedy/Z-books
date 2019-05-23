package desighPatterns.behaviorType.bt08StatePattern;

/**
 *  状态模式：
 *      优点：
 *          1）封装了状态的转换规则，在状态模式中可以将状态的转换封装在环境类或者具体状态类中，可以对状态转换进行集中处理，而不是分散在一个个业方法中。
 *          2）将所有与某个状态有关的行为放到一个类中，只需要注入一个不同的状态对象即可使环境对象佣有不同的行为。
 *          3）允许状态转换逻辑与状态对象合成一体，而不是提供一个巨大的条件语句块，状态模式可以让我们避免使用庞大的条件语句来将业务方法和状态转换代码交织在一起
 *          4）可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数
 *      缺点：
 *          1）状态模式的使用必然会增加系统中类的个数，导致系统运行开销增大
 *          2）状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱，增加系统设计的难度
 *          3）状态模式对‘开闭原则’的支持并不太好，增加新的状态需要修改负责状态的源代码，否则无法转换到新增状态；而且修改某个状态类的行为也需要修改对应类的源代码
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.start();
        context.threadWait();
        context.threadWait(1000);
        context.failCpu();
        context.getCpu();
        context.end();
    }
}
