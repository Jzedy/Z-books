package desighPatterns.behaviorType.bt08StatePattern.impl;

import desighPatterns.behaviorType.bt08StatePattern.ThreadState;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class RunningState implements ThreadState {
    @Override
    public void handle() {
        System.out.println("--------running----");
    }
}
