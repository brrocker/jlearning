package object;

public class Calculate<T> {
	private T t;
	
	public void set(T t){
		this.t = t;
	}

	public T get(){
		return t;
	}
}
