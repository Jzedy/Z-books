package desighPatterns.createdType.ct02SingletonPattern;

/**
 * @author Jzedy
 * @time 19-3-31
 * @description
 */
public class Singletone4 {

    private Singletone4(){}

    private static class InnerClass{
        private static Singletone4 singletone4 = new Singletone4();
    }

    public static Singletone4 singleton(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return InnerClass.singletone4;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()-> System.out.println(Singletone4.singleton())).start();
        }
    }
}
