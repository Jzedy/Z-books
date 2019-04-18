package desighPatterns.structureType.st02BridgePattern.shape;

import desighPatterns.structureType.st02BridgePattern.color.Color;

/**
 * @author Jzedy
 * @time 19-4-18
 * @description
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void opreration();
}
