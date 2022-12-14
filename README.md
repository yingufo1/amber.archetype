# amber.archetype
amber项目的微服务骨架.基于spring-boot(version:2.4.3)和spring cloud(version:2020.06)部分组件(Feigen/robin/hryrixy)等构成的微服务应用框架。</br>
需要修改的基础配置信息，需要修改application.yml文件。在配置中注释中添加todo的是需要修改的，包括：
- spring.application.name ,应用名

此外，在应用启动时最好添加如下启动参数
- -DappName=xxx ,logback需要的应用名
- -Denv=dev/fat/uat/pro，apollo需要的环境名

# 已集成组件
已集成的组件，大部分情况下不需要修改配置，特殊情况在各部分有具体描述
## shardingshpere-jdbc
version(5.1.1)
支持分库表，druid数据库连接池。
- 如果使用amber_00库，不需要修改配置
- 如果使用新库，需要修改配置
- 如果新增表，需要新增分库和分表策略，主键序列生成策略
## Eureka
支持服务注册和发现
## Feign
支持http客户端，根据应用自己依赖的服务进行配置
## apollo
version(1.7.0)
支持apollo配置中心，使用默认的应用名命名规则(与spring.application.name)相同的话，不需要修改

# 代码分层
基于六边形架构、分层架构、微服务架构等理念，将应用代码按照如下目录结构组织
## 适配层
controller：请求的入口，发布基于http的接口API</br>
endpoint：端口，包括回调、消息消费者、生产者等入口和出口</br>
## 领域层
entity：业务实体，一般与数据库表对映。其目录下的对象基本上是贫血模型的POJO，也可以加入一些简单的实体行为</br>
service：业务实体的复杂的行为可以用service封装。entity+service可以看做是一个实体的充血模型的完整实现。</br>
biz:复杂业务逻辑的实现，可能需要多个业务实体共同完成的业务逻辑在这里实现</br>
mapper：mybatis的dao接口或实现

# RoadMap
## 基础组件集成
1.0和2.0是必定包括的内容，3.0是微服务增强功能，根据个人时间条件尽量完成。

|版本|日期|组件|集成笔记|
|--|--|--|--|
|1.0|已完成|shardingshpere-jdbc[5]|https://note.youdao.com/s/WuPbLXRE|
|||Eureka[spring-cloud-starter-netflix-eureka-server:2.2.0.RELEASE]|https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.2.7.RELEASE/|
|||Feign/OpenFeign|https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.2.7.RELEASE/|
|||Apollo[2.1.0-SNAPSHOT]|https://note.youdao.com/s/HydEd09A|
|2.0|0922[计划变更，插入自动化脚本和重构公共接口处理的内容，要改到0926了]|redis[7.0.4]|集群搭建：https://note.youdao.com/s/VgjyQj1U</br>redisson https://note.youdao.com/s/S8jGYkZE</br>redission集群问题解决：参考https://note.youdao.com/s/JNvUZiq9 中四层反向代理部分|
|||rocketMq[4.9.4]|https://note.youdao.com/s/UWf48PS6|
|||自动化发布脚本|https://github.com/yingufo1/amber.archetype/blob/main/deploy/%E8%87%AA%E5%8A%A8%E5%8C%96%E9%83%A8%E7%BD%B2%E8%84%9A%E6%9C%AC%E8%AF%B4%E6%98%8E.MD|
|||重构优化接口公共处理：</BR>- 请求响应日志AOP </BR>- 错误码定义 </BR>- 异常定义，不要直接抛出运行时异常 </BR>- 请求/响应DTO优化 </BR>- 参数校验错误返回统一处理，不要让springmvc拦截处理</BR>- MDC|done|
|||熔断、限流||
|3.0||安全(认证和授权)||
||1007|ETL(cancl+flink+es)||
|||ELK(skywalking/jeager+filebeat+logstash+es)||

## 服务能力
### 金融核心
- 账户账务
- 清结算
- 签章
### 用户中心
- 用户
- 身份认证

### 信贷域
- 信用额度
- 还款计划
- 贷前
- 贷中
- 贷后
### 风控域
### 资金域
- 资金路由
- 资金方管理
- 资金方还款计划





