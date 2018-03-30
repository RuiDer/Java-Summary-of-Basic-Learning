
/*测试IO接口中的FileReader，FileWriter,BufferedReader,BufferedWriter
 实现对文件的复制
 */
import java.io.*;

public class CopyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		BufferedReader bufR=null;
		FileWriter fw=null;
		BufferedWriter bufW=null;
		
		
		try{
			fr=new FileReader("F:\\java程序\\JavaSE\\容器（List,Set,Map）\\Collections辅助类\\Home\\JavaCode\\Person.class");
			fw=new FileWriter("CopyMapEnter.txt");
			bufR=new BufferedReader(fr);
			bufW=new BufferedWriter(fw);
			
			String target=bufR.readLine();
			while(target!=null)
			{
				bufW.write(target);
				bufW.newLine();
				bufW.flush();
			}
		}
		catch(IOException e){
			throw new RuntimeException("复制失败");
		}
		finally{
			try{
				if(bufR!=null)
					bufR.close();
			}catch(IOException e){
				throw new RuntimeException("关闭输入流失败");
			}
			try{
				if(bufW!=null)
					bufW.close();
			}catch(IOException e){
				throw new RuntimeException("关闭输出流失败");
			}
		}
	}

}
			