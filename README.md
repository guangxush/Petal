### 实习面经
(为了防止违反公司面试规定,面经不显示公司名称并随机打乱，面经中不包含在线笔试题目，并且不是特别完整，仅供参考)
#### 1面

1. 自我介绍3分钟，项目详细介绍，项目背景，项目技术栈，你完成了哪些事情，遇到的问题及解决，面试问题:
2. 垃圾回收机制
3. HashMap底层实现，与HashTable区别,为什么安全
4. 什么是反射，如何实现
5. 红黑树
6. Spring IOC AOP DI
7. MySQL聚簇索引与非聚簇索引
8. MySQL索引失效的情况有哪些
9. 日志管理AOP
10. Linux基本命令考察，网络相关
11. 项目中并发实现机制

#### 2面

1. 自我介绍
2. 两个栈实现队列，生产者消费者问题
3. spring 单例模式，bean依赖注入保证单例
4. MySQL分页实现
5. MySQL与SQLserver的区别
6. 聚类实现学生成绩分类
7. static关键字
8. 立方体表面积计算
9. 多线程JUC包下的一些常见的类，比如CountDownLatch、Semaphore等

#### 3面

1. 最大子段和
2. 左外连接，右外连接，全连接join
3. 快速排序第k个最大数
4. 写过的最复杂的sql语句
5. 楼上扔两个鸡蛋最优次数
6. 对线性代数矩阵的理解
7. 判断链表有没有环
8. 堆排序

#### 1面

1. hashmap与hashtable区别
2. 浏览器输入url之后发生了什么，DNS是啥，一个DNS下面有多少个IP,页面长时间等待原因分析
3. JVM调优
4. Linux命令，top ps aux
5. 聚簇索引与非聚簇索引，什么时候用
6. lock与synchronized区别
7. 线程池两个上限的区别，几种线程池，饱和策略
8. lock并发底层实现
9. 实现从cached和并发量小的数据库中读取key
10. 双重锁的单例模式
11. Spring MVC执行流程
12. Servlet流程
13. Tomcat容器，IIS
14. 红黑树实现，红黑树与二叉搜索树的区别
15. Kafka的partition设置多少合适
16. Kafka性能优势，怎么保证顺序性
17. Mysql查询优化，如何避免全表搜索，什么情况下不是全表搜索
18. Innodb二级索引
19. 垃圾回收机制，OOM发生在哪里，堆内存，栈内存溢出
20. 双亲委派模型
21. 可重入锁底层实现，为什么是可重入
22. 三种设计模式，代理模式，工厂模式，装饰器模式
23. ORM模型
24. NIO 并发性
25. Linux IO实现原理
26. Web框架有哪些熟悉的
27. Hive表分区
28. 反射
29. MySQL索引的作用
30. 异常的抛出会不会影响其他线程，main里面怎么抛出异常
31. 如何降低锁粒度提高并发性
32. 如何查异常的bug
33. OOM发生在哪里，为什么
34. JAVA内存划分，垃圾回收机制，GC发生在哪里


#### 2面

1. 操作系统学了哪些东西，操作系统的进程和线程区别，操作系统内存调度算法，页面置换算法，固态硬盘和移动硬盘的区别，如何寻址，MMU是啥，CPU流水线,内核态 用户态
2. 计算机网络：七层协议，网络里面如何发送包的，每一层做了什么，TCP三次握手四次挥手，网络层丢包咋办，网络流量如何知道的，DNS如何查询的IP，域名怎么解析的,路由器查询
3. 数据库：关系型数据库和非关系型数据库的区别，举例子
4. Kafka的基本结构，partition broker配置，底层怎么实现的，
5. SpringBoot与Spring区别，配置，如何导入的jar包，xml文件，什么是自动织入，什么是DI， 有哪些常见的组件
6. 写过多少行代码？
7. Linux熟练吗？说几个命令

#### 1面
1. fork底层实现
2. 进程之间的通信机制
3. 死锁的产生和避免
4. socket如何知道连接关闭
5. TCP可靠传输的实现
6. UDP和TCP的区别
7. UDP怎么保证有序
8. 垃圾回收机制GC
9. 红黑树的插入和删除
10. 链表二分查找
11. 怎么保证内存可见性
12. volatile底层实现
13. HashMap哈希函数的认识，JDK1.8采用的hash函数

编程题目：
1. 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出 b。
hashmap
2. 写出快速排序
3. 有100本书， 两人轮流拿，每次最多拿5本，最少拿一本。你先拿，能否保证你拿到最后一本，如何保证？

