package producerAndConsumer.v2BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author Jzedy
 * @time 19-5-29
 * @description
 */
public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    private volatile int i;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (;;){
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+(i++)+",size:"+queue.size());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
