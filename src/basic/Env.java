package basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import object.Dog;
import object.Woman;
import thread.ThreadNotify;
import thread.ThreadNotify2;
import thread.ThreadTest;
import thread.ThreadTest2;
import thread.ThreadTest3;
import thread.ThreadTest4;
import thread.ThreadTest5;
import thread.ThreadTest6;

public class Env {
	public static void main(String[] a) throws Exception {
		Ut.pt("Hello World!");
		/*Apple a1 = new Apple();
		a1.appleColor = Apple.color.blue;*/
		
		//testAssert(1);
		//String t1 = "111";
		//Ut.pt(t1 instanceof String);
		//testIO();
		//testIO3();
		//testObject();
		//testMap();
		/*Calculate<String> cal = new Calculate<String>();
		cal.set("123");
		Ut.pt(cal.get());*/
		
		/*int sum = 0;
		
		Thread t1 = new Thread(new ThreadTest("Ta", sum));
		t1.start();
		t1.join();
		Ut.pt("Process End");*/
		
		
		/*Map map = new HashMap();
		map.put("sum", 0);*/
		/*Thread t1 = new Thread(new ThreadTest("Ta", map));
		Thread t2 = new Thread(new ThreadTest("Tb", map));
		Thread notify = new Thread(new ThreadNotify("notify", map));
		t1.start();
		t2.start();
		notify.start();
		t1.join();
		t2.join();
		Ut.pt("final sum:" + map.get("sum"));*/
		/*ThreadTest2 th2 = new ThreadTest2("Ta", map);
		Thread t1 = new Thread(th2);
		Thread t2 = new Thread(th2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		ThreadTest3 th3 = new ThreadTest3("Th3", map);
		th3.start();
		
		ThreadNotify2 tn = new ThreadNotify2();
		tn.doCallback(th3, 2000);
		
		Ut.pt("final sum:" + map.get("sum"));*/
		
		/*ExecutorService services = Executors.newCachedThreadPool();
		for (int i=0;i<10;i++){
			services.execute(new ThreadTest4(String.valueOf(i)));
		}
		
		services.shutdown();
		services.awaitTermination(10, TimeUnit.DAYS);
		Ut.pt("process finish!");*/
		
		/*ThreadTest5 th5 = new ThreadTest5();
		th5.start();*/
		
		/*ThreadTest6 th6 = new ThreadTest6();
		th6.start();*/
		
		
		
		//Ut.pt(result.getClass() == String.class);
		
		//testByteArr();
		
		transferHex();
	}
	
	public static void testByteArr() throws UnsupportedEncodingException {
		String name = "肖奕";
		
		byte[] data = new byte[64];
		
		byte b[] = name.getBytes("GB2312");
		Ut.pt(Arrays.toString(b));
		
		System.arraycopy(b, 0, data, 0, b.length);
		Ut.pt(Arrays.toString(data));
		
		String newStr = new String(data, "GB2312");
		newStr = newStr.substring(0,newStr.indexOf('\u0000')); 
		Ut.pt(newStr);
	}
	
	public static void transferHex(){
		String data = "C000BE0200000100D5C5C8FD000000000000000000000000000000000000000000000000000000003200000000000000000000000000000000000000000000000000000000000000323031372D31312D30372031303A30383A35310032000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000020030303130303400000000000000000000000000000000000000000000000000000100";
		StringBuffer newdata = new StringBuffer();
		char[] arr = data.toCharArray();
		for(int i = 0;i<arr.length;i++){
			if(i%2 == 0){
				newdata.append(",0x");
			}
			newdata.append(arr[i]);
		}
		
		Ut.pt(newdata);
	
	}
	
	public static void testMap(){
		Map map = new HashMap();
		map.put("a", "aaa");
		map.put("b", "bbb");
		
		Iterator<Entry> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry item = it.next();
			Ut.pt(item.getValue());
		}
	}
	
	public static void testAssert(int i){
		assert i>0;
		Ut.pt("After assert 1!");
		
		assert i<0:"i is not < 0";
		Ut.pt("After assert 2!");
	}
	
	public static void testIO() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c;
		do{
			c = (char)br.read();
			Ut.pt(c);
		} while(c != 'q');
		
		Ut.pt("--end--");
	}
	
	public static void testIO1(){
		InputStream is = null;
		OutputStream os = null;
		try{
			is = new FileInputStream("d:/test.txt");
			os = new FileOutputStream("d:/test1.txt");
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=is.read(buffer))!=-1) {
				os.write(buffer, 0, count);
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	public static void testIO2(){
		try{
			Reader reader = new FileReader("d:/test.txt");
			BufferedReader br = new BufferedReader(reader);
			StringBuffer sb = new StringBuffer();
			String data;
			while((data=br.readLine())!=null){
				sb.append(data);
			}
			
			Ut.pt(sb);
		}catch(IOException e){
			
		}
	}
	
	public static void testIO3(){
		try{
			Writer writer = new FileWriter("d:/test2.txt", true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("123");
			bw.newLine();
			bw.write("456");
			bw.newLine();
			bw.flush();
			bw.close();
		}catch(Exception e){
			
		}
	}
	
	public static void testObject(){
		Woman wo = new Woman("helen");
		Ut.pt(wo.callName());
	}
}

class Apple {
	enum size{SMALL, MEDIUM, LARGE }
	enum color{red, blue, yellow }
	
	size appleSize;
	color appleColor;
}
