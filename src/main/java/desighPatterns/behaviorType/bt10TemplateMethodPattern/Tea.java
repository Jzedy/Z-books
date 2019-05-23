package desighPatterns.behaviorType.bt10TemplateMethodPattern;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Tea extends Drink {
    @Override
    public void add() {

    }

    @Override
    public void after() {
        System.out.println("-------hot water-----");
    }

    @Override
    public boolean isAddAnother() {
        return false;
    }

    @Override
    public void before() {
        System.out.println("------get tea--------");
    }
}
