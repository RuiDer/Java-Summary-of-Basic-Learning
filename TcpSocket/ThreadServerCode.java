import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.DocFlavor.STRING;

/**
 * 该类实现TCP协议双方的服务器开发
 * @author DELL
 *2017-12-11
 */
public class ThreadServerCode  extends Thread{
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public ThreadServerCode(Socket socket)
	{
			this.socket=socket;               //获得客户端socket的句柄
			try
			{
				//打开IO流
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out=new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())),true);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			//开启线程
			start();
	}
	public void run()
	{
		try{
			//接受客户端的信息并输出
			String clientInfo=in.readLine();                                   
			System.out.println("client message>>"+clientInfo);
			
			String string="hello,我是服务端";
			out.println(string);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
			{
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.close();
			}
		}
}


