  # 缓冲区buffer
> 因为热爱，所以拼搏。。    ---来自大二的艺术家 RuiDer 2018-4-1

### 概念总结
	在字节流和字符流的领域，就如同人喝水，当使用输入流读取一个字符时，就如同一滴一滴喝水，速率是不是很慢。那么，就来了一个装水
    的杯子，一次性装满水，这样使得喝水速率倍加。这里的装水杯子就相当于一个缓冲区。为了提高效率。

### 浅谈BufferReader,BufferWriter
1.BufferReader,BufferWriter分别继承Reader 和Writer抽象类
2.BufferReader,BufferWriter分别属于输入流缓冲区和输出流缓冲区。
3.BufferReader新增方法readLine();每次读取一行到缓冲区，底层以跳行符号标记识别。
4.BufferWriter新增方法newLine(); 跳行，也就是write("\r\n"或者"\n");原理很简单

### 缓冲区原理
> 其实很简单，缓冲区就是使用char数组完成的，底层是数组。

下面是自定义实现缓冲区代码
```java 
import java.io.*;
/*
 实现文本的复制，自定义自己的缓冲区。
 */
public class CopyDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		FileWriter fw=null;
		char[] buf=new char[1024];  //定义1k的缓冲区      1024*1024就是1
		int length=0;
		
		try{
			fr=new FileReader("newFile.txt");
			fw=new FileWriter("CopyMapEnter1.txt",true);
			
			while((length=fr.read(buf))!=-1){
				fw.write(buf,0,length);
				fw.flush();             //每次都刷新缓冲区
			}
		}
		catch(IOException e){
			throw new RuntimeException("复制失败");   //RuntimeException 出现时，程序直接被终止
		} 
		finally{
			try{
				fr.close();
			}
			catch(IOException e){
				throw new RuntimeException("关闭输入流失败");
			}
			try{
				fw.close();
			}
			catch(IOException e){
				throw new RuntimeException("关闭输入流失败");
			}
		}
	}

}

```

-----------------------------------------------

下面是BufferReader,BufferWriter的实现代码
```java

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
			fr=new FileReader("newFile.txt");
			fw=new FileWriter("CopyMapEnter1.txt",true);
			bufR=new BufferedReader(fr);
			bufW=new BufferedWriter(fw);
			
			String target=bufR.readLine();          //读取一行，遇到换行符跳行
			while(target!=null)
			{
				bufW.write(target);
				bufW.newLine();            //跳行
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
			
```
### 注意点
> BufferReader,BufferWriter只需要关闭缓冲区即可，关闭缓冲区会附带关闭流。
