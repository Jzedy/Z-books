package desighPatterns.behaviorType.bt02CommondPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
