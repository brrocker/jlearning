package thread;

import java.util.Map;

import basic.Ut;

public class ThreadNotify implements Runnable{
	private String name;
	private Map map;
	
	public ThreadNotify(String name){
		this.name = name;
	}
	
	public ThreadNotify(String name, Map map){
		this.name = name;
		this.map = map;
	}
	
	public void run(){
			synchronized(map){
				try {
					Thread.sleep(200);
					map.notifyAll();
					Ut.pt("Notify!!!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
