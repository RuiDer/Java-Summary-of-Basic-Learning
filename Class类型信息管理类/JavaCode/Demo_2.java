import java.util.Random;

public class Demo_2 {

	static Random rand = new Random(47);
	static {
		System.out.println("------------------------");
		System.out.println("Demo2被初始化");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class class1 = Demo_21.class; // 获取Demo21的类型信息，不会初始化Class1,类加载器也不会加载Demo21
		System.out.println("开始操作");
		System.out.println(Demo_21.staticFinal1);//直接获取编译期变量，同时也会加载类Demo21
		System.out.println(Demo_21.staticFinal2);
		System.out.println(Demo_22.staticNoFinal);//先加载后初始化，再获取输出。
		System.out.println("-------------");
		try {
			Class class2 = Class.forName("Demo_23"); //加载class2并初始化，Demo23也被加载和初始化
		} catch (ClassNotFoundException e) {
		}
		finally{
			System.out.println("结束操作");
		}
	}

}
