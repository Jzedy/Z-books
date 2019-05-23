package desighPatterns.behaviorType.bt08StatePattern.impl;

import desighPatterns.behaviorType.bt08StatePattern.ThreadState;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class StartState implements ThreadState {
    @Override
    public void handle() {
        System.out.println("----start---");
    }
}
