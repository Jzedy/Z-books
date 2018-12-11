# Java集合-02集合抽象类
## Collection简介
Collcetion定义(java version:1.8.0_111)
```java
public interface Collection<E> extends Iterable<E>{
        boolean add(E e);
        boolean addAll(Collection<? extends E> c);
        boolean remove(Object o);
        void clear();
        Iterator<E> iterator();
        boolean isEmpty();
        int size();
        boolean contains(Object o);
        boolean containsAll(Collection<?> c);
        boolean removeAll(Collection<?> c);
        boolean retainAll(Collection<?> c);
        Object[] toArray();
        <T> T[] toArray(T[] a);
}
```
Collection接口定义了集合的基本操作：
添加，删除，清空，遍历，是否为空，大小，是否包含某元素或者集合，变为数组等方法

## List简介
List定义：
```java
public interface List<E> extends Collection<E>{
        boolean add(E e);
        boolean addAll(Collection<? extends E> c);
        boolean remove(Object o);
        void clear();
        Iterator<E> iterator();
        boolean isEmpty();
        int size();
        boolean contains(Object o);
        boolean retainAll(Collection<?> c);
        boolean removeAll(Collection<?> c);
        boolean containsAll(Collection<?> c);
        Object[] toArray();
        <T> T[] toArray(T[] a);
        //在Collection接口基础上添加新的方法
        E remove(int index);
        boolean addAll(int index, Collection<? extends E> c);
        E get(int index);
        E set(int index, E element);
        void add(int index, E element);
        int indexOf(Object o);
        int lastIndexOf(Object o);
        ListIterator<E> listIterator();
        ListIterator<E> listIterator(int index);
        List<E> subList(int fromIndex, int toIndex);
}
```
>List继承Collection接口，是一个有序可重复的集合，它的每一个元素都有一个索引，第一个索引为0；
List提供了一个特殊的迭代器叫做**ListIterator**，允许在**Iterator**的基础上允许元素插入和替换以及双向存取

## Set简介

Set定义：
```java
public interface Set<E> extends Collection<E>{
    boolean add(E e);
            boolean addAll(Collection<? extends E> c);
            boolean remove(Object o);
            void clear();
            Iterator<E> iterator();
            boolean isEmpty();
            int size();
            boolean contains(Object o);
            boolean containsAll(Collection<?> c);
            boolean removeAll(Collection<?> c);
            boolean retainAll(Collection<?> c);
            Object[] toArray();
            <T> T[] toArray(T[] a);
}
```
>Set和Collection接口API没有什么区别，Set是一个不包含重复元素的集合，最多一个null元素

## Queue简介
```java
public interface Queue<E> extends Collection<E>{
    boolean add(E e);
    boolean offer(E e);
    E remove();
    E poll();
    E element();
    E peek();
}
```
>Queue是在java5添加的，用于支持队列的常见操作，队列的一个特性为先进先出，即先添加的元素是最先被删除的元素。
拓展了Collection接口，add和offer方法添加元素，不同的是
add方法添加失败会抛出异常，故添加元素时候优先选择offer方法；
remove和poll方法为移除元素，同样的优先使用poll方法，如果为空队列时候，
remove方法会抛出异常，而poll方法会返回null；
element和peek方法遍历队列，优先使用peek，element方法在在空队列时使用抛出异常

