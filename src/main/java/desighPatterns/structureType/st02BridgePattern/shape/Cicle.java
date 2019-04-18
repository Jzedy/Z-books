package desighPatterns.structureType.st02BridgePattern.shape;

import desighPatterns.structureType.st02BridgePattern.color.Color;

/**
 * @author Jzedy
 * @time 19-4-18
 * @description
 */
public class Cicle extends Shape {
    public Cicle(Color color) {
        super(color);
    }

    @Override
    public void opreration() {
        System.out.println("Cicle with"+color.getColor());
    }
}
