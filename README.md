2020年2月24日15:15:46
1. 导入依赖
2. 编写配置文件
3. 开启这个功能 @EnabledXXXXXX
4. 配置类


2020年3月6日22:49:44
1. hystrix-dashboard只能ping到
@EnableCircuitBreaker//获取熔断的支持  的服务        @HystrixCommand(fallbackMethod = "hystrix_get")  的方法