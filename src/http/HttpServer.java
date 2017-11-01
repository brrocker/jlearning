package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;

import basic.Ut;

public class HttpServer implements Runnable {
	public static int PORT = 80;
	ServerSocket server;
	
	public void start() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(server != null) {
			new Thread(this).start();
			Ut.pt("Server Start!");
		}
	}
	
	public void close(){
		try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(true){
			try {
				Socket client = null;
				client = server.accept();
			
				if(client != null){
					BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
					String line = br.readLine();
					Ut.pt(line);
					
					String resource=line.substring(line.indexOf('/'),line.lastIndexOf('/')-5);
					resource=URLDecoder.decode(resource, "UTF-8");
					
					while((line = br.readLine()) != null) {
						Ut.pt(line);
						if(line.equals("")) break;
					}
					
					//Send the http response
					PrintWriter out = new PrintWriter(client.getOutputStream());
					out.println("HTTP/1.0 200 OK");
					out.println("Content-Type:text/html;charset=UTF-8");
					out.println();
					
					//print content
					out.println("<h1> Hello, this is reponse from java server!</h1>");
					out.println(resource);
					out.close();
					client.close();
					Ut.pt("Connection closed!");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
