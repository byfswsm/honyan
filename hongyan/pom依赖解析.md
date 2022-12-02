### 根POM的properties

```xml
<properties>
        <java.version>1.8</java.version>
        <common.version>0.0.1-SNAPSHOT</common.version>
        <lombok.version>1.18.22</lombok.version>
        <mybatis-plus.version>3.4.2</mybatis-plus.version>
        <druid.version>1.2.8</druid.version>
        <jwt.version>3.4.0</jwt.version>
        <fastjson.version>1.2.78</fastjson.version>
        <hutool.version>5.7.16</hutool.version>
        <freemarker.version>2.3.31</freemarker.version>
        <apm-toolkit-logback-1.x.version>8.8.0</apm-toolkit-logback-1.x.version>

        <!--统一验证平台特有-->
        <xxl-sso-core.version>1.1.0</xxl-sso-core.version>
        <tencentcloud-sdk-java.version>3.1.270</tencentcloud-sdk-java.version>
        <weixin-java-mp.version>4.1.0</weixin-java-mp.version>
        <weixin-java-common.version>4.1.0</weixin-java-common.version>
        <!--统一验证平台特有-->

    </properties>
```





### 公共组件COMMON

```xml
<!--  Springboot,SpringbootWeb,lombok,skywalking,druid,mysql,mybatisPlus,jwt,fastjson,hutoll-->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- skywalking & logback 整合输出traceId-->
        <dependency>
            <groupId>org.apache.skywalking</groupId>
            <artifactId>apm-toolkit-logback-1.x</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>

        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>
    </dependencies>
```





