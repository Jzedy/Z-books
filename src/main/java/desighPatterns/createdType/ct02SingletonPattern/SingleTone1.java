package desighPatterns.createdType.ct02SingletonPattern;

/**
 *
 * 懒汗式单例模式
 * 单线程时候成立，多线程不符合
 * @author Jzedy
 * @time 19-3-31
 * @description
 */
public class SingleTone1 {

    private static  SingleTone1 singleTone1;

    private SingleTone1() {
    }

    public static SingleTone1 singletone(){
        if (singleTone1 == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleTone1 = new SingleTone1();
        }
        return singleTone1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingleTone1 singletone = SingleTone1.singletone();
                System.out.println(singletone);
            }).start();
        }
    }
}
