package thread;

import java.util.Map;

import basic.Ut;

public class ThreadTest3 implements CallBack{
	private String name;
	private Map map;
	private boolean flag = false;
	
	public ThreadTest3(String name){
		this.name = name;
	}
	
	public ThreadTest3(String name, Map map){
		this.name = name;
		this.map = map;
	}
	
	public void enable(){
		this.flag = true;
	}
	
	public void start(){
		Thread th = new Thread(new LocalThread());
		th.start();
	}
	
	class LocalThread implements Runnable {
		public void run(){
			Ut.pt("yield start!");
			while(!flag) {
				Thread.yield();
			}
			Ut.pt("yield end!");
			
			for(int i=0;i<5;i++){
				synchronized(map){
					try {
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

	@Override
	public void onCallBack() {
		enable();
	}
	
	
}
