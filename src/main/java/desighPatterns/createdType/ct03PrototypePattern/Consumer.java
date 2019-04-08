package desighPatterns.createdType.ct03PrototypePattern;

/**
 *
 * 原型模式：
 *  优点：
 *      1）当创建新的对象实例较为复杂时，使用原型模式可以简化对象的创建过程，通过复制一个
 * 已有实例可以提高新实例的创建效率。
 *      2）扩展性较好，由于在原型模式中提供了抽象原型类，在客户端可以针对抽象原型类进行编
 * 程，而将具体原型类写在配置文件中，增加或减少产品类对原有系统都没有任何影响
 *      3）原型模式提供了简化的创建结构，工厂方法模式常常需要有一个与产品类等级结构相同的
 * 工厂等级结构，而原型模式就不需要这样，原型模式中产品的复制是通过封装在原型类中的
 * 克隆方法实现的，无须专门的工厂类来创建产品。
 *      4）可以使用深克隆的方式保存对象的状态，使用原型模式将对象复制一份并将其状态保存起
 * 来，以便在需要的时候使用（如恢复到某一历史状态），可辅助实现撤销操作。
 *  缺点：
 *      1）需要为每一个类配备一个克隆方法，而且该克隆方法位于一个类的内部，当对已有的类进
 * 行改造时，需要修改源代码，违背了“开闭原则”
 *      2）在实现深克隆时需要编写较为复杂的代码，而且当对象之间存在多重的嵌套引用时，为了
 * 实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来可能会比较麻烦
 * @author Jzedy
 * @time 2019/4/8 20:11
 * @description
 */
public class Consumer implements Cloneable{
    private String name;
    private int age;

    public Consumer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Consumer clone() throws CloneNotSupportedException {
        return (Consumer) super.clone();
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Consumer consumer = new Consumer("jzedy", 25);
        Consumer consumerClone= consumer.clone();
        System.out.println(consumerClone.toString());
        System.out.println(consumer.equals(consumerClone));
    }

}
