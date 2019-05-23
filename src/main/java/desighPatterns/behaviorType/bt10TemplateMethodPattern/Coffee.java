package desighPatterns.behaviorType.bt10TemplateMethodPattern;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Coffee extends Drink {
    @Override
    public void add() {
        System.out.println("----add sugar------");
    }

    @Override
    public void after() {
        System.out.println("-----hot water-------");
    }

    @Override
    public boolean isAddAnother() {
        return true;
    }

    @Override
    public void before() {
        System.out.println("----研磨咖啡------");
    }
}
