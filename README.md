# file-flow
项目主要功能是提供文档管理，支持用户登陆验证，支持根据项目和自定义文件夹对文档进行分类管理，前后端分离，
前端项目地址: [https://github.com/mingo-tt/file-flow-web](https://github.com/mingo-tt/file-flow-web) 。

## 介绍

**项目用到的一些框架/服务：**

- **数据库**： MySQL，数据库.sql文件 [file-flow.sql](./file-flow.sql)
- **缓存**： Redis
- **权限框架** ：Spring Security，友情链接: [spring-security-jwt-guide](https://github.com/Snailclimb/spring-security-jwt-guide)
- **ORM框架** ：MyBatis-Plus

## 代办

- [ ] 添加系统管理模块(用户管理, 角色管理)
- [ ] 完善文档预览功能(目前只支持.pdf文档的预览)
- [ ] 添加文档的访问授权
- [ ] 增加Swagger，方便调用接口

## 如何运行项目

1. git clone https://github.com/Snailclimb/spring-security-jwt-guide.git
2. 打开项目并且等待 Maven 下载好相关依赖。建议使用 Intellij IDEA 打开
3. 下载 redis 并`application.yaml`中添加redis的配置
4. 执行 [file-flow.sql](./file-flow.sql) 文件 并在`application.yaml`中修改 datasource 的配置
5. 运行项目
- 说明: 目前只有一个登陆账号: admin 123456