#### 2面
1. 千万级的用户，提供一个服务，该服务有很多模块，现在有一个底层模块需要优化，问怎么实现，在不影响其他服务模块以及用户体验的情况下
2. 未知大小的文件，翻转整个文件
3. 大数据搜索
4. KMP算法
5. 跳台阶问题
6. TCP滑动窗口，拥塞控制
7. C++ 虚析构、模板和宏, malloc和new的区别
8. 进程与线程的区别，共享的数据, 进程内存空间


#### 3面
1. 项目1
2. Kafka可靠性怎么实现
3. Kafka与RocketMQ区别
4. 发送的数据异常怎么处理
5. 异常的类型，怎么捕获
6. 你们用了哪些架构
7. 说一下你用过的设计模式
8. 说一下pingback怎么做的
9. NIO说一下
10. 流式计算平台有哪些好处
11. 项目2
12. Spring事务怎么实现
13. 平时写过并发吗
14. 你了解哪些并发容器
15. Java1.8 1.7区别
16. 对并发包的了解
17. HashMap1.8与CurrentHashMap区别
18. 为什么会HashMap1.7线程不安全
19. 线程池的几种饱和策略
20. 实习中遇到的最大的困难
21. 你觉得做过的最有挑战的事情


#### 1面
1. 自我介绍
2. 容器类，HashMap与HashTable区别
3. 链表类，LinkList与ArrayList区别
4. 聚簇索引和非聚簇索引的区别
5. Innodb和MyIsAM的区别
6. Java里面锁实现机制，区别
7. 垃圾回收算法
8. HashMap扩容
9. Spring IOC容器
10. 项目里面遇到的困难，如何解决
11. 分布式问题
12. SQL查询时limit用法
13. 最近看的论文
14. synchronized关键字 lock
15. 对称二叉树，非递归实现二叉树后序遍历

#### 2面
1. fork底层实现
2. 进程之间的通信机制
3. 死锁的产生和避免
4. TCP可靠传输的实现
5. UDP和TCP的区别
6. UDP怎么保证有序
7. 垃圾回收机制GC
8. 实习里推荐系统设计
9. 链表二分查找
10. JVM怎么保证内存可见性
11. volatile底层实现
12. 15匹马5个赛道找到最快的三匹

#### 3面
1. 项目1里的东西
2. kafka原理，数据发送机制
3. 每天传输的数据流量，数据丢失，数据去重怎么解决
4. kafka的配置，partition多少
5. HTTP里吗PUT，HEAD，POST，GET区别
6. HTTP状态码代表的含义
7. Linux命令，awk,grep,sed,du
8. 项目2里的东西
9. 项目里你做了什么
10. Spring定时任务
11. Mysql分区分表怎么实现
12. MySQL查询优化
13. Spring的IOC，AOP，项目里有用吗，解释
14. 日志怎么做的
15. Redis常用的数据结构
16. 单例模式, 工厂方法, 抽象工厂, 策略模式, 观察者模式, 代理模式, Spring动态代理

#### HR面
1. A公司与B公司的区别
2. 怎么看加班
3. C公司和D公司的区别
4. 你未来的打算
5. 为什么来这个部门
6. 你对部门有了解吗
7. 你来了之后做什么
8. 你能实习多久
9. 如果遇到问题你会怎么解决
10. 本科学了哪些东西印象比较深
11. 你觉得硕士期间最大的收获是什么


### 秋招面经

#### 1面
1. 自我介绍
2. 数据库：数据库的分类，索引和主键，索引建多了有什么坏处，主键和索引的区别，为什么索引会加快查询速度，什么是聚簇索引什么是非聚簇索引，数据库如何恢复；
3. 网络：什么是HTTPs, HTTPS建立连接的过程是什么，什么是非对称加密，HTTP请求方式，请求之间的调用关系，Get Post区别
4. JVM：虚拟机内存结构，垃圾回收，GCRoot上都有啥，双亲委派模型，对象在堆上还是栈上，Java创建对象的过程，代码编译的过程，static 构造函数父子顺序
5. 操作系统：进程和线程的区别，进程线程资源共享吗，操作系统资源调度基本单位，进程之间怎么发生死锁，synchronized的范围，偏向锁、轻量级锁、重量级锁区别；
6. Android：四大组件
7 .说几个设计模式并解释，装饰器和适配器的区别
8. 项目中遇到的最难解决的问题是什么？并发怎么考虑？
9. 编程题，移动一个数字，变成比当前数字大但是最小的数字：思路，找到前面小于后面的然后交换，剩下的升序排序


