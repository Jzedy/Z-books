package desighPatterns.behaviorType.bt05MediatorPattern;

/**
 * @author Jzedy
 * @time 19-5-13
 * @description
 */
public class ColleagueA extends Colleague {
    public ColleagueA(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void out(String msg) {
        super.mediator.connect(msg,this);
    }

    public void selfA(String msg){
        System.out.println("A--->receive msg:"+msg);
    }
}
