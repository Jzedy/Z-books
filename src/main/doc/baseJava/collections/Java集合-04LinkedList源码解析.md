# Java集合-04LinkedList源码解析

## 回顾与对比
> 上一章讲到了[ArrayList](https://www.cnblogs.com/JzedyBlogs/p/10112923.html),你也可以在
[github](https://github.com/Jzedy/Z-books)上查看,ArrayList底层基于数组，所以支持随机访问，
因为你可以通过下标访问到具体的数据，而LinkedList则是基于链表，这种不同造成它俩有各自的优缺点；
ArrayList随机访问数据快，而在中间增加删除较慢，LinkedList相反，随机访问较慢，在中间增加删除较快；
访问前面已经提到ArrayList是支持随机访问的，LinkedList访问一个元素的时候需要从前或者从后遍历(后文会
提到比较访问的元素位置与list长度一半比较选择从前还是从后遍历，这样会提高一定的速度，当时和ArrayList
比较起来肯定是差一些的)；而添加时候呢，ArrayList因为底层是数组，如果容量选择不合适，需要扩容，这涉及到
数组的拷贝，是耗时耗空间的，同时在中间添加时候，回导致后面的元素都需要重写排列，而Linked List只需要改变节点
的前后指向就可以了

## LinkedList简介
