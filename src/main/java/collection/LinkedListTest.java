package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> lists = new LinkedList<>();
        for (int i =0 ; i < 10000000; i++){
            lists.add("123");
        }
        rangeFor(lists);
//        rangeRandom(lists);
        rangeIter(lists);
    }

    public static void rangeIter(LinkedList list){
        long start = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        long end = System.currentTimeMillis();
        long cost = end-start;
        System.out.println("Iter:"+cost+"ms");
    }

    public static void rangeFor(LinkedList list){
        long start = System.currentTimeMillis();
        for (Object s : list) {
        }
        long end = System.currentTimeMillis();
        long cost = end-start;
        System.out.println("Foreach:"+cost+"ms");
    }

    public static void rangeRandom(LinkedList list){
        long start = System.currentTimeMillis();
        for (int i =0; i<list.size();i++){
            list.get(i);
        }
        long end = System.currentTimeMillis();
        long cost = end-start;
        System.out.println("Random:"+cost+"ms");
    }
}
