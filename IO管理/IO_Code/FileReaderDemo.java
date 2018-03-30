import java.io.*;

/*
 FileReader 的使用
 */
public class FileReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null; // 注意全局变量的安排，这里的优势在于fr的操作和close的便利，因为try和finally是两个代码块

		try {
			fr = new FileReader("newFile.txt");
			
			int ch=0;
			while ((ch=fr.read() )!= -1) {
				System.out.print((char)ch);
			}
		} catch (IOException e) {
			throw new RuntimeException("读取失败");
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				throw new RuntimeException("关闭输入流失败");
			}

		}
	}

}
