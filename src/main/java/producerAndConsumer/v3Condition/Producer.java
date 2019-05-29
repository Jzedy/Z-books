package producerAndConsumer.v3Condition;

import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-29
 * @description
 */
public class Producer implements Runnable {

    private List<Integer> lists;
    private final int max;
    private int i;


    public Producer(List<Integer> lists,int max) {
        this.lists = lists;
        this.max = max;
    }

    @Override
    public void run() {
        for (;;){
            Client.lock.lock();
            while (lists.size() == max){
                System.out.println("full");
                try {
                    Client.full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lists.add(i);
            Client.empty.signalAll();
            Client.lock.unlock();
            System.out.println(Thread.currentThread().getName()+"--->"+i++ +",size:"+lists.size());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
