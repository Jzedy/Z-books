package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public  class ChainHandle {
    private List<Chain> chains = new ArrayList<>();

    public ChainHandle addChain(Chain chain){
        this.chains.add(chain);
        return this;
    }

    public void doHandle(Request request){
        for (Chain chain : chains) {
            if (chain.method(request)){
                break;
            }
        }
    }
}
