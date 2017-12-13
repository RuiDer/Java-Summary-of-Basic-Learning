import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.imageio.IIOException;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 该类用于实现服务器多线程操作，等待客户端的连接，一旦接到连接，立即交给线程处理。
 * 
 * @author DELL 2017-12-11
 */
public class ServerLinkClient {
	private static final int portNo = 3333;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket clientSocket;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(portNo);          //创建服务器
			
			//显示初始时间
			System.out.println();
			System.out .println("--------时间>>"+new Date()+"---------------");
			System.out.println();
			
			System.out.println("服务开始工作啦！\n正在等待顾客的到来！！！");
			
			while(true)                 //持续等待客户端的连接
			{
				clientSocket = serverSocket.accept();               //阻塞，直到有客户连接                     
				new ServerThreadsDeal(clientSocket);            //一旦有客户连接，立即启动线程
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();                 //关闭服务器
		}
	}
}
