package collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        list = new ArrayList<>(4);
        list.add("a");
        list.add("b");
        list.add("c");
    }

    @Test
    public void arrayTest(){
        System.out.println(list.get(1));
    }
}
