package object;

public class Woman extends People {
	public Woman(String name){
		super(name);
	}
	
	public String callName(){
		return getName();
	}
}
