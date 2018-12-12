package collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jzedy
 * @time 2018/12/11 21:50
 * @description
 */
public class ArrayListTest {



    public static void rangeByRandom(List list){
        long start = System.currentTimeMillis();
        Object o = null;
        for (int i = 0 ;i < list.size(); i++){
            o=list.get(i);
        }
        System.out.println("rangeByRandom:"+(System.currentTimeMillis()-start));
    }

    public static void rangeByIterator(List list){
        long start = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        Object o = null;
        while (iterator.hasNext()){
            o = iterator.next();
        }
        System.out.println("rangeByIterator:"+(System.currentTimeMillis()-start));
    }

    public static void main(String[] args) {
        List list = new ArrayList(100000);
        for (int i = 0 ; i<100000;i++){
            list.add(i);
        }

        rangeByRandom(list);
        rangeByIterator(list);
    }
}
