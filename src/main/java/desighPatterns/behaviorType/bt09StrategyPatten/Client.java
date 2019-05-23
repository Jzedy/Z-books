package desighPatterns.behaviorType.bt09StrategyPatten;

/**
 *
 * 策略模式：
 *      优点：
 *          1）提供了开闭原则的完美支持，用户可以在不修改原有系统的基础上选择算法或行为，也可以灵活的增加新的算法或行为
 *          2）提供了管理相关算法的算法族的办法
 *          3）提供了一种可以替换继承关系的方法
 *          4）避免多重条件选择语句
 *          5）提供了一种算法的复用机制
 *      缺点：
 *          1）客户端必须知道所有的策略类，并自行选择哪一个策略类
 *          2）策略模式使系统产生很多具体策略类
 *          3）无法同时在客户端使用多个策略类
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println(context.operate(3,5));
        context = new Context(new SubStrategy());
        System.out.println(context.operate(5,3));
    }
}
