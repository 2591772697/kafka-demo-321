[Git保存和清除用户名、密码—HI技术分享 (hi917.com)](https://www.hi917.com/detail/43.html)

#### 一、配置成全局永久保存

1、配置用户名：username

> git config --global user.name “username”

2、配置邮箱：user@email

> git config --global user.email “user@email”

3、配置密码

> git config --global credential.helper store

该命令会记住密码，执行一次 git pull 或 git push 等需要输入密码的命令，输入一次密码。

4、查看配置

> git config --list

5、清除密码

> git config --global --unset credential.helper

#### 二、临时保存

1、默认记住15分钟

> git config –global credential.helper cache

2、自定义时间

> git config credential.helper ‘cache –timeout=3600’