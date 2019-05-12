package desighPatterns.behaviorType.bt04IteratorPattern;

/**
 * @author Jzedy
 * @time 19-5-12
 * @description
 */
public interface Iterator<E> {
    E next();
    boolean hasNext();
}
