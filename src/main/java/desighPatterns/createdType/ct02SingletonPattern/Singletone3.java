package desighPatterns.createdType.ct02SingletonPattern;

/**
 * @author Jzedy
 * @time 19-3-31
 * @description
 */
public class Singletone3 {

    private static volatile Singletone3 singletone3;

    private Singletone3(){}

    public static Singletone3 singletone(){

        if (singletone3 == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          synchronized (Singletone3.class){
              if (singletone3 == null){
                  singletone3 = new Singletone3();
              }
          }
        }

        return singletone3;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()-> System.out.println(Singletone3.singletone())).start();
        }
    }
}
