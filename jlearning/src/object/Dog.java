package object;

public class Dog {
	private String name;
	
	public Dog() {
		this.name = "Echo";
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
