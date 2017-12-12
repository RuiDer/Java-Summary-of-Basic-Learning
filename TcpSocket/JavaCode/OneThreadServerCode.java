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

public class OneThreadServerCode { // 设置端口号

	public static int portNo = 3333;

	public static void main(String[] args) throws IOException

	{
		Scanner keyboard = new Scanner(System.in);
		ServerSocket s = new ServerSocket(portNo);
		
		//显示初始时间
		System.out.println();
		System.out .println("--------时间>>"+new Date()+"---------------");
		System.out.println();
		
		System.out.println("服务开始工作啦！\n正在等待顾客的到来！！！");

		// 阻塞,直到有客户端连接
		Socket socket = s.accept();
		try {
			System.out.println("已连接到客户端，客户端为 " + socket);
			System.out .println();
			System.out .println("-------------------------------------");
			System.out .println("-------------------------------------");
			System.out .println("交流开始>>");
			
			//显示交流开始日期
			System.out.println();
			System.out .println("--------时间>>"+new Date()+"---------------");
			System.out.println();
			
			// 设置IO句柄
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			
			//打招呼
			String str0 = "Hello,我是服务端,很开心接到你的信息。";
			out.println(str0);
			System.out .println("服务端>>"+str0);
			
			//接受招呼
			String str1=in.readLine();
			System.out .println("客户端>>"+str1);
			
			while (true) {

				String str2 = in.readLine();
				System.out.println("客户端>> " + str2);
				
				//显示中间时期
				System.out.println();
				System.out .println("--------时间>>"+new Date()+"---------------");
				System.out.println();

				if (str2.equalsIgnoreCase(("quit"))) 
				{
					break;
				}
				// 回复客户端
				System .out .print("服务端>>");
				String str4 = keyboard.nextLine();
				out.println(str4);
				
				//显示结束日期
				System.out.println();
				System.out .println("--------时间>>"+new Date()+"---------------");
				System.out.println();
			}
		} finally {
			
			System.out.println("会话结束.");
			socket.close();
			s.close();
		}
	}
}