/*深度解析Class类
 1.谈谈forName()，getClass(),和  .class
 >>(1)forName()属于Class的静态方法，`class Class{ ... static Class forName(String str){ .... retuen.... } ... }`调用它
 使用Class.forName(..)
 >>(2)getClass()属于Object类，其他类覆盖，返回Class引用，调用它例如`String obj=new String ;obj.getClass()`
 产生一个Class引用，该对象封装了其他类的类型信息，比如str的所属类名。
 >>(3) .class 类字面常量可以返回Class的引用，例如`Class c=String.class`
 >>>三者区别：显而易见，forName属于Class调用，getClass属于其他被封装类调用。调用者不同
 而forName与.class的区别在于。。。。下面具体阐述
 2.forName(...)与.class区别解析
 >>(1)forName和.class的调用者不同
 >>(2)forName("String")在使用Class对象封装String类型信息时，会创建Class对象的引用（加载），链接，
 初始化。说明：链接（其实就是在分配存储空间），初始化：String类的静态成员（给分配
 的存储空间初始化）
 >>(3)调用Class c=String.class时会创建Class对象的引用，但不会初始化该对象,直到使用到类的静态成员时
 才会被初始化或者加载这个类。类的静态成员即static语句，包括构造器（隐式静态方法）
 
 >>>>下面四个demo值得研究（Demo21,Demo22,Demo23,Demo2）
 static final成员（包括变量和方法）：编译期变量，在程序编译时就被加载，运行时直接获取即可
 单独static语句：静态成员变量只有所属类被加载初始化后才能被获取。类的初始化就是将静态成员
 							加载到静态区，这些成员始终随着类，而不是类的对象。
 final语句：常量去
 
 */
public class Demo_21 {
	static final int staticFinal1=1;         //编译期常量，在初始化前就被加载
	static final int staticFinal2=Demo_2.rand.nextInt(1000);   //
	static {                                        //典型的静态成员，初始化时就会被加载
		System.out.println("------------------------");
		System.out.println("Demo21初始化");
	}
}
