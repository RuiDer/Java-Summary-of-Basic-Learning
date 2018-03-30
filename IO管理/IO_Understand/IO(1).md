# Java IO接口
> 参考 [java.io API](http://tool.oschina.net/apidocs/apidoc?api=jdk-zh)
#### 何为IO？？？？
> I/O即Input /Output,输入和输出。
> 我想各位学者在学习io时首先需要牢记IOException,因为这个包中的方法很简单，但是，异常是处处存在，不可忽视。

#### 何为流
1.在Java中将外部文件或者其他东西进行输入输出，这时Java将这些文件或者其他以流的形式传输，也就是每个输入输出被封装成一个流对象。
2. 在Java io包中最基本的类是InputStream和OutputStream，Reader，Writer四个类，他们分别负责输入输出流对象的创建以及其他操作。
3.重点来了，流被分为两种，一种是字节流，一种是字符流。

##### 谈谈字节流和字符流的区别。
1.字节流就是我们常说的二进制码，0和1的组合，他们能够被用于表示字符，符号等，因为早期美国人发明的ascii码就是只针对英文字符。中文
拥有GBK，和ASCII同理，对应汉语。Unicode是国际化标准。
2.有人会问1中的和流有什么关系。。。。为什么要区分字节流和字符流呢？就是因为他们内部的编码机制的不同，导致两种流处理数据的效率不同。
字节流中主要识别ASCII码，字符流主要识别Unicode码。
3.字符流可以处理文本数据，比如String数据。大多数情况下使用该流。
4.字节流基类：abstract InputStream,abstract OutputStream
5.字符流基类：abstract Reader,abstract Writer

#### 字符流
一.输入流
1.Reader:负责创建输入流。其子类有：BufferedReader,InputStreamReader等
2.方法

(1)int read();每次读一个字符，注意是一个！！而且每读取一个字符指针指向下一个字符，返回值为-1时表明结尾。比如abc$，先a（97），后b（98），再c（99）,
最后$，返回-1
说明一下：文本中一般有开始和结尾标识，window和linux的结尾标识都是$,每次返回值都为字符的ASCII值。

（2）int read(char[] ch);将流数据读取到一个char型数组中，注意是读到数组中。返回数组中被填充的长度。结尾返回-1。
补充另外一个知识点：字符数组-->字符串  使用new String(ch);new String(ch,start,end)
		    字符串-->字符数组  使用String的toCharArray()方法

(3)close();关闭输入流，一般放在finally中。

---------------
二.输出流
1.Writer:负责创建输出流。其子类有：BufferedWriter,OutputStreamWriter等

2.方法
（2）void write(String str);将字符串读到缓冲区，交给缓冲区处理。
##### 这里补充一点：如果需要将输出文本换行，这里的write(String str)方法的参数需要传入"\r\n"或者"\n"。注意，这里的"\r\n"是window操作系统的
换行字符，"\n"是linux操作系统的换行字符。其实，这里还有一个知识点，就是流的操作与操作系统的关系。是这样的，当new一个流对象时，在JVM
的堆内存中就会有一个实例，这个实例将会请求操作系统中的新建文本命令，这时，就看JVM是基于window还是Linux了。

（3）void write(char[] ch);将char数组读到缓冲区。

（3）void flush();将读到缓冲区的数据刷新，也就是直接冲出去。

（4）close（）；关闭输出流，会抛出异常。

> 注意上面提到的两种write()方法的特殊点在于当Writer输出流对象所对应的文件存在时，不管该文件是否有数据，write（）方法都会覆盖其中的数据 。

三.无论字节流还是字符流的子类，他们的结尾都是以基类名称作为结尾，比如BufferedReader,BufferedWriter
