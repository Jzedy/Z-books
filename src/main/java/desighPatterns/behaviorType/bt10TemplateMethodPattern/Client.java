package desighPatterns.behaviorType.bt10TemplateMethodPattern;

/**
 * 模板方法模式：
 *  优点：
 *      1）父类定义一个算法，而由它的子类来实现细节的处理，在子类实现详细的处理算法时不影响算法中步骤的执行顺序
 *      2）模板方法模式是一种代码复用技术，它在类库设计中尤为重要,它提取了类库中的公共行
 *          为,将公共行为放在父类中,而通过其子类来实现不同的行为,它鼓励我们恰当使用继承来
 *          实现代码复用。
 *      3）可实现一种反向控制，通过覆盖父类的钩子方法，决定某一特定步骤是否需要执行
 *      4）模板方法模式通过子类覆盖父类的基本方法，不同的子类可以提供基本方法的不同实现，符合单一职责原则和开闭原则
 *  缺点：
 *      需要为每一个基本方法的不同实现提供一个子类，如果父类中的可变基本方法太多，导致类的个数增加，系统更加庞大，设计也更加抽象，此时，可以用桥接模式进行设计
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--->prepared ted");
        new Tea().prepared();
        System.out.println("--->prepared coffee");
        new Coffee().prepared();
    }
}
