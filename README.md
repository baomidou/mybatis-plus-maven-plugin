##mybatisplus-maven-plugin 简介
  * [mybatis-plus](http://git.oschina.net/baomidou/mybatis-plus) 代码生成工具的 maven 插件版本
  * 所有配置均包含在以下的xml中
    
```xml
<plugin>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatisplus-maven-plugin</artifactId>
    <version>1.0.0</version>
    <configuration>
        <!-- 输出目录(默认java.io.tmpdir) -->
        <outputDir>e:\cache</outputDir>
        <!-- 是否覆盖同名文件(默认false) -->
        <fileOverride>true</fileOverride>
        <!-- mapper.xml 中添加二级缓存配置(默认true) -->
        <enableCache>true</enableCache>
        <!-- 开发者名称 -->
        <author>Yanghu</author>
        <!-- 数据源配置，( **必配** ) -->
        <dataSource>
            <driverName>com.mysql.jdbc.Driver</driverName>
            <url>jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&amp;useSSL=false</url>
            <username>root</username>
            <password>123456</password>
        </dataSource>
        <strategy>
            <!-- 字段生成策略，四种类型，从名称就能看出来含义
            nochange(默认),
            underline_to_camel,(下划线转驼峰)
            remove_prefix,(去除第一个下划线的前部分，后面保持不变)
            remove_prefix_and_camel(去除第一个下划线的前部分，后面转驼峰) 
            -->
            <naming>underline_to_camel</naming>
            <!-- ID策略 是LONG还是STRING类型(默认stringtype)-->
            <serviceIdType>longtype</serviceIdType>
            <!--Entity中的ID生成策略（默认 id_worker）-->
            <idGenType>uuid</idGenType>
            <!--自定义超类-->
            <!--<superServiceClass>net.hyman.base.BaseService</superServiceClass>-->
            <!-- 要包含的表 与exclude 二选一配置-->
            <!--<include>-->
                <!--<property>sec_user</property>-->
                <!--<property>table1</property>-->
            <!--</include>-->
            <!-- 要排除的表 -->
            <!--<exclude>-->
                <!--<property>schema_version</property>-->
            <!--</exclude>-->
        </strategy>
        <packageInfo>
            <!-- 父级包名称，如果不写，下面的service等就需要写全包名(默认com.baomidou) -->
            <parent>net.hyman</parent>
            <!--service包名(默认service)-->
            <service>service</service>
            <!--serviceImpl包名(默认service.impl)-->
            <serviceImpl>service.impl</serviceImpl>
            <!--entity包名(默认entity)-->
            <entity>entity</entity>
            <!--mapper包名(默认mapper)-->
            <mapper>mapper</mapper>
            <!--xml包名(默认mapper.xml)-->
            <xml>mapper.xml</xml>
        </packageInfo>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>
    </dependencies>
</plugin>

