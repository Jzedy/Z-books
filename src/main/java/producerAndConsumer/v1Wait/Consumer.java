package producerAndConsumer.v1Wait;

import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-28
 * @description
 */
public class Consumer implements Runnable {

    private List<String > repo;

    public Consumer(List<String > repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        for (;;){
            synchronized (repo){
                while (repo.size() == 0){
                    try {
                        System.out.println("empty------");
                        repo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                repo.notifyAll();
                String  remove = repo.remove(0);
                System.out.println(Thread.currentThread().getName()+"--->"+remove+",result:"+repo.size());
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
