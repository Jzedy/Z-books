package desighPatterns.behaviorType.bt04IteratorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jzedy
 * @time 19-5-12
 * @description
 */
public class ConcreteContainer<E> implements Container<E> {

    private List<E> container = new ArrayList<>();

    @Override
    public void add(E e) {
        container.add(e);
    }

    @Override
    public void remove(E e) {
        container.remove(e);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator<E>{


        private int cursor;

        @Override
        public E next() {
            return container.get(cursor++);
        }

        @Override
        public boolean hasNext() {
            return container.size() != cursor;
        }
    }
}
