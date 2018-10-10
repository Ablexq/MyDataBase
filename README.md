


# GreenDao

GreenDAO：
http://greenrobot.org/greendao/
https://github.com/greenrobot/greenDAO

[Android实战——GreenDao3.2的使用，爱不释手](https://blog.csdn.net/qq_30379689/article/details/54410838)

[Android框架之路——GreenDao3.2.2的使用](https://blog.csdn.net/bskfnvjtlyzmv867/article/details/71250101)

[GreenDao3使用教程](https://blog.csdn.net/qq_36699930/article/details/81540781)

[玩转Android之数据库框架greenDAO3.0使用指南](https://blog.csdn.net/u012702547/article/details/52226163)

GreenDao特点

greenDao是一个将对象映射到SQLite数据库中的轻量且快速的ORM解决方案。

- 高性能（可能是Android最快的ORM）：开源的基准
- 易用：功能强大的API涵盖关系和联接
- 最小的内存消耗
- 精简的库（<100KB）：维持较少的编译时间，并避免65k方法数量的限制
- 数据库加密：greenDAO支持SQLCipher，以保护用户的数据安全
- 强大的社区：GitHub上超过5000个Star（现在已经超过8000了）表明有一个强大和积极的社区


# realm

Realm：
https://realm.io/cn/
https://github.com/realm/realm-java

[Realm 数据库的简单使用](https://blog.csdn.net/hedong_77/article/details/53167774)

[realm 英文文档]( https://realm.io/docs/java/latest/)

[Realm For Android详细教程](http://www.cnblogs.com/RaphetS/p/5996265.html)

realm特点

数据库Realm，是用来替代sqlite的一种解决方案，它有一套自己的数据库存储引擎，
比sqlite更轻量级，拥有更快的速度，并且具有很多现代数据库的特性，
比如支持JSON，流式api，数据变更通知，自动数据同步,简单身份验证，
访问控制，事件处理，最重要的是跨平台，
目前已有Java，Objective C，Swift，React-Native，Xamarin这五种实现。

- 离线优先：即使在离线状态下应用也可正常工作
- 查询快速：复杂查询也只需要几纳秒，查询结果与新数据实时同步
- 线程安全：多线程访问同一数据毫无问题
- 跨平台支持：多个平台不同应用使用同一数据库
- 加密：无需额外代码，就能保证你的数据安全
- 响应式架构：让Realm连接到UI，及时将数据更新反馈给用户


# greenDAO与Realm的对比

[greenDAO与Realm的探索](https://blog.csdn.net/w2_2015/article/details/74452552)

[GitHub：对比的demo](https://github.com/xiaoniu/Database)

Realm增删改查速度要比greendao快


