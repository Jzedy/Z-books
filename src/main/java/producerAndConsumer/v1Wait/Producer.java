package producerAndConsumer.v1Wait;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jzedy
 * @time 19-5-28
 * @description
 */
public class Producer implements Runnable {

    private List<String> repo;
    private int max;

    private AtomicInteger i = new AtomicInteger(0);

    private String  getTag(){
        return Thread.currentThread().getName()+"--"+i.getAndAdd(1);
    }

    public Producer(List<String > repo,int max) {
        this.repo = repo;
        this.max = max;
    }

    @Override
    public void run() {
        for (;;){
            synchronized (repo){
                while (repo.size() == max){
                    try {
                        System.out.println("full----------");
                        repo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String  i = getTag();
                repo.add(i);
                System.out.println(Thread.currentThread().getName()+"--->"+i);
                repo.notifyAll();

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
