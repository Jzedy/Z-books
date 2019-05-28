package producerAndConsumer.v1Wait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-28
 * @description
 */
public class Client {

    public static void main(String[] args) {
        List<String > repo = new ArrayList<>();
        new Thread(new Producer(repo,10),"producer1").start();
        new Thread(new Producer(repo,10),"producer2").start();
        new Thread(new Producer(repo,10),"producer3").start();
        new Thread(new Consumer(repo),"consumer1").start();
        new Thread(new Consumer(repo),"consumer2").start();
        new Thread(new Consumer(repo),"consumer3").start();
    }
}
