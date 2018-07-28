## 基于SpringCloud实现的分布式电商网站

### 服务发现（Eureka）
1. Eureka Server
2. Eureka Client
   
### 分布式配置（Spring Cloud Config）
1. Config Server
2. Config Client
3. Git和Refresh
4. 自动刷新配置
5. 消息总线（配合RabbitMQ）
   
### 服务通信
1. Feign
2. Ribbon（负载均衡）
3. RestTemplate
   
###  网关 （Zuul）
1. 动态路由
3. 异常网关统一处理
3. 鉴权，权限校验
4. 限流
   
### 熔断 （Hystrix）
1. 服务容错
2. 降级策略
3. 超时熔断

### 服务追踪（Spring Cloud Sleuth）
1. 链路追踪
2. zipkin



### 基础服务
- 注册中心 http://localhost:8761
- 配置中心 http://localhost:8082
- 服务网关 http://localhost:8083

### 业务服务
- 商品服务 http://localhost:8080
- 订单服务 http://localhost:8081
- 用户服务 http://localhost:8084

### 中间件
- 消息总线RabbitMQ  http://localhost:15672

### 架构图
![](https://github.com/zaiyunduan123/springcloud_shop/blob/master/image/image.png)
