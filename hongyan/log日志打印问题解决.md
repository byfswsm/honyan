1. #### 把所有日志相关的依赖删掉

2. #### 因为我们已经在COMMON组装了skywalking依赖,如下.所以我们不需要再引入了

3. ```xml
    <!-- skywalking & logback 整合输出traceId-->
           <dependency>
               <groupId>org.apache.skywalking</groupId>
               <artifactId>apm-toolkit-logback-1.x</artifactId>
           </dependency>
   ```

4. #### 然后我们只需复制别的项目中已经在resources文件夹中配置好的logback.xml就行

