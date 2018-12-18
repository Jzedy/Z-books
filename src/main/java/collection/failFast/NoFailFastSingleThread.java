package collection.failFast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NoFailFastSingleThread {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>(10);
        for (int i = 0; i < 4; i++){
            lists.add(String.valueOf(i));
        }

        Iterator<String> iterator = lists.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next != null){
                iterator.remove();
            }
        }

    }
}