#### 2面
1. 客户端和Web安全性，怎么避免恶意攻击后端网站；
2. 反射两种实现方式，class.getName和class.getDeclareName区别，私有变量怎么访问；
3. 客户端模拟ip和环境给服务端发请求，怎么避免和识别恶意工具
4. 什么时候会初始化一个类？
5. static加载顺序？
6. Java对象产生的过程
7. 创建一个数组一定会给数组中的元素赋默认值吗？
8. 双亲委派模型有什么优势，为什么要用它？
9. 客户端与服务端连接是长链接还是短连接，怎么保证应用推出之后，还能收到消息提醒？
10. 最满意的一个实习经历是什么？
11. Spring MVC调用过程？
12. 会写前端吗？掌握到什么程度？
13. synchronized加在不同的地方有什么效果，怎么锁住一个类？
14. kafka零拷贝技术知道吗？怎么在一致性和可用性寻求平衡？
15. TCP，UDP区别；为啥看视频用的UDP不保证顺序，但是画面还是一致的？
14. 算法题：给一个起点和金矿点的二维数组，里面有障碍物和权重，从起点出发，最短时间内找到最优路径并计算代价 。（说了下思路，时间不够了没写）


#### 3面
1. 介绍项目，根据项目提问题Java基本知识或者项目里面的知识
2. 介绍CNN算法，决策树算法
3. 怎么保证转账一致性，***业务流程，转错账，对方钱到账了而且取出来了怎么办？
4. 异地多活容灾怎么保证，CDN，服务降级，服务熔断有没有实现过？
5. 负载均衡实现有什么思路吗？
6. 主从复制，可用性和一致性怎么解决？
7. 遇到的最困难的一个bug是啥？最近遇到的一个bug是啥，怎么解决的？
8. 说一下工作用到的设计模式并解释？
9. Java字节码分析一下里面都有啥？
10. 反射怎么实现？动态代理和静态代理的区别？
11. 为啥不找算法岗，说一下你的论文思路和方法，比赛效果好是怎么做到的？
12. 怎么快速学习一门技术？
13. RPC服务注册中心以及调用过程？
14. 支付的消息事务一致性怎么保证？
15. 为什么来这边工作而不是留在蚂蚁？
16. 工作城市，未来计划，如果来这边工作，你觉得要学些什么？


#### 4面
1. 为啥选择我们这边？
2. 未来2年的职业规划？
3. 我们这边的优势？
4. 公司的APP有什么建议？
5. 如何提升自己？


####  1面

1. 链表反转
2. 快速排序
3. 多种方法解决1000万个数据中找出第100万个小的数字并找到；多个方法并说一下复杂度
4. 计算机网络三次握手
5. 操作系统：进程线程区别，虚拟内存，线程通信
6. 两个孩子，其中一个男孩，另外一个女孩的概率
7. 个人爱好
8. 算法项目里面的逻辑和思路是什么
9. ***项目中遇到的问题和思路
10. 介绍部门


#### 1面

1. 说下项目架构，以及三种实现方式的区别和优缺点
2. 怎么做容灾
3. 负载均衡的实现
4. 事务的类型，中间件的区别
5. 配置中心架构图
6. AI怎么用到项目里面
7. 异地多活高可用
8. 怎么查询异常
9. 怎么快速学习
10. 一致性事务，幂等控制
11. 项目架构的改进

#### 2面

1. 讲PPT，部门介绍，实习期间框架，业务大图，我完成了哪些任务，重点突出一些任务，开源实现，论文，学校做的东西，怎么用到项目中，未来的规划，想成为什么样的人，为什么做开发，喜欢技术还是喜欢业务
2. 讲PPT，每一页要有一个核心的观点去总结，要举例子更有代入感，把握好时间，及时观察听众的感受


#### 3面

1. 技术面试：消息中间件设计原理，TCC一致性原理，配置中心
2. 业务面试：做什么，解决什么问题，看过源码吗，为什么这样设计，缺点是什么，你怎么改进，画项目架构图
3. 你参与了哪些事情，以后有什么打算，怎么解决可配置化，怎么做到服务化，你实习期间的贡献是什么

#### 1面

