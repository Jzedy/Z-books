package collection.failFast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiThreadTest {
//    private static List<String> lists = new ArrayList<>(10);
    private static List<String> lists = new CopyOnWriteArrayList<>();
    static {
        for (int i = 0; i<4; i++){
            lists.add(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        new Thread(new ForEach()).start();
        new Thread(new Edit()).start();
    }
    static class ForEach implements Runnable{
        @Override
        public void run() {
            Iterator<String> iterator = lists.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Edit implements Runnable{
        @Override
        public void run() {
//            Iterator<String> iterator = lists.iterator();
//            int i = 0;
//            while (iterator.hasNext()){
//                String next = iterator.next();
//                if (next != null){
//                    iterator.remove();
//                }
//            }
            lists.remove(2);
        }
    }
}

