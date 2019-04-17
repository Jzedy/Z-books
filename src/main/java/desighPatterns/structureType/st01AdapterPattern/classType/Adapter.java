package desighPatterns.structureType.st01AdapterPattern.classType;

public class Adapter extends Adaptee implements Target {
    @Override
    public void method() {
        specialMethod();
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method();
    }
}
