import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class CollectionTest2 {
	/*
	 * 集合框架练习2，实现对一堆元素处理的方法：addALL();containsAll();remainAll();removeAll();
	 */
	public static void main(String[] args) {

		// 创建集合对象list2，也就是容器
		Collection list1 = new ArrayList<>();
		// 添加元素
		list1.add("abc1");
		list1.add("abc2");

		// 创建集合对象list2，也就是容器
		Collection list2 = new ArrayList<>();
		// 添加元素
		list2.add("abc3");
		list2.add("abc4");

		// 创建集合对象list3，也就是容器
		Collection list3 = new ArrayList<>();
		// 添加元素
		list3.add("abc5");
		list3.add("abc6");

		// 给list1添加一堆元素
		boolean result1 = list1.addAll(list2);
		System.out.println("是否添加成功>>" + result1);
		System.out.println(list1);

		// list1中是否含有list3的元素
		boolean result2 = list1.containsAll(list3);
		System.out.println("list1是否含有list3>>" + result2);

		// 删除一堆元素
		boolean result3 = list1.removeAll(list3);
		System.out.println("是否删除成功>>" + result3);

		// 集合元素的交集判断,
		// list1变化：
		// 如果有交集，list1中只存储交集元素，删除其他未交集元素
		// 如果没有，list1为空集合。
		// 返回值：
		// list1有变化返回true，无变化返回false。

		// 总结：两个集合元素一样，list1不变，方法返回false；
		// 两个集合元素不一样，list1要么为空，要么为交集部分，返回true
		boolean result4 = list1.retainAll(list2);
		System.out.println("没有交集？>>" + result4);
		System.out.println(list1);

		// 用Iterator实例取出容器元素
		for (Iterator it = list1.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
