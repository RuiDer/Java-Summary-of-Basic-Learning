public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setName(int age)
	{
		this.age=age;
	}

	public String toString()
	{
		return "name>> "+this .name+"\nAge>> "+this.age;
	}
}