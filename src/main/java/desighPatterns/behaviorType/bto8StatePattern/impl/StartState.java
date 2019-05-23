package desighPatterns.behaviorType.bto8StatePattern.impl;

import desighPatterns.behaviorType.bto8StatePattern.ThreadState;

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
