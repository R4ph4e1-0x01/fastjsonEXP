# Fastjson  exp 集合

### Fastjson版本控制

通过自定义类加载器从文件中加载fastjson的jar包， 便于调试exp时排查exp支持的fastjson版本。

例如：
使用
```FastjsonVersionCtr myFastjson = new FastjsonVersionCtr("1.2.66");```
即可限定当前fastjson为1.2.66版本。


### java环境
该项目在编写和测试时使用jdk1.8.0_112，该版本对于JNDI注入限制小，如果在高版本运行请自行修改安全管理器配置。

### fastjson黑名单
目前fastjson黑名单包名不是明文的，需要碰撞哈希，目前已有收集fastjson黑名单的项目。[移步github项目](https://github.com/LeadroyaL/fastjson-blacklist)


### 声明
仅用于漏洞学习，请勿用于非法途径