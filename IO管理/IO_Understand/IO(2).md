# 谈谈FileReader和FileWriter
> 这里挑出FileReader和FileWriter就是因为他们相对而言经常被使用。
> 他们的作用就是对本地文件（文本）进行流对象的封装，顾名思义，FileReader负责输入流对象的创建等等；FileWriter负责输出流对象的创建等等。
####FileReader
> FileReader的父类是InputStreamReader,InputStreamReader的父类是Reader
1.来了先上代码：
```java 
import java.io.*;

/*
 FileReader 的使用
 */
public class FileReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null; // 注意全局变量的安排，这里的优势在于fr的操作和close的便利，因为try和finally是两个代码块

		try {
			fr = new FileReader("newFile.txt");       //从当前文档获取newFile.txt文件的流对象
			
			int ch=0;                                //接受read()的返回值，字符的ASCII值
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

```
-----------
2.```java
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


```
这个代码格式很受欢迎，尤其是下面这段
```java
			int ch=0;
			while ((ch=fr.read() )!= -1) {
				System.out.print((char)ch);
			}
```
----------
####FileWriter
> FileWriter的父类是OutputStreamReader,OutputStreamReader的父类是Writer
1.`FileWriter fw=new FileWriter("Demo.txt");`这句代码的含义在于当当前文档中如果不存在Demo.txt文件，它会创建一个Demo.txt文件。否则，
直接在Demo.txt文件中进行操作，覆盖原来的内容。
2.具体的方法细节在下面的代码中可以体现。
```java
import java.io.*;
public class FileWriterDemo {

	public static void main(String[] args) {
		
		FileWriter fw=null;        //注意定义为全局变量的优势，在于使用流和关闭流在不同的代码块中。
		
		
		try{
			
			fw=new FileWriter("newFile.txt");       //创建输出流对象，输出文件命名newFile.txt，注意覆盖问题
			fw.write("abcde");          //向缓冲区写入abcde，注意，这里没有写入文件中
			
			fw.flush();
			//可以使用fw.flush();方法刷新缓冲区，但是close方法的调用可以完成flush（）

			fw.write("    nihao"); 
		}
		catch(IOException e){
			throw new RuntimeException("复制失败");
		}
		finally{
			
			try{
				if(fw!=null)          
					fw.close();        //关闭输出流
			}catch(IOException e){
				throw new RuntimeException("关闭输出流失败");
			}
			
			
		}
	}

}

```

3.注意点flush()和close()的区别
> 其实很简单，flush()的作用是刷新缓冲区。而close()的作用在于关闭流，但是在关闭之前它会调用flush()方法，刷新缓冲区。
4.FileWriter(String name,boolean append);这种创建方式可以改变是否覆盖文件数据，boolean append 为true时可以在文件后面续写，否则，覆盖。