package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Martin Xiao
 *
 */
public class TestLock {
	static AtomicInteger currentIndex = new AtomicInteger(0);
	static LongAdder num2 = new LongAdder();
	static int num3=0;
	
	public static void main(String[] a) {
		test2();
	}
	
	public static void test1(){
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		long startTime = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<100000000;i++){
						currentIndex.getAndIncrement();
					}
				}
			});
		}
		
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("所用时间:" + (System.currentTimeMillis() - startTime));
		System.out.println("结果"+currentIndex);
	}
	
	public static void test2(){
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		long startTime = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<100000000;i++){
						num2.increment();
					}
				}
			});
		}
		
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("所用时间:" + (System.currentTimeMillis() - startTime));
		System.out.println("结果"+num2);
	}
	
	public static synchronized void add() {
		num3++;
	}
	
	public static void test3(){
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		long startTime = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<100000000;i++){
						add();
					}
				}
			});
		}
		
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("所用时间:" + (System.currentTimeMillis() - startTime));
		System.out.println("结果"+num3);
	}
}
