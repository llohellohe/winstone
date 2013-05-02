####启动
进入WINSTONE_HOME/bin

运行 start.sh

浏览器查看：http://localhost:8080/o2/index.html


####创建Web-App

使用maven命令生成app:

	mvn archetype:generate -DgroupId=yangqi.webapp -DartifactId=o2-web -DarchetypeArtifactId=maven-archetype-webapp
	
然后打包成war包:
    
    mvn package
    
可以看到targt下有个war包


####在Jboss 7 中启动

拷贝war包到AS7/standalone/deployments 目录中 。



####启动内部的
enable-welcome-root 设置为false

