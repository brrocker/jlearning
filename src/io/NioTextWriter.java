package io;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import basic.Ut;

public class NioTextWriter {
	public static void main(String args[]) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("D:/tmp/input.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		
		//写入数据
		/*String newData = "New String to write to file..." + System.currentTimeMillis();
		 
		buf.clear();
		buf.put(newData.getBytes());
		 
		buf.flip();
		 
		while(buf.hasRemaining()) {
			inChannel.write(buf);
		}
		Ut.pt(inChannel.position());*/

		
		//读取数据
		buf.clear();
		//buf.flip();
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
