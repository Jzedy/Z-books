package producerAndConsumer.v3Condition;

import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-29
 * @description
 */
public class Consumer implements Runnable {
    private List<Integer> lists;

    public Consumer(List<Integer> lists) {
        this.lists = lists;
    }

    @Override
    public void run() {
        for (;;){
            Client.lock.lock();
            while (lists.isEmpty()){
                System.out.println("empty");
                try {
                    Client.empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Integer remove = lists.remove(0);
            System.out.println(Thread.currentThread().getName()+"-->"+remove+",size:"+lists.size());
            Client.full.signalAll();
            Client.lock.unlock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
