package thread;

import basic.Ut;

public class ThreadTest4 implements Runnable {
	private String name;
	
	public ThreadTest4(String name){
		this.name = name;
	}
	
	public void run(){
		int sum = 0;
		for(int i=0;i<5;i++){
			try {
				Ut.pt(name +"-"+ i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
