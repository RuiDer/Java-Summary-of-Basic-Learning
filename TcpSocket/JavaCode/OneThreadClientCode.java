import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class OneThreadClientCode {
	static String clientName = "Mike";
	// 端口号
	public static int portNo = 3333;

	public static void main(String[] args) throws IOException {
		Scanner keyboard=new Scanner(System.in);
		
		// 设置连接地址类,连接本地
		InetAddress addr = InetAddress.getByName("localhost");
		
		// 要对应服务器端的3333端口号
		Socket socket = new Socket(addr, portNo);
		try {
			System .out .println("这里是客户端：");

			// 设置IO句柄
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			//打招呼
			System.out .println("客户端>>Hello,I am 客户端!!");
			out.println("Hello,I am 客户端!!" );
			//接受问候
			String str0=in.readLine();
			System.out .println("服务端>>"+str0);
			
			while(true)
			{
				//向服务器发送信息，进行主动交流
				System.out.print("客户端>>");
				String str1=keyboard.nextLine();
				out.println(str1);
				
				//是否结束交流标志
				if(str1.equalsIgnoreCase("Quit"))
				{
					break;
				}
				//接受服务端信息
				String str2=in.readLine();
				System.out . println("服务器>>"+str2);		
			}
		} finally {
			//System.out.println("close the Client socket and the io.");
			socket.close();
		}
	}
}