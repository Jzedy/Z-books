package collection.failFast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastMultiThread  {
    private static List<String> lists = new ArrayList<>(10);
    static {
        for (int i = 0; i < 4; i++){
            lists.add(String.valueOf(i));
        }
    }
    public static void main(String[] args) {
        new Thread(new ForEachThread()).start();
        new Thread(new EditThread()).start();
    }

    //用于遍历
    static class ForEachThread implements Runnable{
        @Override
        public void run() {
            Iterator<String> iterator = lists.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                try {
                    Thread.sleep(100);//为了另外的线程加入，也是为了结合在遍历时候修改结构
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //用于修改结构
    static class EditThread implements Runnable{
        @Override
        public void run() {
            lists.add("8");
        }
    }

}

