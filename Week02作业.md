### 1.（选做）使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。
#### 串行GC
javac -encoding utf-8 GCLogAnalysis.java

java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134808416-bfd0eae2-d80a-459c-8b83-03d29f1ccc59.png)

#### 并行GC
java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776676-1d7980ea-7beb-48eb-a7ce-64ee340066ee.png)

#### CMS
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776627-f8bfe479-3d1f-4e14-b5fc-dbbe0b85f4b8.png)

#### G1
java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776719-c87378b7-0373-47a7-81a0-f33c1aeef8c9.png)

### 4.（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。
#### Serial GC
-XX:+UseSerialGC
串行 GC 单线程执行，在 GC 期间其他业务线程均暂停，暂停的时间长。
串行 GC 对年轻代采用标记复制算法。对老年代使用标记-清除-整理算法。
串行 GC 简单直接，在单核 CPU 环境下比较适用。
-XX:+UseParNewGC
ParNew 收集器，多线程版本的 Serial。配合 CMS 使用。
#### Parallel GC
-XX:UseParallelGC -XX:UseParallelOldGC
使用的 GC 算法和串行的一样。
默认的 GC 线程数是 CPU core 数，该收集器的目标更倾向于提高系统吞吐量，有时候单次的 GC 暂停时间较长。
#### CMS GC
-XX:UseConcMarkSweepGC
对老年代没有整理操作，使用 free-list 进行内存空间的管理。默认的核心线程数 CPU 核数 / 4。
可以和业务线程并发执行，GC 暂停时间少。
#### G1 GC
打破整个分区的理论，把内存划分成多个小块进行管理。对每个小块的垃圾数量进行预估，优先回收垃圾多的 Region。可预期的垃圾停顿时间。
