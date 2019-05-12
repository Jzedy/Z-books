package desighPatterns.behaviorType.bt04IteratorPattern;

/**
 * @author Jzedy
 * @time 19-5-12
 * @description
 */
public interface Container<E> {
    void add(E e);
    void remove(E e);
    Iterator iterator();
}
