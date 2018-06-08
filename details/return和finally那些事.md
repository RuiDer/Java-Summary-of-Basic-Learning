# return和finally的前世后生
> 因为热爱，所以拼搏。。            --来自大二的艺术家     RuiDer
------------------------
`感谢人家面试，感谢考试，复习的过程也是学习的大好时光～～～`
--------------------------

### 前导必备
1. Java异常的相关知识
2. Java return的相关知识
3. your heart

### 深入解析
1、不管有木有出现异常，finally块中代码都会执行；

2、当try和catch中有return时，finally仍然会执行；

3、finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，管finally中的代码怎么样，返回的值都不会改变，
任然是之前保存的值），所以函数返回值是在finally执行前确定的；

4、finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。

--------------------------------------------------------
### 举例加深理解
```
情况1：
       try{} catch(){}finally{} return;
            显然程序按顺序执行。
```
-----------------------------------            

```
情况2:
           try{ return; }catch(){} finally{} return;
           
          程序执行try块中return之前（包括return语句中的表达式运算）代码；
          再执行finally块，最后执行try中return;
         finally块之后的语句return，因为程序在try中已经return所以不再执行。
 
 ```
------------------------------------------------         

```
情况3:
          try{ } catch(){return;} finally{} return;
         程序先执行try，如果遇到异常执行catch块，
         有异常：则执行catch中return之前（包括return语句中的表达式运算）代码，再执行finally语句中全部代码，
                     最后执行catch块中return. finally之后也就是4处的代码不再执行。
         无异常：执行完try再finally再return.
 ```
------------------------------- 

```
情况4:
            try{ return; }catch(){} finally{return;}
          程序执行try块中return之前（包括return语句中的表达式运算）代码；
          再执行finally块，因为finally块中有return所以提前退出。
 ```
-----------------------------------

```
情况5:
           try{} catch(){return;}finally{return;}
          程序执行catch块中return之前（包括return语句中的表达式运算）代码；
          再执行finally块，因为finally块中有return所以提前退出。
          
```          
------------------------------------------

```
情况6: 
           try{ return;}catch(){return;} finally{return;}
          程序执行try块中return之前（包括return语句中的表达式运算）代码；
          有异常：执行catch块中return之前（包括return语句中的表达式运算）代码；
                       则再执行finally块，因为finally块中有return所以提前退出。
          无异常：则再执行finally块，因为finally块中有return所以提前退出。
```


