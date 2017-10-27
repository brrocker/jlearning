package thread;

import java.util.Map;

import basic.Ut;

public class ThreadTest implements Runnable{
	private String name;
	private Map map;
	
	public ThreadTest(String name){
		this.name = name;
	}
	
	public ThreadTest(String name, Map map){
		this.name = name;
		this.map = map;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			synchronized(map){
				try {
					if(i==0) map.wait();
					int sum = (int) map.get("sum");
					Ut.pt(name + " start:" + sum);
					Thread.sleep((long) (Math.random() * 100) + 100);

					sum += i;
					Ut.pt(name + " end:" + sum);
					map.put("sum", sum);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
