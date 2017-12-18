import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.sound.sampled.LineListener;
/*
 * 集合框架 练习1，对单个元素的操作：add(),contains();remove(),size(),isEmpty(),clear()以及输出所有元素。
 */

public class CollectionTest_1 {

	public static void main(String[] args) {
		
Collection list=new ArrayList();  //创建集合对象，也就是一个容器
		
		//添加对象
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");

		//查询集合元素个数
		int size=list.size();
		System.out.println("list集合长度>>"+size);
		//删除对象操作
		boolean isRemoved=list.remove("abc1");
		if(isRemoved)
		{
			System.out .println("删除"+"abc1"+"成功");
		}
		else{
			System.out .println("删除"+"abc1"+"失败");
		}
		
		
		//查询所有集合元素
		System.out .println(list);

		//查询某个元素是否在集合里
		System.out .println("abc3是否在集合中"+list.contains("abc3"));
		System.out .println("abc5是否在集合中"+list.contains("abc5"));

		//删除所有元素
		list.clear();
		System.out .println(list);

		//是否为空
		System.out .println(list.isEmpty());
 
		
		
		//查询所有集合元素
		System.out .println(list);
	}

}
