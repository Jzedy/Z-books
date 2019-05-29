package producerAndConsumer.v3Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jzedy
 * @time 19-5-29
 * @description
 */
public class Client {
    public static final Lock lock = new ReentrantLock();
    public static final Condition full = lock.newCondition();
    public static final Condition empty = lock.newCondition();
    private static final int max = 10;

    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        new Thread(new Producer(lists,max),"producer1").start();
        new Thread(new Producer(lists,max),"producer2").start();
        new Thread(new Producer(lists,max),"producer3").start();
        new Thread(new Consumer(lists),"consumer1").start();
        new Thread(new Consumer(lists),"consumer2").start();
    }

}
