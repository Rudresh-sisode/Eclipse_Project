package co.edureka.model;

public class Student {
	public int roll;
	public String name;
	public String email;
	public int age;
	public String address;
	
	public Student()
	{
		
	}

	public Student(int roll, String name, String email, int age, String address) {
		
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", age=" + age + ", address=" + address
				+ "]";
	}
	

}
