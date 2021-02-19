# McBot使用说明

## 配置说明

1. 配置MC服务器目录下server.properties的rcon

   ```properties
   enable-rcon=true
   rcon.port=25575
   rcon.password=123asd123
   ```

2. 配置mcbot相同文件夹中的application.yml

   ```yaml
   rcon:
     host: 服务器地址
     port: 25575
     password: 123asd123
   
   bot:
     admin: 管理员/主控QQ号(这个可以不设置，群管理可以直接控制)
     white-list:
       - 白名单群号1
       - 群号2
       - ...（根据实际情况配置，不在配置的群不响应
   ```

3. 运行Minecraft服务器

4. 运行mcbot，指令如下

   ```bash
   java -jar mcbot.jar
   ```

5. 运行[ProtobufBot](https://github.com/ProtobufBot)

   - 方案一：下载并配置运行GMC => [Go-Mirai-Client](https://github.com/ProtobufBot/Go-Mirai-Client)
    
   - 方案二：下载并配置运行SMC=> [Spring-Mirai-Client](https://github.com/ProtobufBot/Spring-Mirai-Server)

   - 方案三：Linux安装docker后使用docker运行

     ```bash
        docker run -it \
        -p 9000:9000 \
        -e UIN=<QQ> \
        -e PASSWORD=<密码> \
        -e WS_URL="ws://<IP>:<端口>/ws/cq/" \
        -v $(pwd)/device:/data/device \
        lz1998/gmc
     ```

   
   ## 指令说明
   
   ### 管理员指令
   
   1. 执行<指令>
   
      举例：执行list
   
      说明：直接在服务器中执行指令
   
   2. 设置指令<消息>###<对应指令>
   
      举例：设置指令 在线玩家 ### list
   
      说明：可以给普通群成员设置指令
   
   ### 群成员指令
   
   1. 刚才管理员设置的“在线玩家”
