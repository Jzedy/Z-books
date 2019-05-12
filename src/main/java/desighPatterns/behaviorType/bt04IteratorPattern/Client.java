package desighPatterns.behaviorType.bt04IteratorPattern;

/**
 *迭代器模式：
 *  优点：
 *      1）支持以不同的方式遍历一个聚合对象，在同一个聚合对象上可以定义多种遍历方式
 *      2）迭代器简化了聚合类
 *      3）在迭代器模式中，由于引入了抽象层，增加新的聚合类和迭代器都很方便，无需修改原有代码，符合‘开闭原则’
 *  缺点：
 *      1）由于迭代器模式将存储数据和遍历数据分离，增加新的聚合类需要对应的增加新的迭代器，类的个数成对增加，在一定的程度上增加了系统的复杂性
 *      2）抽象迭代器的设计难度较大，需要充分考虑系统将来的扩展性
 * @author Jzedy
 * @time 19-5-12
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Container<Integer> container = new ConcreteContainer<>();
        container.add(1);
        container.add(3);
        container.add(2);
        Iterator iterator = container.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
