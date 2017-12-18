# ArrayList与LinkedList性能对比分析
>ArrayList与LinkedList:都是List的子类，继承List的所有
>public与protected方法。

## ArrayList:
>ArrayList：底层数据结构是以数组形式建立的，本质是一个数组
>能够根据数组角标进行增删改查等行为。

## LinkedList:
> LinkedList:底层数据结构是以链表形式建立的，本质是一个链表
>能够进行增删改查等行为。


## ArrayList与LinkedList的性能对比:
```
	ArrayList：
		1.适合随机读取容器内的数据，而linkedList的这个
		功能非常差。
	

	linkedList:适合插入数据与删除数据。
```