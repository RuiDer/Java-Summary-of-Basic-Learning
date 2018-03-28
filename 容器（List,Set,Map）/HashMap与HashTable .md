# 细细谈谈HashMap与HashTable
> 入坑一年了，是该好好挖掘一下原理了。。
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
  ![]()
2.可中断锁，Lock就是典型，synchronized不行
3.公平锁：等待时间久的线程优先。synchronized和Lock都不是。
4.读写锁

