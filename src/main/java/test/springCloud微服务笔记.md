### springBoot简介

#### 起步依赖

springboot 按不同的功能模块将需要的jar包整合为一个起始包,如web应用，jpa，微服务等不同模块
所需要的jar包统一封装起来,不用手工管理具体的jar包。

springboot的版本号决定了starter依赖包的版本号，而starter依赖包的版本号决定了其聚合的依赖
包的版本号，其内部版本都是经过测试的，没有冲突问题。

#### 自动配置

springboot使用条件化bean的方法判断classpath中是否有相应的jar包，若有，它会在项目运行时
自动生成对应的实例bean.

如项目classpth中用了h2,自动配置会自动创建一个H2数据库bean；
classpath中有springMVC(由webStarter依赖而来),它会自动配置dispatcherServlet并启用springMVC;
classpath中有tomcat(webStarter依赖而来),它会自动启动一个tomcat容器。

#### Actuator监控工具
#### 命令行工具
