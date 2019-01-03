# Java集合-08LinkedHashMap源码解析及使用实例

## LinkedHashMap 简介
> hash表和链表实现了map接口，迭代顺序是可以预测的。LinkedHashMap和HashMap的不同是它所有的entry
维持了一个双向链表结构。该链表定义了通常迭代顺序是键插入的顺序。

## LinkedHashMap 定义
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>
> 

