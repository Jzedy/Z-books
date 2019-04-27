package desighPatterns.behaviorType.bt02CommondPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
