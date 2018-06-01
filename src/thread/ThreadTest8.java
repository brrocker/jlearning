package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import basic.Ut;

public class ThreadTest8 {
	public void start() throws InterruptedException{
		Thread t1 = new Thread(new LocalThread("t1"));
		t1.setDaemon(true);
		t1.start();
		TimeUnit.SECONDS.sleep(10);
		//t1.interrupt();
		//TimeUnit.SECONDS.sleep(3);
		Ut.pt("main end---");
	}
	
	private class LocalThread implements Runnable {
		private String name;
		
		public LocalThread(String name){
			this.name = name;
		}
		
		public void run(){
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					Ut.pt("ShutdownHook-------------");
				}
			});
			
			Ut.pt("thread start---------");
			try{
				while(true) {
					TimeUnit.SECONDS.sleep(3);
					Ut.pt("sleep-----");
				}
			}catch(Exception e){
				Ut.pt("thread interrupt---------");
			}finally{
				Ut.pt("finally end---------");
			}
			
		}
	}
	
	public static void main(String[] a) throws InterruptedException{
		ThreadTest8 th = new ThreadTest8();
		th.start();
	}
}
