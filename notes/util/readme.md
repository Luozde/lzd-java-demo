# 工具类

## Spring

### SpringUtils类

- 介绍

从Spring容器中获取指定的Bean对象

- 用法
```java
protected MsgHandlerFactory bean = SpringUtils.getBean(MsgHandlerFactory.class);
```

- [源码](./spring/SpringUtils.java)

### ApplicationContextUtil类

- 介绍

动态注入单例bean实例至Spring容器

- 用法
```java
AppLicationContextUtil.registerSingletonBean("beanName", singletonObject);
```

- [源码](./spring/ApplicationContextUtil.java)
