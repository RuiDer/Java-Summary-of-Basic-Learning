# <center>EJB简单理解</center>

---
因为热爱，所以拼搏。        --[RuiDer](ruider.github.io)

--- 

### 什么是JavaEE
> JavaEE:Java Platform Enterprise Edition
> JavaEE是一个分层架构，分布式的体系结构。
```java
分层架构： JavaEE由四个层次构成，分别是客户层，Web层，业务层，持久层
			客户层：页面展示层，运行在客户机上，可以访问Web层和业务层。
			Web层：JSP和Servlet构成的Web页面。
			业务层：处理程序的业务逻辑，主要是一些业务方法的集合。主要框架有Spring，SpringMVC，Struts，EJB框架等
			持久层：数据库层，JDBC，JNDI，DataSource等，主要一流框架有Mybatis,Hibernate框架等
```

### 什么是EJB
> EJB:Enterprise Java Bean,一个重量级的业务层框架，重量级的意思在于其启动时开销大。

### 主要组成
1.  Remote接口：定义业务逻辑方法。
2.  Home接口： 定义获取EJB对象的方法。
3.  Enterprise Bean类：实现Remote接口，具体方法可以包括数据库的连接，数据库的具体增删改查操作。


EJB与Spring可以比较着学习，参考源码学习。
