
public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=new String();
		Class class1=str.getClass();
		System.out.println("String类的信息>>>");
		System.out.println("--------全类名>>>"+class1.getName());
		System.out.println("--------单一名称>>>"+class1.getSimpleName());
		System.out.println("--------全名>>>"+class1.getCanonicalName());
		System.out.println("--------父类>>>"+class1.getSuperclass().getName());
		System.out.println("--------接口？"+class1.isInterface());

		System.out.println("Class类型自身信息>>>");
		Class class2=class1.getClass();
		System.out.println("--------全类名>>>"+class2.getName());
		System.out.println("--------单一名称>>>"+class2.getSimpleName());
		System.out.println("--------全名>>>"+class2.getCanonicalName());
		System.out.println("--------父类>>>"+class2.getSuperclass().getName());
		System.out.println("--------接口？"+class2.isInterface());;
	}

}
