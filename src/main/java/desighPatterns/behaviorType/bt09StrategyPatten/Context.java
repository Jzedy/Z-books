package desighPatterns.behaviorType.bt09StrategyPatten;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int operate(int a, int b){
        return strategy.operate(a,b);
    }
}
