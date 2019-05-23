package desighPatterns.behaviorType.bt10TemplateMethodPattern;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public abstract class Drink {
    final void prepared(){
        before();
        if (isAddAnother()){
            add();
        }
        after();
    }

    public abstract void add();

    public abstract void after();

    public abstract boolean isAddAnother();

    public abstract void before();
}
