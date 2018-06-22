# <center>JNDI简单理解</center>
---
因为热爱，所以拼搏。          --[RuiDer](ruider.github.io)

---
### 什么是JNDI技术

> JNDI: Java Naming And Directory Interface,通俗的理解就是将名称与对象绑定在一起，对象工厂负责生产出对象，这些对象与特定的名称绑定。
外部程序通过对象的名称查找对象资源并使用资源。

### JNDI原理
```java

//javax.naming包负责管理JNDI技术，该包中的Context接口定义了两个方法
//bind: 负责绑定名称和对象
//lookup:通过名称查找对象的作用。

public interface Conterface{

    public void bind(String name，Object obj);
    publiv Object lookup(String name);
}
```

> 个人理解：JNDI的底层是一个HashMap结构，将名称和对象使用键值对一一对应，这种关系的搭建与Map体系紧紧相连。
