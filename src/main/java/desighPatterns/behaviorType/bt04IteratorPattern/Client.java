package desighPatterns.behaviorType.bt04IteratorPattern;

/**
 * @author Jzedy
 * @time 19-5-12
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Container<Integer> container = new ConcreteContainer<>();
        container.add(1);
        container.add(3);
        container.add(2);
        Iterator iterator = container.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
