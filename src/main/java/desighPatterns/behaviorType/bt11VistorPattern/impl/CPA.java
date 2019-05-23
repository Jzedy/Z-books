package desighPatterns.behaviorType.bt11VistorPattern.impl;

import desighPatterns.behaviorType.bt11VistorPattern.Viewer;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class CPA implements Viewer {
    @Override
    public void visit(IncomeBill incomeBill) {
        if ("工资".equals(incomeBill.getItem())){
            System.out.println("CPA 查看是否工资交税");
        }
    }

    @Override
    public void visit(ConsumeBill consumeBill) {
        System.out.println("CPA查看收入是否交税");
    }
}
