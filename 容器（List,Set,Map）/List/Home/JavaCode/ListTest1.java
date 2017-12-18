
import java.util.List;
import java.util.ArrayList;

public class ListTest1 {
	public static void main(String[] args) {

		// 创建List集合对象，即list容器
		List list = new ArrayList();

		// 添加对象元素
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");

		System.out.println("原集合>>" + list);

		// 根据角标，在指定位置添加元素，角标不能超过size大小
		list.add(1, "abc4");
		System.out.println("添加后>>" + list);

		// list.add(5,"abc5"); //不能越界

		// 根据角标移除元素
		// list.remove(1); //remove(int index)这个方法返回值为删除的元素值
		System.out.println("删除" + list.remove(1) + "成功");
		System.out.println("原集合变为>>" + list);

		// 根据角标修改元素值
		// set()方法返回一个被修改的元素值
		// list.set(0,"abc0");
		System.out.println("set(0,abc0)>>" + list.set(0, "abc0"));

		// 查找元素：根据角标查找元素
		System.out.println("list.get(1)>>"+list.get(1));
		
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
