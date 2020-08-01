package d0725;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
 
public class WorkClient {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//1.创建socket，连接到服务端
		Socket socket = new Socket("localhost",8888);
		
		//2.获取输出流，向服务端发送信息
		//字节输出流
		OutputStream os = socket.getOutputStream();
		//将输出流包装成打印流
		PrintWriter pw = new PrintWriter(os);
 
		//3.获取输入流，读取文件中的信息
		//文件输入流
		InputStream in = new FileInputStream("D://a.txt");
		InputStreamReader isr = new InputStreamReader(in,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		
		while((str = br.readLine())!=null){
			System.out.println("文件读取内容为： "+str);
			pw.write(str+"\r\n");
			pw.flush();
			Thread.sleep(1000);
		}
		
		pw.close();
		br.close();
		in.close();
		os.close();
	}
}	
	