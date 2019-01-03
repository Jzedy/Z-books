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

    @Test
    public void equalkey(){
        ForKey jzedy = new ForKey("jzedy");
        ForKey jzedy2 = new ForKey("jzedy");
        System.out.println(jzedy.equals(jzedy2));
    }

    @Test
    public void mapForKey(){
        HashMap<ForKey, String> map = new HashMap<>();
        map.put(new ForKey("jzedy"),"S");
        map.put(new ForKey("test"),"S");
        map.put(new ForKey("test2"),"S");
        System.out.println(map.get(new ForKey("jzedy")));
    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap(10);
        map.put("1","fsad");
        map.put("2","fsad");
        map.put("4","fsad");
        map.put("3","fsad");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    @Test
    public void mapEntryForeach(){
        Map<Integer,String> maps = new HashMap<>(8);
        maps.put(1,"a");
        maps.put(3,"a");
        maps.put(2,"a");

        for (Map.Entry<Integer, String> entry : maps.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        for (Integer integer : maps.keySet()) {
            System.out.println(integer);
        }
        for (String value : maps.values()) {
            System.out.println(value);
        }
    }
}

class ForKey{
    private String name;

    public ForKey(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ForKey){
            return this.name.equals(((ForKey) obj).name);
        }
        return false;
    }
}
