package desighPatterns.behaviorType.bt11VistorPattern;

import desighPatterns.behaviorType.bt11VistorPattern.impl.ConsumeBill;
import desighPatterns.behaviorType.bt11VistorPattern.impl.IncomeBill;

/**
 * @author Jzedy
 * @time 19-5-23
 * @description
 */
public interface Viewer {
    void visit(IncomeBill incomeBill);
    void visit(ConsumeBill consumeBill);

}