## AbstractCollection简介
```java
public abstract class AbstractCollection<E> implements Collection<E>{
    protected AbstractCollection() {
    }
    public abstract Iterator<E> iterator();
    public abstract int size();
    public boolean isEmpty() {
            return size() == 0;
    }
    public boolean contains(Object o) {
            Iterator<E> it = iterator();
            if (o==null) {
                while (it.hasNext())
                    if (it.next()==null)
                        return true;
            } else {
                while (it.hasNext())
                    if (o.equals(it.next()))
                        return true;
            }
            return false;
    }
    
    public Object[] toArray() {
            // Estimate size of array; be prepared to see more or fewer elements
            Object[] r = new Object[size()];
            Iterator<E> it = iterator();
            for (int i = 0; i < r.length; i++) {
                if (! it.hasNext()) // fewer elements than expected
                    return Arrays.copyOf(r, i);
                r[i] = it.next();
            }
            return it.hasNext() ? finishToArray(r, it) : r;
    }
    public <T> T[] toArray(T[] a) {
            // Estimate size of array; be prepared to see more or fewer elements
            int size = size();
            T[] r = a.length >= size ? a :
                      (T[])java.lang.reflect.Array
                      .newInstance(a.getClass().getComponentType(), size);
            Iterator<E> it = iterator();
    
            for (int i = 0; i < r.length; i++) {
                if (! it.hasNext()) { // fewer elements than expected
                    if (a == r) {
                        r[i] = null; // null-terminate
                    } else if (a.length < i) {
                        return Arrays.copyOf(r, i);
                    } else {
                        System.arraycopy(r, 0, a, 0, i);
                        if (a.length > i) {
                            a[i] = null;
                        }
                    }
                    return a;
                }
                r[i] = (T)it.next();
            }
            // more elements than expected
            return it.hasNext() ? finishToArray(r, it) : r;
    }
    
    public boolean add(E e) {
            throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object o) {
            Iterator<E> it = iterator();
            if (o==null) {
                while (it.hasNext()) {
                    if (it.next()==null) {
                        it.remove();
                        return true;
                    }
                }
            } else {
                while (it.hasNext()) {
                    if (o.equals(it.next())) {
                        it.remove();
                        return true;
                    }
                }
            }
            return false;
    }
    
    public boolean containsAll(Collection<?> c) {
            for (Object e : c)
                if (!contains(e))
                    return false;
            return true;
    }
    
    public boolean addAll(Collection<? extends E> c) {
            boolean modified = false;
            for (E e : c)
                if (add(e))
                    modified = true;
            return modified;
    }
    
    public boolean removeAll(Collection<?> c) {
            Objects.requireNonNull(c);
            boolean modified = false;
            Iterator<?> it = iterator();
            while (it.hasNext()) {
                if (c.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
    }
    
    public boolean retainAll(Collection<?> c) {
            Objects.requireNonNull(c);
            boolean modified = false;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (!c.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
    }
    
    public void clear() {
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
    }
    
    public String toString() {
            Iterator<E> it = iterator();
            if (! it.hasNext())
                return "[]";
    
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (;;) {
                E e = it.next();
                sb.append(e == this ? "(this Collection)" : e);
                if (! it.hasNext())
                    return sb.append(']').toString();
                sb.append(',').append(' ');
            }
        }
}
```
>AbstractCollection是一个抽象类，实现了除iterator和size之外的函数，当然add之定义了个异常，
因为add方法针对不同的集合会做不同的处理，这样不管我们自己定义还是java本身的一些常用集合都可以
继承这个抽象类

## AbstractList简介
>AbstractList抽象类继承AbstractCollection类实现List接口,实现了List中除了size()和get(int index)之外的函数
相对于AbstractCollection，它实现了Iterator

## AbstractSet简介
>AbstractSet抽象类继承AbstractCollection类实现Set接口，相对于AbstractCollection没有太大的变化，
只是针对Set重写了equals和removeAll方法

## Deque
> Deque继承Queue，不过它是一个双向队列，在Queue上有了更加丰富的特性，支持从两个端点添加和删除元素

## SortedSet
```java
public interface SortedSet<E> extends Set<E>{
    Comparator<? super E> comparator();//就是它，实现类重写这个方法，使得set变为有序
    SortedSet<E> subSet(E fromElement, E toElement);
    SortedSet<E> headSet(E toElement);
    SortedSet<E> tailSet(E fromElement);
    E first();
    E last();
    E last();
}
```
>SortedSet接口继承Set，在Set基础上添加了其他方法，使得Set变为有序集合
