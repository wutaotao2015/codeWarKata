[TOC]
#### 需要材料
1. github账号及仓库
2. node.js
   (建议从官网上下载安装包安装，homebrew等下载速度太慢)
   安装好后用node -v查看是否安装成功
3. git
   安装好后用git --version查看是否安装成功

#### 简易步骤
##### 登录github创建仓库（username.github.io)
在本地生成公钥并上传到github上，

输入命令
`ssh-keygen -t rsa -C "github注册邮箱地址"`

##### 在本地任意目录下初始化博客，
输入命令
`hexo init blog`
这样创建了目录blog,这就是博客的项目
hexo常用命令有

```txt
hexo clean  // 清楚缓存，网页正常可不用
hexo n maven源码解析 // new,新建文章，后面为题目，默认是md格式
hexo s -g   // 生成静态文件并启动本地服务，默认端口4000
hexo d -g   // 生成静态文件并发布到github仓库中
```
##### 启动服务前需要修改blog根目录下的配置文件deploy选项
```txt
deploy:
type: git
repo: XXXX.github.io
branch: master
```
##### 修改完配置文件并保存后，直接起服务hexo s报错
`deployer not found: git`
这是正常的，需要安装hexo部署到git的插件，命令为
`npm install hexo-deployer-git --save`

##### 更换主题
##### 添加评论功能
##### 添加阅读次数
##### 打开标签等其他功能
##### 增加点赞功能
##### 文章字数统计
##### 头像显示
##### 收录到百度和谷歌
[七牛云批量获取文件外链接](https://developer.qiniu.com/kodo/kb/4072/batch-obtains-download-chain-method/)
[不同电脑更新博客](https://www.zhihu.com/question/21193762/)

