import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientCode {
	static String clientName = "Mike";
	// 端口号
	public static int portNo = 3333;

	public static void main(String[] args) throws IOException {
		// 设置连接地址类,连接本地
		InetAddress addr = InetAddress.getByName("localhost");
		// 要对应服务器端的3333端口号
		Socket socket = new Socket(addr, portNo);
		try {
			System.out.println("socket = " + socket);
			// 设置IO句柄
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			out.println("Hello Server,I am " + clientName);
			String str = in.readLine();
			System.out.println(str);
			out.println("byebye");
		} finally {
			System.out.println("close the Client socket and the io.");
			socket.close();
		}
	}
}