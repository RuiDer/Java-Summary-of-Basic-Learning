import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCode { // 设置端口号

	public static int portNo = 3333;

	public static void main(String[] args) throws IOException

	{

		ServerSocket s = new ServerSocket(portNo);
		System.out.println("The Server is start: " + s);

		// 阻塞,直到有客户端连接
		Socket socket = s.accept();
		try {
			System.out.println("Accept the Client: " + socket);
			// 设置IO句柄
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			while (true) {
				String str = in.readLine();
				if (str.equals("byebye")) {
					break;
				}
				System.out.println("In Server reveived the info: " + str);
				out.println(str);
			}
		} finally {
			System.out.println("close the Server socket and the io.");
			socket.close();
			s.close();
		}
	}
}