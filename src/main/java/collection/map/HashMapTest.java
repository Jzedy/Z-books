package collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jzedy
 * @time 2018/12/23 16:03
 * @description
 */
public class HashMapTest {

    @Test
    public void initCap(){
        Map map = new HashMap(10);
    }

    public static void main(String[] args) {
        Map map = new HashMap(10);
        map.put("1","fsad");
        map.put("2","fsad");
        map.put("3","fsad");
        map.put("4","fsad");
        Map newMap = new HashMap(map);
    }
}
