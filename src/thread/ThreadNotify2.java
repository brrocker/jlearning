package thread;

import java.util.Map;

import basic.Ut;

public class ThreadNotify2 {
	
	public void doCallback(CallBack cb, long timeOut){
		Thread th = new Thread(new CallBackThread(cb, timeOut));
		th.start();
	}
	
	private class CallBackThread implements Runnable {
		private CallBack cb;
		private long timeOut;
		
		public CallBackThread(CallBack cb, long timeOut){
			this.cb = cb;
			this.timeOut = timeOut;
		}
		
		public void run(){
			try {
				Thread.sleep(timeOut);
				cb.onCallBack();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
