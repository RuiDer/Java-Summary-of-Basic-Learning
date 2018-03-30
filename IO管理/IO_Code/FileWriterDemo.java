
/*测试IO接口中的FileReader，FileWriter,BufferedReader,BufferedWriter
 实现对文件的复制
 */
import java.io.*;
public class FileWriterDemo {

	public static void main(String[] args) {
		
		FileWriter fw=null;
		
		
		try{
			
			fw=new FileWriter("newFile.txt");
			fw.write("abcde");
		}
		catch(IOException e){
			throw new RuntimeException("复制失败");
		}
		finally{
			
			try{
				if(fw!=null)
					fw.close();
			}catch(IOException e){
				throw new RuntimeException("关闭输出流失败");
			}
			
			
		}
	}

}
