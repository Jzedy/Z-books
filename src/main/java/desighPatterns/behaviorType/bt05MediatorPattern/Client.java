package desighPatterns.behaviorType.bt05MediatorPattern;

/**
 *
 * 中介者模式：
 *  优点：
 *      1）简化了对象之间的交互，它用中介者和同事的一对多代替原来同事之间的多对多交互，一对多关系更容易理解、维护和拓展，将原本难以理解的网状结构变为星状结构
 *      2）中介者将各同事对象接偶
 *  缺点：
 *      具体中介者包含了大量同事之间的交互，可能导致具体中介者非常复杂，使得系统难以维护
 * @author Jzedy
 * @time 19-5-13
 * @description
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ColleagueA colleagueA = new ColleagueA("A",mediator);
        ColleagueB colleagueB = new ColleagueB("B",mediator);
        mediator.setColleagueA(colleagueA);
        mediator.setColleagueB(colleagueB);

        colleagueA.out("hi");
        colleagueB.out("hello");
    }
}
