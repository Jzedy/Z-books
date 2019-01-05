package collection.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jzedy
 * @time 2019/1/3 21:25
 * @description
 */
public class LinkedHashMapTest {

    @Test
    public void putmap(){
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"jzedy");
        linkedHashMap.put(3,"jzedy");
        linkedHashMap.put(2,"jzedy");
        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }
}
