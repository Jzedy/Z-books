# Java集合-08HashMap源码解析及使用实例

## HashMap 简介
> HahMap是基于hash表的Map接口实现。该实现提供所有可选的映射操作，且允许key和value为null。同时
它不是线程安全以及不能保证有序。初始容量(initial capacity)和加载因子(initial capacity)是影响
HashMap的两个因素。容量表示hash表中桶(buckets)的数量，初始容量就是表示hash表在创建时候容量大小。
加载因子就是hash表在其容量自动增加时候被允许填满程度的指标。当hash表中条目数超过当前hash表容量
与加载因子的乘积时候，hash表将进行rehash操作(重建内部数据结构)，从而hash表的桶数目大约增长两倍。

>通常加载因子为0.75，这个值是时间和空间消耗的一个平衡值。过高的值降低了空间消耗但是却增加了查询成本。
在设置初始化容量时候需要考虑Map中的条目数和加载因子，以便减少rehash操作。如果初始容量的值大于最大条目数除以加载因子，
将不会发生rehash操作。

>如果你要使用HashMap存储映射关系时候，有一个充足的容量是比让HashMap自动rehash来增加容量更加有效率。需要提醒的是
使用具有相同的hashCode()的键是会降低hash表的表现。为了避免hash碰撞，键如果是Comparable的话，对解开结有一定的帮助。

>因为HashMap不是线程安全的，在多线程并发编程时候，如果有至少一个线程在对HashMap结构修改(结构修改指的是添加
或者减少映射关系，对于原来有的一个映射改变它的值不是结构上的修改)，必须保证同步化操作。通常来说使用某一对象加锁，
如果没有这么一个对象的话，该HashMap需要用Collections#synchronizedMap对其重新包裹

## HashMap 构造函数
1. public HashMap()
    > 定义一个初始容量为16，加载因子为0.75的HashMap
2. public HashMap(int initialCapacity)
    > 定义一个指定初始容量，加载因子为0.75的HashMap
3. public HashMap(int initialCapacity, float loadFactor)
    > 定义一个指定初始容量和加载因子的HashMap
4. public HashMap(Map<? extends K, ? extends V> m)
    >定义一个初始容量为不小于(m.size()/0.75+1)的2的最小指数，加载因子为0.75,包含了m中映射关系的HashMap

## HashMap 结构图
![HashMap结构图](../../../image/HashMap.png)

>
