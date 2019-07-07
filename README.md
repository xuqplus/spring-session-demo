# spring-session-demo

使用redis(集群)共享http session的例子  

在`withZips`分支保存了windows下`nginx`和`redis`的安装包, 我自己的系统是win10, 可以直接使用  

启动s0, s1两个实例, 调用s0接口设置session, 可以从s1获取到, 效果如图  

![](https://github.com/xuqplus/spring-session-demo/raw/master/%E6%95%88%E6%9E%9C.png)

另外从图中发现, 浏览器并不区分cookie的端口号..

____
更新 spring security resource server 资源服务器

____
更新 spring sso client 单点登录
