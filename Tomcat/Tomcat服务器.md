# [Tomcat 简介](http://www.cnblogs.com/jeacebolgs/p/6580428.html)
```
Tomcat 是在SUN 公司的JSWDK（JavaServer Web DevelopmentKit ,是SUN公司推出的小型Servlet/JSP调
试工具）的基础上发展起来的一个优秀的Servlet容器，Tomcat本身完全用java语言编写。

Servlet是一种运行在服务器上的小插件，他所具有的的以下特点：

1、提供了可被服务器加载并执行的程序代码，并服务于来自客户端的请求。

2、Servlet服务器必须支持java。

3、Servlet不依赖浏览器，是允许在服务器端，所以不管浏览器是否支持java，都能请求访问servlet。

Tomcat做为Servlet的容器基本功能如图一
```
![图一](http://images2015.cnblogs.com/blog/1109265/201703/1109265-20170319124125448-1428558704.png)
```
Servlet 的规范规定Servlet不仅可以运行在基于HTTP协议的Web服务器上，还可以运行在基于其他应用协
议的服务器上。不过，目前Servlet主要运行在Web服务器上，用来扩展Web服务器的功能。Servlet规范规
定，Servlet容器响应客户请求访问特定的Servlet的流程如下：

1、客户发出要求访问特定的Servlet的请求。

2、Servlet 容器接收到客户请求并解析。

3、Servlet 容器创建一个ServletRequest对象，在ServletRequest对象中包含了客户请求信息及其他关
于客户的信息，如请求头，请求正文，以及客户机的IP地址等。

4、Servlet容器创建一个ServletResponse对象

5、Servlet 容器调用客户所请求的Servlet的service服务方法，并且把ServletRequst对象和
ServletResponse对象做为参数传给该服务方法。

6、Servlet从ServletRequest对象中可获取客户的请求信息。

7、Servlet利用ServletResponse对象来生成响应结果。

8、Servlet容器吧Servlet生成的响应结果发送给客户。

 Tomcat的组成如图二
```
![图二](http://images2015.cnblogs.com/blog/1109265/201703/1109265-20170319132358073-524647167.png)
```
1、<Server> 元素：代表整个Servlet容器组件，是Tomcat的顶层元素。在<Server>元素中可以包含一
个或者多个<Service>元素。

2、<Service>元素：包含一个<Engine>元素，以及一个或多个<Connector>元素，这些<Connector>原先
共享一个<Engine>元素。

3、<Connector>元素：代表和客户程序时间交互的组件，负责接收客户请求，以及想客户返回响应结果。

4、<Engine>元素：每个<Service>只能有一个<Engine>元素。<Engine>元素处理在同一个<Service>中所
有<Contector>元素接收到的客户请求。

5、<Host>元素：在一个<Engine>元素中可以包含多个<Host>元素。每个<Host>元素定义了一个虚拟主机，
他可以包含一个或多个Web应用。

6、<Context>元素：使用最频繁的元素。每个<Context>元素代表了运行在虚拟主机上的单个Web应用。
在一个<Host>元素中可以包含多个<Context>元素。
```
-----------------------------------------

### Tomcat作为独立的Web服务器来单独运行，Servlet容器组件做为Web服务器中的一部分二存在，
这是Tomcat的默认工作模式。
![](http://images2015.cnblogs.com/blog/1109265/201703/1109265-20170319133918151-1547402490.png)
















