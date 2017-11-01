package basic;

import http.HttpServer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] a) throws ParseException {
		Ut.pt("Hello!");
		//testNumber();
		//testdate();
		//testreg();
		//Map map = new HashMap(100);
		//int[] arr = {2,4,6,8,10,20,30,40,50};
		//Ut.pt(binSearch(arr,-99));
		
		Sorting sort = new Sorting();
		int[] arr = sort.getIntArray(20);
		//sort.selectSort(arr);
		//sort.quickSort(arr);
		
		HttpServer server = new HttpServer();
		server.start();
	}
	
	public static int binSearch(int[] arr, int num) {
		int start=0;
		int end = arr.length - 1;
		int max = arr.length - 1;
		while(start <= end && start <= max && end >= 0) {
			int mid = (end + start)/2;
			if(arr[mid]==num){
				return mid;
			} else if (arr[mid]>num) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void testNumber(){
		byte a = 10;
		int b = 100;
		long c = 1000L;
		float d = 2.22f;
		double e = 3.33;
		int i = (int)(Math.random()*100);
		Ut.pt(i);
		
		int u = 1000;
		int y = 1000;
		Ut.pt(u==y);
		
		int[] numarr = new int[10];
		numarr[0] = 1;
		int[] numarr2 = {1,2,3,4};
		
		for(int q1: numarr2) {
			Ut.pt(q1);
		}
	}
	
	public static void testString(){
		char ch = 'a';
		char[] charr = {'a','b','c'};
		//Ut.pt(Character.isLetter(ch));
		String s1 = new String(charr);
		Ut.pt(s1);
		String blog = "qqq,www,eee,rrr,ttt,yyy,uuu,iii,ooo~";
		char[] arr = blog.toCharArray();
		int count = 0;
		for(int i=0; i<arr.length; i++ ){
			if(arr[i] == ','){
				count++;
				if(count%2==0){
					arr[i] = '.';
				}
			}
		}
		
		blog = new String(arr);
		//Ut.pt(blog);
		
		StringBuffer sb = new StringBuffer();
		sb.append("asdf");
		Ut.pt(sb.indexOf("sd"));
		
		
	}
	
	public static void testdate() throws ParseException{
		Date now = new Date();
		Ut.pt(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh.mm.ss");
		Ut.pt(sdf.format(now));
		String d2str = "2011.11.09";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
		Date d2 = sdf2.parse(d2str);
		Ut.pt(d2);
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(now);
		c1.add(Calendar.DATE, 10);
		
		Ut.pt(sdf.format(c1.getTime()));
	}
	
	public static void testreg() {
		String text = "fasf7fsf8ads9oo";
		Ut.pt(Pattern.matches(".*23.*", "123aaa"));
		Pattern pat = Pattern.compile("\\d");
		Matcher m = pat.matcher(text);
		while(m.find()){
			Ut.pt(m.start()+","+m.end());
		}
		
	}
}
