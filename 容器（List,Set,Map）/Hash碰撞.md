# <center>HashTable与HashMap的瓶颈
---
> 因为热爱，所以拼搏。         --RuiDer

---
#### HashTable与HashMap的瓶颈
   我们知道，HashTable和HashMap的底层结构是数组与链表结合实现，Key的hashCode决定对象在数组中存储的位置，相同hashCode的key对象会放在同一个数组角
   标下。这是最理想的状况，但是存在另外一个问题，当所有的对象的hashCode相同时，所有对象都被放在一个角标中，就会出现hash碰撞问题，这时数组缩为一个链
   表。这时，get方法本来时间复杂度为O（1）却变成了O(n),性能急剧下降。。
