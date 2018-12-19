package collection.map;

import java.util.*;

public class MyUnmodifiableMap<K,V> extends AbstractMap<K,V> implements Map<K,V> {

    private K k;
    private V v;
    public MyUnmodifiableMap(K k, V v) {
        this.k = k;
        this.v = v;
    }



    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet rs = new HashSet();
        rs.add(new SimpleImmutableEntry<>(k,v));
        return rs;
    }


    public static void main(String[] args) {
        MyUnmodifiableMap<String,String> myUnmodifiableMap = new MyUnmodifiableMap<>("jzedy","jzedy");
//        myUnmodifiableMap.put("jzed","sd");
//        myUnmodifiableMap.remove("jzedy");
        myUnmodifiableMap.remove("jzedy");
        for (String s : myUnmodifiableMap.keySet()) {
            System.out.println(s);
        }
    }
}
