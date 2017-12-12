# linux，服务器，mysql数据库，tomcat这些之间是什么关系？
> 这是小编在初学Java_web时系统地对服务器，数据库以及web前端之间的关系进行了一次梳理，
这里很多的内容来自其他csdn大佬的原话，感觉很有帮助，感谢原作者。

## 一.linux(区别windows在于它可以建立强大的服务器)
```
Linux
           是一个计算机操作系统，跟windows是一种类型的，不过Linux目前的最大作用是用来做
      大型服务器和嵌入，反正你就知道他是个操作系统就行了，广泛用于服务器.
```

## 二.MySQL(数据库)
```
MySQL
          是一种数据库，跟window server上边的mssql是一种数据库，数据库你可以理解
      为电子表格，Excel，不过比Excel更复杂
```

## 三.Tomcat(服务器)
```
tomcat  
    
     是一种WEB服务器，就是你打开网页上所有看到的东西，都是基于Tomcat、IIS、Apache、
Nginx等等这种软件显示的，光有Linux没有Tomcat、IIS、APACHE,Nginx是打不开一个网站的
```

## 四.linux，mysql，tomcat，这三种，是如何即行的
```
    当你在开发jsp过种当中，就跟你现在看到的页面一样，有提交回答，回复等等功能，点击这些功能
的时候，这个动作会被转发到tomcat当中，然后tomcat负责把结果计算出来，然后通过浏览器反馈给用户
例如，你在一个输入框中输入了1+1=，点击计算，这时浏览器是不会计算的（咱们讨论的是服务器端，不
带你们加入JS的啊，JS可是通过浏览器运算的），浏览器把1+1=送给tomcat，tomcat开始运算，1+1=2，好，
tomcat运算出来了，那么把结果反馈给浏览器，浏览器就呈现在了用户面前.但tomcat是不能作为一个独立
的而存在，没有操作系统的话，是不能运行的。

    一般来说，tomcat和apache来配合运行，tomcat在HTML的呈现方法不如apache，也就是说有一个亿的点击量，
静态页面，tomcat是反应不过来的，但apache轻松搞定
    
    APACHE和TOMCAT各有分工，APACHE负责静态页面，TOMCAT负责JSP动态页面，当有静态页面进来时，
apache负责来解析，有动态动作进行时， apache负责把这个动作引导至于TOMCAT，TOMCAT运算完后反馈
给APACHE，APACHE再反馈给浏览器其实APACHE用的多，负责居中调试，PHP进来了，引导给PHP来运算，
JSP进来了，引导给TOMCAT
```

## 五.MySQL与服务器
```
    再说说MYSQL，比如说我现在回答的这个问题，我打完了几百字了，累的经死吧，要存上来吧，我点击
提交回答，然后百度的WEB服务器软件如Nginx,APACHE,IIS开始引导，如果这个是PHP，就转交给php来解析，
如果是JSP，转给tomcat来运算，运算完了以后，就插入到数据库也就是mysql啊,mssql了，oracle了，数据
库mysql中多了一条我回答的记录，插入完了以后再由tomcat读取出来，通过apache反馈给浏览器，你就看
到了这篇回答
```