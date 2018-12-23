package collection.map;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jzedy
 * @time 2018/12/20 16:17
 * @description
 */
public class TreeMapT {
    @Test
    public void treeMaptest(){
        Map<Integer,String> maps = new TreeMap<Integer, String>();
        maps.put(2,"jzedy");
        maps.put(1,"jzedy");
        maps.put(3,"jzedy");
        System.out.println(((TreeMap<Integer, String>) maps).firstEntry().getKey());
    }
}
