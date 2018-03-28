# 细细谈谈HashMap与HashTable
> 入坑一年了，是该好好挖掘一下原理了。。
## HashMap与HashTable的共同点（都实现速度）
>1.都属于集合框架，非常重要。。
>2.他们的底层实现原理其实是一样的，都是使用数组+链表结构。由于数组空间连续，易查找，不易插入和删除；而链表空间不连续，易插入删除，不易查询，使用HashMap和
>HashTable将数组和链表结合，实现易查找，易插入易删除。
>3.都是使用Key的哈希值或者计算结果作为底层数组的角标，数组的元素使用链表实现，每个链表包括key，value，next属性，新元素被插入到头。

------------------
## 谈谈他们的不同点（重要点）
> 1.继承方式不同`HashMap extends AbstractMap implements Map;HashTable extends Dictionary implements Map`;
> 2.hashCode()方法实现不同，HashMap是key哈希值计算结果，而HashTable直接使用key的hashCode。
> 3.底层数组的容量和扩容方式不同，HashMap的底层数组的初始容量是16，扩容方式是2的n次方；HashTable底层数组的初始容量是11，扩容方式是old*2+1；
> 4.HashTable迭代时可以使用Enumeration的对象.
> 5.(重要点)HashMap的key和value可以是null，HashTable不可以，当插入 null时会抛出NullPointException。由于HashMap的这一特点导致get()方法一旦返回null
>说明key可能不存在，或者key的值为null，这时候需要使用containsKey()方法判断
> (最重要)HashMap线程不安全，HashTable线程安全，这也就是同步不同步的问题。当然，由于线程安全的问题，HashMap的效率比HashTable要快的多。下面细细比较一下
>HashTable使用synchronized关键字同步，HashMap不使用，但是ConcurrentHashMap类实现同步锁，是线程安全的。
-----------------------
## ConcurrentHashMaL和HashTable的区别
> 由于ConcurrentHashMap使用了Lock接口，所以这个问题就先相当于在比较synchronized和Lock的区别,下面细细讲讲。。。
----------
## synchronized和Lock的区别
1. synchronized是java的一个关键字，而Lock是java的一个类接口。
2. 
