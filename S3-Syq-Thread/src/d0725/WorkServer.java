package d0725;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
public class WorkServer {
	
	public static void main(String[] args) throws IOException{
		//1.创建服务端
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("服务器启动成功, 监听 8888 端口");
		//接收客户端
		Socket socket = null;
		
		//2.获取输出流，向文件中写入内容
		File f = new File("d:/newIn.txt");
		FileOutputStream out = new FileOutputStream(f);
		String str = null;
		
		//3.获取输入流
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String nextLine = System.getProperty("line.separator"); 
		while(true){
			socket = ss.accept();
			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			while((str = br.readLine())!=null){
				System.out.println("接收到的数据："+str);
				out.write((str+nextLine).getBytes());
				out.flush();
			}
			out.close();
			System.exit(0);
		}
		
		
		
	}
}