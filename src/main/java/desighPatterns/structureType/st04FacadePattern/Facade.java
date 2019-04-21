package desighPatterns.structureType.st04FacadePattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;

    public Facade() {
        systemA = new SystemA();
        systemB = new SystemB();
    }

    public void method(){
        systemA.methodA();
        systemB.methodB();
    }
}
