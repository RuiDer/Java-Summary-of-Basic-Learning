# 集合容器List

## 概念：
```
|--List:该容器的 元素是有序的（存储的顺序和取出的顺序一致）
	该集合的元素都有索引（角标），像数组。可以存储重复元素
	因为有角标，一个角标对一个元素。
```

## list最常见共性方法。继承Collection的 所有方法
1. 添加元素

2. 删除元素

3. 修改元素

4. 查找元素

#### List特有方法

1. add(索引1，插入元素  )  //在指定位置插入元素

## 代码实现
```java
import java.util.List;
import java.util.ArrayList;
public class ListTest1{
	public static void main(String[] args){

		//创建List集合对象，即list容器
		List list=new ArrayList();

		//添加对象元素
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");

		System.out.println("原集合>>"+list);

		//根据角标，在指定位置添加元素，角标不能超过size大小
		list.add(1,"abc4");

		//不能越界
		//list.add(5,"abc5");     
		System.out.println("添加后>>"+list);


		//根据角标移除元素
		//list.remove(1);        //remove(int index)这个方法返回值为删除的元素值
		System.out.println("删除"+list.remove(1)+"成功");
		System.out.println("原集合变为>>"+list);


		//根据角标修改元素值
		//set()方法返回一个被修改的元素值
		//list.set(0,"abc0");
		System.out.println("set(0,abc0)>>"+list.set(0));

		//查找元素：根据角标查找元素
		System.out.println("list.get(1)");

	
		//根据元素值查看该值所在角标
		System.out.println("indexOf(abc2)>>"+list.indexOf("abc2"));


		//根据角标获取子列表
		System.out.println("subList(0,2)>>"+list.subList(0,2));	


		//获取所有元素,使用for循环遍历
		for(int n=0;n<list.size();n++)
		{
			System.out.println("操作后元素>>"+list.get(n));
		}
		
	}
}
```
#### 注意：
```
1. add(角标，对象元素);这里的角标不能越过已有的size，否则会出现下面情况

list.add(5,"abc5");
运行结果：
	Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 4
	at java.util.ArrayList.rangeCheckForAdd(ArrayList.java:661)
	at java.util.ArrayList.add(ArrayList.java:473)
	at ListTest1.main(ListTest1.java:20)

2. remove(int index)这个方法返回值为删除的元素值 

System.out.println("删除"+list.remove(1)+"成功");
运行结果：
	删除abc4成功

3. 根据角标修改元素值：set(角标，新值)，返回值为被修改的值。

4. subList(初角标，末角标)方法：子列表包括角标的元素值，不包括末角标的元素值

```