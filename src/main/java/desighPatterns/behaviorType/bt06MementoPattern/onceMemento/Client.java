package desighPatterns.behaviorType.bt06MementoPattern.onceMemento;

/**
 * 备忘录模式：
 *  优点：
 *      1）它提供了一种状态恢复的实现机制，使得用户可以方便地回到一个特定的历史步骤，当
 *      新的状态无效或者存在问题时，可以使用暂时存储起来的备忘录将状态复原
 *      2）备忘录实现了对信息的封装，一个备忘录对象是一种原发器对象状态的表示，不会被其他
 *      代码所改动。备忘录保存了原发器的状态，采用列表、堆栈等集合来存储备忘录对象可以实现多次
 *      撤销操作
 *  缺点：
 *      1）资源消耗过大，如果需要保存的原发器类的成员变量太多，就不可避免需要占用大量的存储
 *      空间，每保存一次对象的状态都需要消耗一定的系统资源
 * @author Jzedy
 * @time 19-5-20
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("状态一");
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.loadMemento());

        System.out.println("stage 1:-->"+originator.getState());

        originator.setState("状态二");

        System.out.println("stage 2:-->"+originator.getState());
        originator.restoreMemento(caretaker.getMemento());

        System.out.println("stage 3:-->"+originator.getState());

    }
}
