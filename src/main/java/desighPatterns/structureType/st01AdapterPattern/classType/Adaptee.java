package desighPatterns.structureType.st01AdapterPattern.classType;

public class Adaptee {

    /**
     * 特殊的方法，表明是已经存在的方法，等待适配
     */
    public void specialMethod(){
        System.out.println("adaptee method");
    }
}
