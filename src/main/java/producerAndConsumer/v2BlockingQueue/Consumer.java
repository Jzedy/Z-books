package producerAndConsumer.v2BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author Jzedy
 * @time 19-5-29
 * @description
 */
public class Consumer  implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (;;){
            Integer poll = null;
            try {
                poll = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+poll+",size:"+queue.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
