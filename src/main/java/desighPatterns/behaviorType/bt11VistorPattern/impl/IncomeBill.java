package desighPatterns.behaviorType.bt11VistorPattern.impl;

import desighPatterns.behaviorType.bt11VistorPattern.Bill;
import desighPatterns.behaviorType.bt11VistorPattern.Viewer;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class IncomeBill implements Bill {

    private String item;
    private long amount;

    public IncomeBill(String item, long amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public void accept(Viewer viewer) {
        viewer.visit(this);
    }
}
