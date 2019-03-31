package desighPatterns.createdType.ct02SingletonPattern;

/**
 *
 * 饿汗式单例模式
 * @author Jzedy
 * @time 19-3-31
 * @description
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){}

    public static Singleton2 singleton(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()-> System.out.println(Singleton2.singleton())).start();

        }
    }
}
