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
        HashMap map = new HashMap(10);
        map.put("1","fsad");
        map.put("2","fsad");
        map.put("3","fsad");
        map.put("4","fsad");
        Map newMap = new HashMap(map);
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
