package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import basic.Ut;

public class ThreadTest5 {
	ReentrantLock lock = new ReentrantLock();
	
	public void start(){
		ExecutorService services = Executors.newCachedThreadPool();
		//ExecutorService services = Executors.newFixedThreadPool(1);
		for (int i=0;i<10;i++){
			services.execute(new LocalThread(String.valueOf(i)));
		}
		services.shutdown();
	}
	
	private class LocalThread implements Runnable {
		private String name;
		
		public LocalThread(String name){
			this.name = name;
		}
		
		public void run(){
			try{
				lock.lock();
				for (int i=0;i<10;i++){
					Ut.pt(name+ "-" +i);
					Thread.sleep(10);
				}
				lock.unlock();
			}catch(Exception e){
				
			}finally{
			}
			
		}
	}
}
