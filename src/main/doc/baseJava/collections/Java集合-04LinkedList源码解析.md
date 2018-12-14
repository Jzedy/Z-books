# Java集合-04LinkedList源码解析

## 回顾与对比
> 上一章讲到了[ArrayList](https://www.cnblogs.com/JzedyBlogs/p/10112923.html),你也可以在
[github](https://github.com/Jzedy/Z-books)上查看,ArrayList底层基于数组，所以支持随机访问，
因为你可以通过下标访问到具体的数据，而LinkedList则是基于链表，这种不同造成它俩有各自的优缺点；
ArrayList随机访问数据快，而在中间增加删除较慢，LinkedList相反，随机访问较慢，在中间增加删除较快；
访问前面已经提到ArrayList是支持随机访问的，LinkedList访问一个元素的时候需要从前或者从后遍历(后文会
提到会让访问的元素位置与list长度一半作比较选择从前还是从后遍历，这样会提高一定的速度，当时和ArrayList
比较起来肯定是差一些的)；而添加时候呢，ArrayList因为底层是数组，如果容量选择不合适，需要扩容，这涉及到
数组的拷贝，是耗时耗空间的，同时在中间添加时候，回导致后面的元素都需要重写排列，而Linked List只需要改变节点
的前后指向就可以了

## LinkedList简介
> LinkedList基于双向链表，即FIFO(先进先出)和FILO(先进后出)都是支持的，这样它可以作为堆栈，队列使用
```
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```
> 继承AbstractSequentialList,该类我认为和RandomAccess是一个对立，它通过次序访问数据，
实现了List，Deque，Cloneable和Serializable接口

## LinkedList构造函数
1. public LinkedList()
2. LinkedList(Collection<? extends E> c)
> 可以看出和ArrayList对比是少了一个指定容量的构造函数，因为LinkedList不存在扩容的概念，
它通过判断链表的节点next属性判断是否还有下一个节点，增加删除都是针对节点prev和next属性；

## 结构分析
![LinkedList结构图](https://github.com/Jzedy/Z-books/blob/master/src/main/image/LinkedList.png?raw=true)
> 从结构图可以看出LinkedList有三个属性，size：LinkedList大小，
first：LinkedList的第一个节点，last：LinkedList最后一个节点

## LinkedList源码分析(java version:1.8.0_111)
### Node
```java
private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```
> 链表节点Node：LinkedList内部类Node代表的就是节点信息，
item表示的是我们存储在链表当前位置的数据，next记录的是下一个节点指向，
prev记录的是上一个节点指向，这样俯视看LinkedList就会像下面图
![Node图](https://github.com/Jzedy/Z-books/blob/master/src/main/image/Node.png?raw=true)

### 添加元素
```
public boolean add(E e) {
        linkLast(e);
        return true;
    }
```
```
void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
```
> 可以看出来，默认时候我们添加元素都是在LinkedList末尾添加元素的，
当我们添加一个元素e时候，先创建一个prev指向LinkedList最后一个节点，item为e,next指向null
的节点newNode，然后LinkedList的last就指向了newNode,
再让LinkedList原来的最后一个节点指向newNode

----

```
public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }
```
```
Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```
```
void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
```
>添加指定元素到指定位置：从代码中可以看出，首先检查当前index是否合法，
然后和LinkedList的长度比较，如果相等这是再末尾添加元素，上一个add方法类似;
如果不相等则是再LinkedList中间段添加,此时取出原来在index位置的节点，添加一个新节点，
改变对应的节点指向

>这里的node(int index)方法是比较有趣的，你查看源码时候会发现这个方法好像总是在出现，
因为本质上来说，LinkedList的操作就是节点的操作，而对应的定位到某个位置的节点这个方法当然
出现的频率就是有点高了，在开始的时候知道LinkedList的几个属性，可以看出来如果我们想知道
节点信息只能从first和last属性着手，这也是node(int index)方法的由来，是从开始还是从最后
遍历这个方法做了个判断，能加快一定的遍历速度

## LinkedList遍历
1.迭代器遍历
```
Iterator iterator = list.iterator();
while (iterator.hasNext()){
    iterator.next();
}
```

2.ForEach遍历
```
for (Object s : list) 
```
3.随机访问遍历
```
for (int i =0; i<list.size();i++){
    list.get(i);
}
```
4.pollFirst()/pollLast()/removeFirst()/removeLast()方法
```
while (list.pollFirst() != null){
            
}
```
## 总结
> 对应的LinkedList的增删改查操作都是对节点的prev,next和item的操作，遍历测试可以发现
使用随机访问遍历时候速度是最慢的，因为在每一次list.get(index)时候都从开始或者最后遍历
一次链表[查看源码可以看见get方法也是需要上面的node(index)方法]，而foreach和迭代器
速度差不多
