package object;

public abstract class People {
	private String name;
	public abstract String callName(); 
	
	public People(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
