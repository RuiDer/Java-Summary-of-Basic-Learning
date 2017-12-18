import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
public class CollectionTest3
{
	public static void main(String[] args){
		
		//创建集合对象list,也就是容器
		Collection list=new ArrayList();

		//实例化对象
		Person m1=new Person("张三",20);
		Person m2=new Person("李四",21);
		Person m3=new Person("王五",22);

		//给容器添加元素
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		//System.out.println(m1.getClass());
		//System.out.println(m1.hashCode());

		//提取元素
		for(Iterator it=list.iterator();it.hasNext();)
		{
			//System.out.println(it.next());                                      //获取对象的hashCode
			//System.out.println(((Person)it.next()).toString());     //将Object强制转化为Person，然后取出。
			
			//next()方法多用的后果，next()忌多写
			System.out.println(((Person)it.next()).getName()+"------"+((Person)it.next()).getAge());
		}
	}

}