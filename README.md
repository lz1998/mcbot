# McBot使用说明

1. 配置服务器server.properties的rcon

   ```properties
   enable-rcon=true
   rcon.port=25575
   rcon.password=123asd123
   ```

2. 配置mcbot相同文件夹中的application.properties

   ```properties
   rcon.host=服务器地址
   rcon.port=25575
   rcon.password=123asd123
   ```

3. 运行Minecraft服务器

4. 运行mcbot，指令如下

   ```bash
   java -jar mcbot.jar
   ```

5. 运行酷Q

   - 方案一**(最简单)**：Windows直接运行配置好cqhttp的 [酷Q Air](http://cq.lz1998.xin/CQA.zip)

   - 方案二：自己给酷Q配置cqhttp

     1. 下载cqhttp插件 https://github.com/richardchien/coolq-http-api/releases

     2. 创建文件`酷Q Air\data\app\io.github.richardchien.coolqhttpapi\config.ini`

        ```ini
        [general]
        use_http=false
        use_ws_reverse=true
        ws_reverse_url=ws://127.0.0.1:8081/ws/cq/
        ws_reverse_use_universal_client=true
        enable_heartbeat=true
        heartbeat_interval=60000
        ```

   - 方案三：Linux安装docker后使用docker运行

     ```bash
     docker run -d --name cq01 \
     -v $(pwd)/coolq:/home/user/coolq \
     --net=host \
     -e VNC_PASSWD=你的VNC密码(不超过8位) \
     -e COOLQ_URL=http://dlsec.cqp.me/cqa-tuling \
     -e COOLQ_ACCOUNT=你的机器人QQ号 \
     -e CQHTTP_USE_HTTP=false \
     -e CQHTTP_USE_WS_REVERSE=true \
     -e CQHTTP_WS_REVERSE_URL=ws://127.0.0.1:8081/ws/cq/ \
     -e CQHTTP_WS_REVERSE_UNIVERSAL_CLIENT=true \
     -e CQHTTP_ENABLE_HEARTBEAT=true \
     -e CQHTTP_HEARTBEAT_INTERVAL=60000 \
     richardchien/cqhttp
     ```

     