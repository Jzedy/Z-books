package desighPatterns.behaviorType.bt05MediatorPattern;

/**
 * @author Jzedy
 * @time 19-5-13
 * @description
 */
public class ConcreteMediator implements Mediator {

    private ColleagueA colleagueA;

    private ColleagueB colleagueB;

    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void connect(String msg, Colleague colleague) {
        if (colleague.getName().equals(this.colleagueA.getName())){
            colleagueB.selfB(msg);
        }else if (colleague.getName().equals(colleagueB.getName())){
            colleagueA.selfA(msg);
        }
    }
}
