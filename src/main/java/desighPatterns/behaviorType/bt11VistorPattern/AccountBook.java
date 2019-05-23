package desighPatterns.behaviorType.bt11VistorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class AccountBook {
    private List<Bill> bills = new ArrayList<>();

    public void addBill(Bill bill){
        bills.add(bill);
    }

    public void show(Viewer viewer){
        for (Bill bill : bills) {
            bill.accept(viewer);
        }
    }
}
