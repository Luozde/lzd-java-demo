# Spring 全局异常处理介绍

Spring 统一异常处理有 3 种方式，分别为：

- 使用 @ExceptionHandler 注解
- 实现 HandlerExceptionResolver 接口
- 使用 @ControllerAdvice 注解

其中，实现全局异常处理有如下2种方式：

1. 使用 @ExceptionHandler 注解 + @ControllerAdvice 注解, 使用方法参考本案例；
2. 实现 HandlerExceptionResolver 接口

参考资料：
- [使用spring的AOP进行统一异常的处理](https://blog.csdn.net/weter_drop/article/details/103067641)
- [@ControllerAdvice + @ExceptionHandler 全局处理 Controller 层异常](https://github.com/kinginblue/KingBlogSamples/tree/master/exception-handler)
- [Spring MVC异常统一处理的三种方式](https://www.cnblogs.com/junzi2099/p/7840294.html#_label1)
