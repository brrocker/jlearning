package thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import basic.Ut;

public class ThreadTest7 {
	public void start(){
		ExecutorService services = Executors.newCachedThreadPool();
		CompletionService<String> completionService = new ExecutorCompletionService<String>(services);
		for(int i=0;i<10;i++){
			completionService.submit(new ProduceThread());
		}
		
		for(int i=0;i<10;i++){
			String result;
			try {
				result = completionService.take().get();
				Ut.pt(result);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		services.shutdown();
	}
	
	private class ProduceThread implements Callable<String> {
		public String call(){
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "num"+(new Random().nextInt(100));
		}
	}
	
	public static void main(String[] a){
		ThreadTest7 th = new ThreadTest7();
		th.start();
	}
	
}
