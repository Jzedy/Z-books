package collection.failFast;

import java.util.ArrayList;
import java.util.List;

public class FailFastSingleThreadTest {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>(10);
        for (int i = 0; i < 4; i++){
            lists.add(String.valueOf(i));
        }

        //fail-fast
        for (String list : lists) {
            lists.remove(3);
        }
    }
}
