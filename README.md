# SpringbootProject
SSM框架，VUE，前后端分离实践  
***Reproduced from: [bilibili](https://www.bilibili.com/video/BV1y7411y7am?from=search&seid=12705559201586858813)***  
***VUE: [VUE](https://www.bilibili.com/video/BV12J411m7MG?from=search&seid=10768844227077221349)***  
***在线接口文档: [API Document](http://localhost:8001/swagger-ui.html)***

## 依赖
1. JDK: 1.8
2. maven: 3.6.3
3. Springboot: 2.2.1

## 分支
1. master: 稳定版
2. dev: 开发版
3. wzq: 个人开发
4. lxc: 个人开发
5. wzqTest: 测试分支
6. lxcTest: 测试分支

## JAVA
1. JAVA摩登网: http://www.javaclimb.com
2. JAVA NOTES FROM WZQ : [JAVA NOTES](https://github.com/Alex-Wzq/Notes/tree/master/Interview/Java).

## JAVA面试要求
1. Java 基础扎实，掌握常见数据结构、多线程等知识，有多线程、高并发应用系统的设计、开发经验者优先 
2. 熟练使用java web框架并了解其原理，例如spring、springmvc、struts2、mybatis等 
3. 熟悉主流的分布式、缓存、消息等开源框架，如：kafka、zooKeeper、redis等，有实时计算经验者优先（使用过storm flink） 
4. 了解http协议及常用的开发组件，如：http client等。 
5. 对JVM原理及调优有一定了解。 
6. 熟练使用git,maven 等工具。 
7. 了解分布式应用系统的设计和开发。

1. 可以说一些spring的注解?
RequestBody, ResponseBody, PathVariable

## 主键自动生成
1. [分布式系统唯一ID生成方案汇总](https://www.cnblogs.com/haoxinyue/p/5208136.html)
2. DB: AUTO INCREMENT
3. UUID: 每次操作生成一个随机位置值 (id值无法排序)
4. Redis生成ID
5. mp自动生成19位 (Twitter的snowflake算法)
```java
    // @TableId(type = IdType.INPUT) // 需要自己输入
    // @TableId(type = IdType.NONE)  // 需要自己输入
    // @TableId(type = IdType.UUID) 
    // @TableId(type = IdType.ID_WORKER) // mp自带，生成19位，数字类型使用这种策略
    // @TableId(type = IdType.ID_WORKER_STR) // mp自带，生成19位，字符串类型使用这种策略
    // @TableId(type = IdType.AUTO) // 自动增长，默认，雪花算法
```

## 自动装配
MyBatis Plus提供了MetaObjectHandler接口实现字段在创建和更新时的自动装配

## 三种环境
1. dev: 开发环境
2. test: 测试环境
3. prod: 生产环境

## 代码生成器
1. Velocity 模版引擎，Mybatis Plus代码生成器需要
2. 不需要部署，放到测试环境
3. 是一个java脚本 CodeGenerator.java

## Swagger
1. 在线接口文档
2. 可以直接进行接口测试

## Json
1. 一般Json只有对象和数组两种格式
2. 统一标准格式:
    ```json
    {
      "success": true,
      "code": 20000,
      "message": "成功",
      "data": {
      "items": [
          {
            "id": 1,
            "name": "Alex",
            "Intro": ""
          }      
        ]    
      } 
    }
    ```
3. 分页格式: （total: 总共多少记录数）
    ```json
    {
      "success": true,
      "code": 20000,
      "message": "成功",
      "data": {
          "total": 17,
          "rows": [
              {
                "id": 1,
                "name": "Alex",
                "Intro": ""
              }      
            ]    
      } 
    }
    ```
4. 没有返回数据:
    ```json
    {
      "success": true,
      "code": 20000,
      "message": "成功",
      "data": {}
   }
    ```
5. 失败
    ```json
    {
      "success": false,
      "code": 20001,
      "message": "失败",
      "data": {}
   }
    ```
6. 通用格式
    ```
    {
      "success": boolean,
      "code": Integer,
      "message": String,
      "data": HashMap
   }
    ```

## 异常处理
1. 全局异常
2. 特定异常
3. 自定义异常

## 日志
1. 日志级别: OFF, FATAL, **ERROR**, **WARN**, **INFO**, **DEBUG**, ALL（后面包含前面, 要背的）
2. 工具: Log4j, Logback