# TCP协议下完成客户端与服务端的连接

>依据TCP协议，在C/S架构的通讯过程中，客户端和服务器的Socket动作如下：

## 客户端：
```
1.用服务器的IP地址和端口号实例化Socket对象。
2.调用connect方法，连接到服务器上。
3.将发送到服务器的IO流填充到IO对象里，比如BufferedReader/PrintWriter。
4.利用Socket提供的getInputStream和getOutputStream方法，通过IO流对象，向服务器发送数据流。
5. 通讯完成后，关闭打开的IO对象和Socket。
```
## 服务器：
```
1. 在服务器，用一个端口来实例化一个 ServerSocket对象。此时，服务器就可以这个端口时刻监听
从客户端发来的连接请求。
2.调用ServerSocket的accept方法，开始监听连接从端口上发来的连接请求。 　　
3.利用accept方法返回的客户端的Socket对象，进行读写IO的操作
通讯完成后，关闭打开的流和Socket对象。
```
