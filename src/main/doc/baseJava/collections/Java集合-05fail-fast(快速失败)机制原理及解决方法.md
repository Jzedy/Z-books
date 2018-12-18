# Java集合-05fail-fast(快速失败)机制原理及解决方法

## fail-fast简介
> fail-fast(快速失败)，是Java集合的一种错误检测机制。当在遍历集合的过程中该集合在结构(改变集合大小)上发生变化时候，
有可能发生fail-fast，抛出java.util.ConcurrentModificationException异常。

## fail-fast出现场景
- 单线程场景
  - ```java
        public class FailFastSingleThreadTest {
            public static void main(String[] args) {
                List<String> lists = new ArrayList<>(10);
                for (int i = 0; i < 4; i++){
                    lists.add(String.valueOf(i));
                }
        
                //fail-fast
                for (String list : lists) {
                    lists.remove(3);
                }
            }
        }
    //output:Exception in thread "main" java.util.ConcurrentModificationException
    ```
- 多线程场景
    - ```java
        public class FailFastMultiThread  {
            private static List<String> lists = new ArrayList<>(10);
            static {
                for (int i = 0; i < 4; i++){
                    lists.add(String.valueOf(i));
                }
            }
            public static void main(String[] args) {
                new Thread(new ForEachThread()).start();
                new Thread(new EditThread()).start();
            }
        
            //用于遍历
            static class ForEachThread implements Runnable{
                @Override
                public void run() {
                    Iterator<String> iterator = lists.iterator();
                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                        try {
                            Thread.sleep(100);//为了另外的线程加入，也是为了结合在遍历时候修改结构
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
        
                }
            }
        
            //用于修改结构
            static class EditThread implements Runnable{
                @Override
                public void run() {
                    lists.add("8");
                }
            }
        
        }
        //output:Exception in thread "Thread-0" java.util.ConcurrentModificationException
      ```
## 产生原因
> 集合能够遍历是因为迭代器的原因，而Iterator接口只是定义了具体的方法，集合需要实现该接口方法，
查看ArrayList中具体的实现方法
```java
    //省略部分方法
    private class Itr implements Iterator<E> {
            int cursor;       // index of next element to return
            int lastRet = -1; // index of last element returned; -1 if no such
            int expectedModCount = modCount;
    
            @SuppressWarnings("unchecked")
            public E next() {
                checkForComodification();
                int i = cursor;
                if (i >= size)
                    throw new NoSuchElementException();
                Object[] elementData = ArrayList.this.elementData;
                if (i >= elementData.length)
                    throw new ConcurrentModificationException();
                cursor = i + 1;
                return (E) elementData[lastRet = i];
            }
    
            public void remove() {
                if (lastRet < 0)
                    throw new IllegalStateException();
                checkForComodification();
    
                try {
                    ArrayList.this.remove(lastRet);
                    cursor = lastRet;
                    lastRet = -1;
                    expectedModCount = modCount;
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }
    
            
    
            final void checkForComodification() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        }
```
> 可以看出在Itr是ArrayList的一个内部类，迭代器操作通过这个内部类，Itr有个expectedModCount属性，
这个判断是否与modCount相等，如果不相等抛出异常，modCount记录list结构上发生变化的次数，可以看出在迭代时候
checkForComodification()方法检测两个的值不相等就抛出异常


## 解决方法
- 单线程
    使用迭代器的remove方法
    ```java
      public class NoFailFastSingleThread {
          public static void main(String[] args) {
              List<String> lists = new ArrayList<>(10);
              for (int i = 0; i < 4; i++){
                  lists.add(String.valueOf(i));
              }
      
              Iterator<String> iterator = lists.iterator();
              while (iterator.hasNext()){
                  String next = iterator.next();
                  if (next != null){
                      iterator.remove();
                  }
              }
      
          }
      }
    ```
- 多线程
    使用使用java并发包下的类来代替对应的集合
