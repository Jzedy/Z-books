# Java集合-06Vector源码解析

## Vector简介
> Vector (矢量类)实现了动态数组的功能，如同数组，它可以通过角标访问数据，
不过Vector被创建后在添加或移除时候能适应性的增加或者减少。继承AbstractCollection类，实现了List、RandomAccess、Cloneable、Serialization接口

## 构造方法
1. public Vector()
2. public Vector(int initialCapacity)
3. public Vector(int initialCapacity, int capacityIncrement)
> Vector包含三个构造函数，第一种默认构造函数，此时初始容量为10，
第二种指定容量大小的构造函数，此时capacityIncrement等于0，扩容时候成倍增加，
第三种指定容量大小和增量，扩容时候增加capacityIncrement大小

## 重要属性
1. protected Object[] elementData;//用于保存Vector数据的数组
2. protected int elementCount;//Vector中数据个数
3. protected int capacityIncrement;//Vector容器的增量

>Vector的方法和ArrayList类似,不过它的增删改查方法前都添加*synchronized*修饰，保证线程安全，也就是说Vector是线程同步的

## Vector源码分析
```
public synchronized boolean add(E e) {
        modCount++;//fail-fast判断机制
        ensureCapacityHelper(elementCount + 1);//确保Vector容量足够，跳转到下一个方法
        elementData[elementCount++] = e;//对应位置复制
        return true;//返回布尔类型
    }
``` 
>![fail-fast(快速失败)机制](https://github.com/Jzedy/Z-books/blob/master/src/main/doc/baseJava/collections/Java%E9%9B%86%E5%90%88-05fail-fast(%E5%BF%AB%E9%80%9F%E5%A4%B1%E8%B4%A5)%E6%9C%BA%E5%88%B6%E5%8E%9F%E7%90%86%E5%8F%8A%E8%A7%A3%E5%86%B3%E6%96%B9%E6%B3%95.md)
```
private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);//判断容量大小和包含元素个数，决定是否扩容
    }
```
```
private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);//如果增量大于0，扩容后的大小为原来容量与增量的和，否则扩容为原来容量的一倍
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

```
public synchronized E remove(int index) {
        modCount++;//fail-fast
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);//数组角标过界异常
        E oldValue = elementData(index);//获取当前角标位置的元素数据

        int numMoved = elementCount - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,numMoved);//复制数组(复制源数组,复制源数组开始位置,复制数组，复制数组开始位置，复制长度)
        elementData[--elementCount] = null; // Let gc do its work

        return oldValue;
    }
```

## Vector遍历方式
> Vector<String> vect = new Vector<>(10);
- 迭代器遍历
    - ```
        Iterator<String> iterator = vect.iterator();
                while (iterator.hasNext()){
                    iterator.next();
        }
        ```
- forEach遍历
    - ```
        for (String s : vect) {
        
        }
        ```
- RandomAccess遍历
    - ```
        for (int i = 0;i<vect.size(); i++){
                    vect.get(i);
        }
        ```

- Enumeration遍历
    - ```
        Enumeration<String> elements = vect.elements();
                while (elements.hasMoreElements()){
                    elements.nextElement();
        }
        ```

