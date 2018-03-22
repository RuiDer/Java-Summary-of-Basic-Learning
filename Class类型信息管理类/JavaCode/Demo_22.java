
public class Demo_22 {
	static int staticNoFinal=2;      //静态变量，在初始化时才被加载到存储空间中（静态区）
	static {
		System.out.println("------------------------");
		System.out.println("Demo22被初始化");
	}
}
