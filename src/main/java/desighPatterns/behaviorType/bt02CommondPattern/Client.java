package desighPatterns.behaviorType.bt02CommondPattern;

/**
 * 命令模式：
 *      优点：
 *          1）降低系统的耦合度。实现请求者和接受者之间接偶
 *          2）新的命令很容易加入系统中
 *          3）为请求的撤销和恢复提供了一种设计和实现方案
 *      缺点：
 *          1）可能导致系统中有过多的具体命令类
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Light light = new Light();
        LightOffCommand offCommond = new LightOffCommand(light);
        LightOpenCommand openCommond = new LightOpenCommand(light);

        Invoker invoker = new Invoker();

        invoker.setCommand(openCommond);
        invoker.execute();

        invoker.setCommand(offCommond);
        invoker.execute();


    }
}
