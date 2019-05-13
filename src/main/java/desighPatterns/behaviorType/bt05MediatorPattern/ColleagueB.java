package desighPatterns.behaviorType.bt05MediatorPattern;

/**
 * @author Jzedy
 * @time 19-5-13
 * @description
 */
public class ColleagueB extends Colleague {
    public ColleagueB(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void out(String msg) {
        super.mediator.connect(msg,this);
    }

    public void selfB(String msg){
        System.out.println("B received msg:"+msg);
    }
}
