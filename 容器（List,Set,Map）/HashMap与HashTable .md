# 细细谈谈HashMap与HashTable
> 入坑一年了，是该好好挖掘一下原理了。。
> 参考[点击查看](https://www.cnblogs.com/baizhanshi/p/6419268.html)
## HashMap与HashTable的共同点（都实现速度）
1. 都属于集合框架，非常重要。。
2. 他们的底层实现原理其实是一样的，都是使用数组+链表结构。由于数组空间连续，易查找，不易插入和删除；而链表空间不连续，易插入删除，不易查询，使用HashMap和HashTable将数组和链表结合，实现易查找，易插入易删除。
3. 都是使用Key的哈希值或者计算结果作为底层数组的角标，数组的元素使用链表实现，每个链表包括key，value，next属性，新元素被插入到头。

------------------
## 谈谈他们的不同点（重要点）
1. 继承方式不同`HashMap extends AbstractMap implements Map;HashTable extends Dictionary implements Map`;
2. hashCode()方法实现不同，HashMap是key哈希值计算结果，而HashTable直接使用key的hashCode。
3. 底层数组的容量和扩容方式不同，HashMap的底层数组的初始容量是16，扩容方式是2的n次方；HashTable底层数组的初始容量是11，扩容方式是old*2+1；
4. HashTable迭代时可以使用Enumeration的对象.
5. (重要点)HashMap的key和value可以是null，HashTable不可以，当插入 null时会抛出NullPointException。由于HashMap的这一特点导致get()方法一旦返回null
说明key可能不存在，或者key的值为null，这时候需要使用containsKey()方法判断
6. (最重要)HashMap线程不安全，HashTable线程安全，这也就是同步不同步的问题。当然，由于线程安全的问题，HashMap的效率比HashTable要快的多。下面细细比较一下HashTable使用synchronized关键字同步，HashMap不使用，但是ConcurrentHashMap类实现同步锁，是线程安全的。
-----------------------
## ConcurrentHashMaL和HashTable的区别
> 由于ConcurrentHashMap使用了Lock接口，所以这个问题就先相当于在比较synchronized和Lock的区别,下面细细讲讲。。。
----------
## synchronized和Lock的区别
1. synchronized是java的一个关键字，而Lock是java的一个类接口。
2. synchronized的使用方式`... sychronized(对象锁){ 。。。同步代码块。。}....`;Lock的使用方式：`...Lock lock=new ReentrantLock(); lock.lock();
try{ code  } catch(){  }finally{ lock.unlock();}...`
3.synchronized:一旦线程拿到锁，进入同步代码块，其他线程只能干巴巴的等待，直到该线程运行完同步代码块或者遇到异常被JVM强迫释放锁。不易死锁。
4.Lock实现同步是人为实现，容易造成死锁，所以使用try和finally语句。
5.```java
public interface Lock{
  public void lock();     //获得锁
  
  public void unLock();    //释放锁
  
  public boolean tryLock();          //尝试获得锁，获得返回true，否则返回false
  public boolean tryLock(等待时间)；   //同理，在等待时间范围内获得和不获得

  public boolean lockInterruptibly();  //可中断等待的线程，比如A和B一起竞争锁，A获得锁，那么B可以中止等待。
}
```
6.从上面可以看出来Lock可以实现线程的中断，判断是否获得锁；比如判断没有获得锁就可以做其他的事，大大提升办事效率，而synchronized不行

------------------
### 我们谈谈锁
1.可重入锁，ReentrantLock就是可重入锁的意思。如果锁具备可重入性，则称作为可重入锁。像synchronized和ReentrantLock都是可重入锁，可重入性在我看来实际上表明了锁的分配机制：基于线程的分配，而不是基于方法调用的分配。举个简单的例子，当一个线程执行到某个synchronized方法时，比如说method1，而在method1中会调用另外一个synchronized方法method2，此时线程不必重新去申请锁，而是可以直接执行方法method2。

　　看下面这段代码就明白了：
  ```java
  class MyClass {
    public synchronized void method1() {
        method2();
    }
     
    public synchronized void method2() {
         
    }
}
  ```
  上述代码中的两个方法method1和method2都用synchronized修饰了，假如某一时刻，线程A执行到了method1，此时线程A获取了这个对象的锁，而由于method2也是synchronized方法，假如synchronized不具备可重入性，此时线程A需要重新申请锁。但是这就会造成一个问题，因为线程A已经持有了该对象的锁，而又在申请获取该对象的锁，这样就会线程A一直等待永远不会获取到的锁。
  
  ------------------
可中断锁：顾名思义，就是可以相应中断的锁。

　　在Java中，synchronized就不是可中断锁，而Lock是可中断锁。

　　如果某一线程A正在执行锁中的代码，另一线程B正在等待获取该锁，可能由于等待时间过长，线程B不想等待了，想先处理其他事情，我们可以让它中断自己或者在别的线程中中断它，这种就是可中断锁。

　　在前面演示lockInterruptibly()的用法时已经体现了Lock的可中断性。

　　3.公平锁

　　公平锁即尽量以请求锁的顺序来获取锁。比如同是有多个线程在等待一个锁，当这个锁被释放时，等待时间最久的线程（最先请求的线程）会获得该所，这种就是公平锁。

　　非公平锁即无法保证锁的获取是按照请求锁的顺序进行的。这样就可能导致某个或者一些线程永远获取不到锁。

　　在Java中，synchronized就是非公平锁，它无法保证等待的线程获取锁的顺序。

　　而对于ReentrantLock和ReentrantReadWriteLock，它默认情况下是非公平锁，但是可以设置为公平锁。

　　看一下这2个类的源代码就清楚了：
  ![](https://images0.cnblogs.com/i/288799/201408/201642145495232.jpg)
  在ReentrantLock中定义了2个静态内部类，一个是NotFairSync，一个是FairSync，分别用来实现非公平锁和公平锁。

　　我们可以在创建ReentrantLock对象时，通过以下方式来设置锁的公平性：
  `ReentrantLock lock = new ReentrantLock(true);`
  如果参数为true表示为公平锁，为fasle为非公平锁。默认情况下，如果使用无参构造器，则是非公平锁。
  ![](https://images0.cnblogs.com/i/288799/201408/201646038317744.jpg)
  　另外在ReentrantLock类中定义了很多方法，比如：

　　isFair()        //判断锁是否是公平锁

　　isLocked()    //判断锁是否被任何线程获取了

　　isHeldByCurrentThread()   //判断锁是否被当前线程获取了

　　hasQueuedThreads()   //判断是否有线程在等待该锁

　　在ReentrantReadWriteLock中也有类似的方法，同样也可以设置为公平锁和非公平锁。不过要记住，ReentrantReadWriteLock并未实现Lock接口，它实现的是ReadWriteLock接口。

　　4.读写锁

　　读写锁将对一个资源（比如文件）的访问分成了2个锁，一个读锁和一个写锁。

　　正因为有了读写锁，才使得多个线程之间的读操作不会发生冲突。

　　ReadWriteLock就是读写锁，它是一个接口，ReentrantReadWriteLock实现了这个接口。

　　可以通过readLock()获取读锁，通过writeLock()获取写锁。

