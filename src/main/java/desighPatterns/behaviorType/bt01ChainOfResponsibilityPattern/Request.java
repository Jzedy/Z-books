package desighPatterns.behaviorType.bt01ChainOfResponsibilityPattern;

/**
 * @author Jzedy
 * @time 19-4-27
 * @description
 */
public class Request {
    private int prise;

    private String name;

    public Request(int prise, String name) {
        this.prise = prise;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }
}
