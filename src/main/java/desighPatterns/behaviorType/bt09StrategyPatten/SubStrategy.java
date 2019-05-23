package desighPatterns.behaviorType.bt09StrategyPatten;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class SubStrategy implements Strategy {
    @Override
    public int operate(int a, int b) {
        return a-b;
    }
}
