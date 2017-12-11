import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.IIOException;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 该类用于实现服务器多线程操作
 * 
 * @author DELL 2017-12-11
 */
public class ServerDemo {
	private static final int portNo = 3333;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket clientSocket;
		ServerSocket serverSocket = null;
		try {
			for (;;)                 //持续等待客户端的连接
			{
				serverSocket = new ServerSocket(portNo);
				clientSocket = serverSocket.accept();               //阻塞，直到有客户连接                     
				new ThreadServerCode(clientSocket);            //一旦有客户连接，立即启动线程
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();                 //关闭服务器
		}
	}
}
