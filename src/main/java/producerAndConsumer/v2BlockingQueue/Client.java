package producerAndConsumer.v2BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Jzedy
 * @time 19-5-29
 * @description
 */
public class Client {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        new Thread(new Producer(queue),"producer1").start();
        new Thread(new Producer(queue),"producer2").start();
        new Thread(new Producer(queue),"producer3").start();

        new Thread(new Consumer(queue),"consumer1").start();
        new Thread(new Consumer(queue),"consumer2").start();
    }
}
