import java.io.IOException;
import java.net.Socket;

public class ClientLinkServer {
	private static String Ip;
	private static final int port=3333;
	private static Socket socket;
	
	public ClientLinkServer(String Ip,int port)
	{
		try
		{
			socket=new Socket(Ip, port);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientLinkServer("localhost", port);                //连接服务器
		new ClientThreadsDeal(socket);                   //对多个请求作出处理
	}

}
