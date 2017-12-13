import java.io.IOException;
import java.net.Socket;

public class ClientLinkServer {
	//private static String Ip;
	//private  int port=3333;
	private Socket socket;
	
	public ClientLinkServer(String Ip,int port)
	{
		try
		{
			socket=new Socket(Ip, port);    //使用主机ip与端口向服务器端获得连接
			new ClientThreadsDeal(socket);             //交给多线程机制处理
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
