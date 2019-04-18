package desighPatterns.structureType.st02BridgePattern;

import desighPatterns.structureType.st02BridgePattern.color.Red;
import desighPatterns.structureType.st02BridgePattern.color.Yellow;
import desighPatterns.structureType.st02BridgePattern.shape.Cicle;

/**
 *桥接模式
 *  优点：
 *      1）分离抽象和实现部分
 *      2）多数情况下，桥接模式可以取代多层继承方案
 *      3）桥接模式提高了系统的可拓展性
 *  缺点：
 *      1）增加系统的理解和设计难度
 *      2）需要正确识别出系统中两个独立变化的维度
 *
 *
 * @author Jzedy
 * @time 19-4-18
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Cicle cicle = new Cicle(new Yellow());
        cicle.opreration();
        cicle = new Cicle(new Red());
        cicle.opreration();

    }
}
