import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

/**
 * 该类实现TCP协议双方的服务器开发
 * @author DELL
 *2017-12-11
 */
public class ServerThreadsDeal  extends Thread{
	Scanner keyboard = new Scanner(System.in);
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public ServerThreadsDeal(Socket socket)
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
	
	//线程所要执行的具体任务
	public void run()
	{
		try{
			System.out.println("已连接到客户端，客户端为 " + socket);
			System.out .println();
			System.out .println("-------------------------------------");
			System.out .println("-------------------------------------");
			System.out .println("交流开始>>");
			
			//显示交流开始日期
			System.out.println();
			System.out .println("--------时间>>"+new Date()+"---------------");
			System.out.println();
			
			//打招呼
			String str0 = "Hello,我是服务端,很开心接到你的信息。";
			out.println(str0);
			System.out .println("服务端>>"+str0);
			
			//接受招呼
			String str1=in.readLine();
			System.out .println("客户端>>"+str1);
			
			//判断是否结束会话
			if (!(str1.equalsIgnoreCase(("quit")))) 
			{
				while (true) {

					String str2 = in.readLine();
					System.out.println("客户端>> " + str2);
					
					//显示中间时期
					System.out.println();
					System.out .println("--------时间>>"+new Date()+"---------------");
					System.out.println();

					if (str2.equalsIgnoreCase(("quit"))) 
					{
						System.out . println("-------------会话结束-----------------");
						break;
					}
					// 回复客户端
					System .out .print("服务端>>");
					String str4 = keyboard.nextLine();
					out.println(str4);
					
					//判断是否结束会话
					if (str4.equalsIgnoreCase(("quit"))) 
					{
						System.out . println("-------------会话结束-----------------");
						break;
					}
					
					//显示结束日期
					System.out.println();
					System.out .println("--------时间>>"+new Date()+"---------------");
					System.out.println();
				}
			}
			else
			{
				System.out . println("-------------会话结束-----------------");
			}
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


