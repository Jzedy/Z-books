package desighPatterns.behaviorType.bt11VistorPattern;

import desighPatterns.behaviorType.bt11VistorPattern.impl.Boss;
import desighPatterns.behaviorType.bt11VistorPattern.impl.CPA;
import desighPatterns.behaviorType.bt11VistorPattern.impl.ConsumeBill;
import desighPatterns.behaviorType.bt11VistorPattern.impl.IncomeBill;

/**
 *
 * 访问者模式：
 *  优点：
 *      1）增加新的访问操作很方便。
 *      2）将有关元素对象的访问行为集中到一个访问者对象中，而不是分散在一个个的元素类中
 *      3）让用户能够在不修改现有元素层次结构的情况下，定义作用于该层次结构的操作。
 *  缺点：
 *      1）增加新的元素很困难。
 *      2）破坏封装
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Client {
    public static void main(String[] args) {
        AccountBook book = new AccountBook();
        book.addBill(new ConsumeBill("工资",1200));
        book.addBill(new ConsumeBill("物业",500));
        book.addBill(new IncomeBill("卖商品",1500));
        Boss boss = new Boss();
        book.show(boss);
        book.show(new CPA());

        boss.consumeTotal();
        boss.incomeTotal();
    }
}
