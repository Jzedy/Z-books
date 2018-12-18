package collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author Jzedy
 * @time 2018/12/18 22:16
 * @description
 */
public class VectorTest {
    private Vector<String> vect = new Vector<>(10);
    @Before
    public void before(){
        for (int i = 0 ; i < 100000; i++){
            vect.add(String.valueOf(i));
        }
    }

    /**
     * 迭代器遍历
     */
    @Test
    public void iterT(){
        long start = System.currentTimeMillis();
        Iterator<String> iterator = vect.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("iterator cost:"+(end-start));
    }

    /**
     * forEach遍历
     */
    @Test
    public void foreachT(){
        long start = System.currentTimeMillis();
        for (String s : vect) {

        }
        long end = System.currentTimeMillis();
        System.out.println("forEach cost:"+(end-start));
    }

    /**
     * RandomAccess遍历
     */
    @Test
    public void randomT(){
        long start = System.currentTimeMillis();
        for (int i = 0;i<vect.size(); i++){
            vect.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("random cost:"+(end-start));
    }

    /**
     * Enumeration遍历
     */
    @Test
    public void enumT(){
        long start = System.currentTimeMillis();
        Enumeration<String> elements = vect.elements();
        while (elements.hasMoreElements()){
            elements.nextElement();
        }
        long end = System.currentTimeMillis();
        System.out.println("enum cost:"+(end-start));
    }


}
