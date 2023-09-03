
public class Dog {
	private String name;
	private int age;
	
	public Dog (String name){
		this.name = name;
	}
	
	public Dog (String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	
	public String toString() {
		return "Dog "+ this.name + " of age " + this.age;
	}
	
	public boolean equals(Dog another) {
		if(this.name == another.name 
				&& this.age == another.age)
			return true;
		return false;
	}

}
