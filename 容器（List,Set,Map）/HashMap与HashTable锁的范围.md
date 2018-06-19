# <center>ConcurrentHashMap和Hashtable锁的范围区别
---
> 因为热爱，所以拼搏。         --RuiDer

---
#### Hashtable和ConcurrentHashMap有什么分别呢？
它们都可以用于多线程的环境，但是当Hashtable的大小增加到一定的时候，性能会急剧下降，因为迭代时需要被锁定很长的时间。
因为ConcurrentHashMap引入了分割(segmentation)，不论它变得多么大，仅仅需要锁定map的某个部分，而其它的线程不需
要等到迭代完成才能访问map。简而言之，在迭代的过程中，ConcurrentHashMap仅仅锁定map的某个部分，而Hashtable则会
锁定整个map。

