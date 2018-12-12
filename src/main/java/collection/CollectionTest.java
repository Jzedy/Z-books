package collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jzedy
 * @time 2018/12/11 21:50
 * @description
 */
public class CollectionTest {

    private List<String> list;

    @Before
    public void before(){
        list = new LinkedList<>();
        list.add("b");
        list.add("a");
        list.add("c");
    }

    @Test
    public void arrayTest(){
        System.out.println(list.get(1));
        for (int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
