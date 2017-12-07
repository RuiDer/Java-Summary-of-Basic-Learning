FileWriter与FileReader
=========================
> 这是笔者初学IO输入流与输出流的笔记，希望对读者有很大的帮助。
> 学习更多Java知识欢迎关注[布玮](HTTPS://github.com/Mahede080210/java)
------------------------
## 一.FileReader
### FileReader：IO输入流

>下面举例说明
```java
public class FileReaderTest1 {
	 public static void main(String[] args)throws IOException{  
		 
		//读取流FileReader
		 
		 FileReader fr =new FileReader("D:\\hello.txt");   //确定读取文件路径以及名称
		 char [] render = new char[1024];    //用字符数组接受FileReader对象的读取内容
		 int length=0;       //标记读取字符的长度以及数组的长度
		 while(length!=-1)    //read()文件读取完毕返回-1
		 {
			 length=fr.read(render);   //获得文件的长度以及数组的长度
			 System .out .println(new String(render,0,length));
			 break;
		 }
                 fr.close();      //！！！！记得关闭
	             
	    }  

}

```
#### 说明：
1. 将IO输入流（steam）封装为FileReader的对象`FileReader fr =new FileReader("D:\\hello.txt");`
2. 读取的文件信息需存储在char[]数组中。
3. read()方法一次读取一个字符，返回值为字符的长度以及数组的长度
4. close()用于关闭IO流
5. FileReader: 文字或者字符 ---> 字符数组  （与FileWriter相反）

---------------------------------------------------------------------------------

## 二.FileWrite:IO输出流
>下面举例说明
```java
public class FileReaderTest2 {
	 public static void main(String[] args)throws IOException{  
		 
		//写入流FileWriter
	            
	          FileWriter fw=new FileWriter("d:\\hello.txt");
	          String render1="你好，我们一起加油吧----RuiDer";
	          fw.write(render1);
	          //fw.write(t,true);
	          fw.close();
	             
	    }  

}

```
#### 说明：
1. IO输出流创建对象的过程相当于根据路径创建文件或者选中文件，封装在FileWriter的对象中。` FileWriter fw=new FileWriter("d:\\hello.txt");` 
2. 将字符串写入指定的文件时会发生覆盖文件已有的内容；解决方法为：` fw.write(render1,true);`"true"将会防止原有文件被覆盖
3. write()方法将字符串写入指定的文件
4. close()关闭IO字符流
5. FileWriter:文字或者字符 ---> 字符数组  （与FileReader相反）


------------------
## 三.为何read()返回值为int类型

>Java 下 IO 中 FileReder 和 FileInputStream 分别是以字符和字节的形式来完成数据的读取的，
>然而返回值确是 int 类型的数据，这样做的核心目的只是要取到到一个 int 类型下的 -1 来表示
>数据流的末尾。为什么要这样做？又是怎么实现的呢？
-------------------------------------------------------
### 1. 首先看 **FileReader** ：
```
FileReader fr = new FileReader("src.txt");
int ch = fr.read();
如上面的代码，FileReader 的 read 方法返回值是一个 int 类型的变量来接收的，然而 read 方
法在实际中却是以字符形式来进行数据的读取的。通过上面的基本数据类型的取值范围我们能发现
 char 类型数据的取值范围为 0 ~ 65535 ，也就是说 char 类型数据是取不到负值的；int 类型
数据的取值范围为 -2147483648 ~ 2147483647 ，可以取到负值；同时 int 的取值范围又包含 
char 的取值范围，这就为使用 int 作为返回值类型提供了可能，因为流需要一个特殊的值来表示
流末尾，这个值不应该在 char 的取值范围内，如果使用 char 取值范围内的值作为流末尾标志，
那么这个值同样有可能出现在数据流中间作为数据来传输，流在读到这个值的时候会认为已经到达
流末尾，后面未读取的数据将被截断。所以 Java 中选择了使用 -1 来作为流末尾，这个值不在 
char 的取值范围内，所以不存在数据截断，然而 -1 又在 int 的取值范围内，同时 int 的取值
范围包含 char 的取值范围，所以 FileReader 下 read 方法返回的 char 类型数据直接转为了 
int 类型。
```
----------------------------------------------------
### 2. 再看 **FileInputStream** ：
```
FileInputStream fis = new FileInputStream("src.txt");
int b = fis.read();
同理 FileInputStream 也需要一个自己取不到的值来作为流末尾的标志，Java 同样使用 -1 来
作为字节流的流末尾，从上面基本数据类型的取值范围我们可以看到 byte 的取值范围为
 -128 ~ 127 ，这就意味走着 byte 可以取到 -1 ，如果把 -1 直接当作 int 作为流末尾，那么
就无法区分这个读到的结果是流末尾还是流中的数据了，那么 Java 是如何实现取值 -1 的呢？在
 Java 内部，Java 通过高位补 0 来实现数据从 byte 到 int 的转换，举个例子：
-1 在 byte 类型和 int 类型中都可以取到，-1 在 byte 类型下的二进制存储形式为 11111111 ，
然而使用 read 方法的时候，Java 内部将 byte 的高位补 0 将 byte 转为 int 类型，所以 byte
 类型的 -1 在 int 类型下的二进制存储形式为 00000000 00000000 00000000 11111111，对应的
 int 值为 255，通过高位补 0 ，所有 byte 类型的负数都转为了正数。然而在使用这些读到的 byte
 数据时，只要将这些数据从 int 强转回 byte 即可得到原有的数据。所以就可以使用 -1 来作为流
末尾的标志，因为 Java 内部将 byte 的负数通过高位补 0 将其转换为了负数。
```

## 四.字节与字符
（一）“字节”的定义
```
字节（Byte）是一种计量单位，表示数据量多少，它是计算机信息技术用于计量存储容量的一种计量单位。
```
（二）“字符”的定义
```
字符是指计算机中使用的文字和符号，比如1、2、3、A、B、C、~！·#￥%……—*（）——+、等等。
```
（三）“字节”与“字符”
```
它们完全不是一个位面的概念，所以两者之间没有“区别”这个说法。不同编码里，字符和字节的对应关系不同：
①ASCII码中，一个英文字母（不分大小写）占一个字节的空间，一个中文汉字占两个字节的空间。一个二进制数字序列，在计算机中作为一个数字单元，一般为8位二进制数，换算为十进制。最小值0，最大值255。
②UTF-8编码中，一个英文字符等于一个字节，一个中文（含繁体）等于三个字节。
③Unicode编码中，一个英文等于两个字节，一个中文（含繁体）等于两个字节。
符号：英文标点占一个字节，中文标点占两个字节。举例：英文句号“.”占1个字节的大小，中文句号“。”占2个字节的大小。
④UTF-16编码中，一个英文字母字符或一个汉字字符存储都需要2个字节（Unicode扩展区的一些汉字存储需要4个字节）。
⑤UTF-32编码中，世界上任何字符的存储都需要4个字节。
```
