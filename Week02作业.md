### 1.（选做）使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。
#### 串行GC
javac -encoding utf-8 GCLogAnalysis.java
java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776502-a6856b2f-7410-40b4-80fd-59db49fdd968.png)

#### 并行GC
java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776676-1d7980ea-7beb-48eb-a7ce-64ee340066ee.png)

#### CMS
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776627-f8bfe479-3d1f-4e14-b5fc-dbbe0b85f4b8.png)

#### G1
java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
![image](https://user-images.githubusercontent.com/37387831/134776719-c87378b7-0373-47a7-81a0-f33c1aeef8c9.png)
