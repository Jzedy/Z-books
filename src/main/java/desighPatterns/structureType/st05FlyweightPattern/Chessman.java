package desighPatterns.structureType.st05FlyweightPattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public abstract class Chessman {
    protected abstract String getColor();

    public void display(){
        System.out.println("color-->"+getColor());
    }
}
