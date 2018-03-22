
## 深度解析Class类
 #### 1.谈谈forName()，getClass(),和  .class
  >(1)forName()属于Class的静态方法，`class Class{ ... static Class forName(String str){ .... retuen.... } ... }`调用它
 使用Class.forName(..)
 
  >(2)getClass()属于Object类，其他类覆盖，返回Class引用，调用它例如`String obj=new String ;obj.getClass()`
 产生一个Class引用，该对象封装了其他类的类型信息，比如str的所属类名。
 
  >(3) .class 类字面常量可以返回Class的引用，例如`Class c=String.class`
  三者区别：显而易见，forName属于Class调用，getClass属于其他被封装类调用。调用者不同
 而forName与.class的区别在于。。。。下面具体阐述
#### 2.forName(...)与.class区别解析
  >(1)forName和.class的调用者不同
  
  >(2)forName("String")在使用Class对象封装String类型信息时，会创建Class对象的引用（加载），链接，
 初始化。说明：链接（其实就是在分配存储空间），初始化：String类的静态成员（给分配
 的存储空间初始化）
 
  >(3)调用Class c=String.class时会创建Class对象的引用，但不会初始化该对象,直到使用到类的静态成员时
 才会被初始化或者加载这个类。类的静态成员即static语句，包括构造器（隐式静态方法）
 
 #### 3.下面四个demo值得研究（Demo21,Demo22,Demo23,Demo2）
 ```java
 public class Demo_21 {
	static final int staticFinal1=1;         //编译期常量，在初始化前就被加载
	static final int staticFinal2=Demo_2.rand.nextInt(1000);   //
	static {                                        //典型的静态成员，初始化时就会被加载
		System.out.println("------------------------");
		System.out.println("Demo21初始化");
	}
}

public class Demo_22 {
	static int staticNoFinal=2;      //静态变量，在初始化时才被加载到存储空间中（静态区）
	static {
		System.out.println("------------------------");
		System.out.println("Demo22被初始化");
	}
}

public class Demo_23 {
	static int staticNoFinal=3;
	static {
		System.out.println("------------------------");
		System.out.println("Demo23被初始化");
		
	}
}

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

 ```
 ------------------------
 运行结果
 ```java
 ------------------------
Demo2被初始化
开始操作
1
------------------------
Demo21初始化
258
------------------------
Demo22被初始化   注意这里的输出先后顺序，先输出这句话
2                后输出2     证明程序先初始化了Demo22,后获取变量的
-------------
------------------------
Demo23被初始化
结束操作

 ```
 >(1)static final成员（包括变量和方法）：编译期变量，在程序编译时就被加载，运行时直接获取即可
 
 >(2)单独static语句：静态成员变量只有所属类被加载初始化后才能被获取。类的初始化就是将静态成员
 							加载到静态区，这些成员始终随着类，而不是类的对象。
              
 >(3)final语句：常量区
