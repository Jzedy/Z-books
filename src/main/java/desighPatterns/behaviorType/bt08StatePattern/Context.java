package desighPatterns.behaviorType.bt08StatePattern;

import desighPatterns.behaviorType.bt08StatePattern.impl.*;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public class Context {
    private ThreadState state;

    public Context() {
        this.state = new StartState();
        state.handle();
    }

    public void start(){
        state = new RunnableState();
        state.handle();
    }

    public void threadWait(){
        state = new WaitState();
        state.handle();
    }

    public void threadWait(long time){
        state = new TimeWaitState();
        state.handle();
    }

    public void getCpu(){
        state = new RunningState();
        state.handle();
    }

    public void failCpu(){
        state = new BlokedState();
        state.handle();
    }

    public void end(){
        state = new EndState();
        state.handle();
    }
}
