package javaIO;

/**
 * 对象序列化需要使用的类
 * @author Stone
 *
 */
public class PersionSerializable implements java.io.Serializable {
	private String name;
	private transient int age; // 用transient修饰的属性不会被序列化
	public  PersionSerializable(String name,int age) {
		this.name=name;
		this.age=age;
		System.out.println("无参数构造器噢");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
