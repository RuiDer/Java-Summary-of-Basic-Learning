import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import org.ietf.jgss.Oid;

/**
 * 该类实现了TCP协议双方中的客户端，并且实现多线程
 * @author DELL
 *2017-12-11
 */
public class ClientThreadsDeal extends Thread {
	Scanner keyboard=new Scanner(System.in);
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String Ip=null;
	private int port;
	
	public ClientThreadsDeal(Socket socket)
	{
		try
		{
			this.socket =socket;
			
			//打开IO流，并获得输入输出
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())),true );
			
			//启动线程
			start();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//线程具体工作内容
	public void run()
	{
		try{   
			//打招呼
			System.out .println("客户端>>Hello,I am 客户端!!");
			out.println("Hello,I am 客户端!!" );
			//接受问候
			String str0=in.readLine();
			System.out .println("服务端>>"+str0);
			
			//显示时间
			System.out.println();
			System.out .println("--------时间>>"+new Date()+"---------------");
			System.out.println();
			while(true)
			{
				//向服务器发送信息，进行主动交流
				System.out.print("客户端>>");
				String str1=keyboard.nextLine();
				out.println(str1);
				
				//显示时间
				System.out.println();
				System.out .println("--------时间>>"+new Date()+"---------------");
				System.out.println();
				
				//是否结束交流标志
				if(str1.equalsIgnoreCase("Quit"))
				{
					break;
				}
				//接受服务端信息
				String str2=in.readLine();
				System.out . println("服务器>>"+str2);	
				
				//判断是否结束会话
				if(str2.equalsIgnoreCase("Quit"))
				{
					break;
				}
				
				//显示时间
				System.out.println();
				System.out .println("--------时间>>"+new Date()+"---------------");
				System.out.println();
			}
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
		finally {
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