1. 说下在***的实习经历，根据实习经历提几个问题，数据丢失怎么办，怎么保持一致性
2. Spring相关：解释下IOC，解释下自动注入的几个方法，多个方法实现@Autowride怎么辨别，解释下@Configure里面@Bean系统调用的时候创建了几个类，怎么保证线程安全
3. Java并发相关，几种同步的方式，synchronized方法加在类上和方法上和this上有什么区别，Java同步怎么保证线程安全，说一下几个常用的并发包并解释远离，乐观锁、悲观锁，Java8源码红黑树，Map的put操作，扩容操作, B树与B+树
4. 数据库相关：数据库隔离模式并解释；什么是脏读、不可重复读、幻读，什么是聚簇索引和非聚簇索引，说下B+树，不同索引叶子结点是什么，数据库锁有哪几种，两种代码实现事务的方式，索引的查询过程，乐观锁悲观锁的执行过程
5. kafka为什么高效，零拷贝技术，kafka的设计架构，kafka拉模式还是推模式，CAP理论，事务型消息
6. shell脚本执行原理，定时任务执行原理，说几个Linux命令并解释
7. Map Reduce,Spark原理说下
8. 分布式缓存的一致性，服务器如何扩容
9. Redis缓存和数据库会存在一致性问题吗？怎么解决
10. Redis哨兵、集群的设计原理和区别


#### 2面

1. 说下项目，根据项目提问几个设计上的方法，消息一致性，幂等性，每天多少业务量
2. Java虚拟机，Java内存模型，元空间和方法区的区别，虚拟机各部分都是干嘛的，内存泄漏举例子，虚拟机调优，AtomicInteger怎么实现原子修改的
3. kafka，msgbroker区别，高性能的原因，零拷贝技术，异步刷盘，内存换入，说一个最常用的消息中间件的组建
4. 数据库索引，间隙锁，B+树原理，数据库底层对查询的优化，聚簇索引和非聚簇索引，数据库，varchar与char的区别，innodb一定会有一个索引吗，索引的目的
5. 怎么防止数据丢失，主从复制原理，机器挂掉之后，怎么保证线程出内存中的数据能够正常处理
6. 设计一个高性能、高可用的分布式系统，结合CAP理论，根据你的回答会提出问题，比如缓存，并发
7. 三个实习过程收获最大的是什么，成长了什么，怎么去学习的？怎么提升自己，有没有开源实现
8. 怎么做一个负载均衡中间件，说下SpringCloud，说下怎么限流，怎么熔断，SpringBoot的优势 rpc底层协议 与http传输的区别
9. 你有什么问题要问我的吗：你们这边做的业务是什么、技术栈、团队人数


#### 3面

1. 说下项目，实习期间做的东西，有什么收获
2. 数据库锁，乐观锁，间隙锁
3. 网络，四次挥手，长连接，短连接
4. 操作系统：内核态，用户态，管程，作业调度算法
5. 最近用过的并发包，锁的几种方式
6. Java线程池的参数有哪些，解释含义
7. 讲一下Dubbo，Nginx，微服务，rpc，你是怎么理解的
7.  编程题：旋转数组中的最小数字，分析复杂度，并给出测试用例覆盖了100%
8. 目前有哪些offer，说下他们的优势，未来什么打算，做技术还是做业务
9. 为什么有论文还做开发不是做算法

### 面试心得

1. 最好有一个实习经历或者项目经历
2. 实习期间有好的想法能对项目做出一些优化
3. 复习直接按照JD上的内容准备即可
4. 回答面试问题要考虑全面，最好能够通过之前做过的例子去讲
5. 根据面试官的反馈和语气灵活应对
6. 基本功要好，多刷题，有一定的算法基础和计算机基础
7. 针对不同公司准备不同简历，大厂深挖项目细节，国企看中基础和广度，外企看中算法能力
8. 好好准备，面试题很基础的不能答错，整体90%以上正确率，算法题一定要能写出来

### 推荐几本书

#### 基础课
- 计算机网络(TCP/IP协议族，TCPIP协议卷一，计算机网络第六版)
- 操作系统，组成原理，算法与数据结构， 设计模型，Java或者C++，这些本科期间最基础的书

#### Java
- 阿里巴巴-码出高效
- Java编程思想/核心技术卷一卷二
- Java并发编程实战/Java并发编程的艺术/Java多线程编程核心技术
- 深入了解Java虚拟机

#### 数据库
- MySQL权威指南
- Redis实战
- HBase实战

#### 架构与设计模式
- 大规模分布式存储系统
- Spring实战
- 微服务架构设计模式
- 大话设计模式
- Java与模式

#### 算法与数据结构
- 算法导论
- 剑指Offer或者刷LeetCode
- 轻松学算法
- 程序员代码面试指南

#### 中间件与分布式
- kafka权威指南
- 从Paxos到Zookeeper分布式一致性原理与实践
- Netty权威指南
- 云原生Java开发

#### 机器学习
- 机器学习西瓜书
- 统计学习方法

#### 学习路线图
https://github.com/guangxush/Petal/tree/master/image


此外可以通过关注几个比较不错的公众号去学习，及时了解新技术
