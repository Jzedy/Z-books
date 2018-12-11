# JAVA集合-03ArrayList源码解析和使用实例

上一章讲解了Collection接口下得抽象类和继承接口，后续深入到具体得实现类
博客及对应得代码可在[github](https://github.com/Jzedy/Z-books)上查看

## ArrayList简介
>ArrayList底层实现是数组，相较于数组固定大小，ArrayList可以动态的增加；ArrayList继承AbstractCollection,
实现了List、RandomAccess、Cloneable、Serializable;
> 1. ArrayList继承AbstractCollection,实现了List接口，使得它有集合的基本操作
> 2. 实现RandomAccess标记了ArrayList可以随机访问元素
> 3. 实现Cloneable标记支持克隆
> 4. 实现Serializable标记支持序列化

**ArrayList不是线程安全的，如果在多线程条件下使用CopyOnWriteArrayList或者使用Collections.synchronizedList(List list)转化为线程安全的List**

## 构造函数
1. public ArrayList()
2. public ArrayList(int initialCapacity)
3. public ArrayList(Collection<? extends E> c)

>ArrayList提供三种构造函数，第一种构建一个初始化容量为0的ArrayList(查阅资料发现说1.6时候会初始化容量为10),
不过在第一次添加元素时候会让容量变为10；第二种指定初始化容量大小；第三种初始化容量为Collection大小

## 结构分析
![ArrayList](../../../image/arralist.png)
>ArrayList包含两个重要属性：size和elementData
>> 1. size表示当前ArrayList包含的元素个数，对于方法ArrayList#size返回的就是它
>> 2. elementData就是元素存放的位置了
## ArrayList源码分析(java version:1.8.0_111)

## ArrayList遍历方式


