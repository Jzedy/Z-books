package desighPatterns.behaviorType.bt11VistorPattern.impl;

import desighPatterns.behaviorType.bt11VistorPattern.Viewer;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Boss implements Viewer {

    private long incomeTotal;
    private long consumeTotal;

    @Override
    public void visit(IncomeBill incomeBill) {
        incomeTotal+=incomeBill.getAmount();
    }

    @Override
    public void visit(ConsumeBill consumeBill) {
        consumeTotal += consumeBill.getAmount();
    }

    public void incomeTotal(){
        System.out.println("boss查看一共收入："+incomeTotal);
    }

    public void consumeTotal(){
        System.out.println("boss查看一共支出："+consumeTotal);
    }
}
