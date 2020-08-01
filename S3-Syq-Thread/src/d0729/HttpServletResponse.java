package d0729;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class HttpServletResponse {
	
	// 通过 Socket 获取的输出流
	private OutputStream out;
	private int status;
	private String msg;
	
	public HttpServletResponse(OutputStream out) {
		this.out = out;
	}
	
	// 资源流 字符串输出流,  将输出内容保存到一个字符串中
	private CharArrayWriter caw = new CharArrayWriter();
	// 处理流
	private PrintWriter pw = new PrintWriter(caw);

	
	public PrintWriter getWriter() {
		return pw;
	}
	
	
	public void setStatus(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	
	public void flushBuffer() throws IOException {
		// 响应头行
		out.write(("HTTP/1.1 " + status + " " + msg + "\n").getBytes());
		// 响应头域
		out.write(("Content-Type: text/html; charset=utf-8\n").getBytes());
		// 空行 CRLF
		out.write("\n".getBytes());
		// 实体
		out.write(caw.toString().getBytes());
	}

}