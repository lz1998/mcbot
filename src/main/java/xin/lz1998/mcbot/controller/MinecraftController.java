package xin.lz1998.mcbot.controller;

import net.lz1998.cq.CQGlobal;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinecraftController {
    Long groupId=123L;

    // TODO 如果需要玩家入群播报，需要写mod或者插件，当玩家进入时，发送请求http://127.0.0.1:8081/playerJoinGame?name=<玩家名字>

    @RequestMapping("/playerJoinGame")
    public Object playerJoinGame(String name){

        CoolQ cq = CQGlobal.robots.values().iterator().next(); // 获取唯一机器人
        // CoolQ cq = CQGlobal.robots.get(机器人QQ); // TODO 推荐这样写，获取指定机器人
        cq.sendGroupMsg(groupId,name+" 进入了游戏",false); // 用机器人发送群消息
        return "success";
    }

}
