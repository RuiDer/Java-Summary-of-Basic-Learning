import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 此类实现用LinkedList制作栈。栈：先进后出，栈顶进行插入和删除。
 * @author DELL
 *2017-12-18
 */
public class ListTest2 {
	
	private LinkedList list=new LinkedList<>();
	
	//是否为空
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	//实现查询栈顶元素
	public Object top()
	{
		return list.getFirst();
	}
	
	
	//实现栈的插入方法
	public void push(Object element)
	{
		list.addFirst(element);
	}
	
	//从栈顶pop
	public void pop()
	{
		list.removeFirst();
	}
	
	public String  toString()
	{
		return list.toString();
	}


	public static void main(String[] args) {
		
		Person[] stu =new Person[]{new Person("De", 20),new Person("jim", 19),new Person("qane", 21)};
		
		ListTest2 mockStack=new ListTest2();
		for(int n=0;n<stu.length;n++)
		{
			mockStack.push(stu[n]);
		}
		System.out.println("当前成员>>"+mockStack);
		
		//查询栈顶元素
		System.out.println("栈顶元素>>"+mockStack.top().toString());
		//删除栈顶元素
		mockStack.pop();
		System.out.println("当前成员>>"+mockStack.toString());
		
		mockStack.push("a");
		mockStack.push("ab");
		mockStack.push("abc");
		System.out.println("当前成员>>"+mockStack.toString());
	}

}
