package collection.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapViews {

    private Map<String,String> maps = new HashMap<>(16);
    @Before
    public void before(){
        maps.put("1","jzedy");
        maps.put("2","jzedy");
        maps.put("2","jzedy2");
        maps.put("3","jzedy2");
    }

    @Test
    public void views(){
        System.out.println("key views");
        maps.keySet().forEach(e-> System.out.print(e+","));
        System.out.println("\nvalue views");
        maps.values().forEach(v-> System.out.print(v+","));
        System.out.println("\nkey-value views");
        maps.forEach((k,v)-> System.out.print(k+":"+v+","));
        /**
         * output:
         * key views
         * 1,2,3,
         * value views
         * jzedy,jzedy2,jzedy2,
         * key-value views
         * 1:jzedy,2:jzedy2,3:jzedy2,
         */
    }

    @Test
    public void getTest(){
        maps.put(null,"jzedy");
        System.out.println(maps.get(null));//jzedy
        String s = maps.get("2");
        System.out.println(s);//jzedy2
        System.out.println(maps.get("5"));//null
        Map<String,String> hashTab = new Hashtable<>();
        hashTab.get(null);//java.lang.NullPointerException
    }

    @Test
    public void table(){
        Map<String,String> hashTab = new Hashtable<>();
        hashTab.put("jzedy","jzedy");
        System.out.println(hashTab.remove("j"));
    }
    @Test
    public void jdk8(){
        System.out.println(maps.getOrDefault("2","value"));
        System.out.println(maps.getOrDefault("5","value"));
        maps.putIfAbsent("2","value");
        maps.putIfAbsent("5","value");
        maps.put("jzedy",null);
        maps.put("jzedy","jzedy");
        System.out.println("");
    }
}
