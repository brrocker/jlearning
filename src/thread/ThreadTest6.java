package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import basic.Ut;

public class ThreadTest6 {
	BlockingQueue<Integer> queue= new LinkedBlockingQueue<Integer>(3);
	
	public void start(){
		ExecutorService services = Executors.newCachedThreadPool();
		services.execute(new ProduceThread());
		services.execute(new ConsumeThread());
		
		services.shutdown();
	}
	
	private class ProduceThread implements Runnable {
		public void run(){
			try{
				for (int i=0;i<10;i++){
					queue.put(i);
					Ut.pt("put"+ "-" +i);
					Thread.sleep((int) (Math.random() * 1000));
				}
			}catch(Exception e){
				
			}finally{
			}
			
		}
	}
	
	private class ConsumeThread implements Runnable {
		public void run(){
			try{
				for (int i=0;i<10;i++){
					int num = queue.take();
					Ut.pt("take"+ "-" +num);
					Thread.sleep((int) (Math.random() * 1000));
				}
			}catch(Exception e){
				
			}finally{
			}
			
		}
	}
}
