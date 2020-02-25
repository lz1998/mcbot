package xin.lz1998.mcbot.plugin;

import net.lz1998.cq.event.message.CQGroupMessageEvent;
import net.lz1998.cq.retdata.ApiData;
import net.lz1998.cq.retdata.GroupMemberInfoData;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.lz1998.mcbot.entity.Command;
import xin.lz1998.mcbot.rcon.ex.AuthenticationException;
import xin.lz1998.mcbot.repository.CommandRepository;
import xin.lz1998.mcbot.service.PermissionService;
import xin.lz1998.mcbot.service.RconService;

import java.io.IOException;

/**
 * 管理员的功能
 */
@Component
public class AdminPlugin extends CQPlugin {
    @Autowired
    CommandRepository commandRepository;

    @Autowired
    RconService rconService;

    @Autowired
    PermissionService permissionService;

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String msg = event.getMessage();
        Long groupId = event.getGroupId();
        Long userId = event.getUserId();

        // 设置群成员的指令，如list，forge tps等
        if (msg.startsWith("设置指令")) {
            if(!permissionService.isOwnerOrAdmin(cq,groupId,userId)){
                cq.sendGroupMsg(groupId,"你没有权限",false);
                return MESSAGE_BLOCK;
            }
            msg = msg.substring("设置指令".length()).trim();

            // 分割
            String[] split = msg.split("###");
            if (split.length < 2) {
                cq.sendGroupMsg(groupId, "格式错误，格式是：设置指令{群内指令}###{对应mc指令}", false);
                return MESSAGE_BLOCK;
            }

            // 存入数据库
            Command command = new Command();
            command.setMsg(split[0].trim());
            command.setCommand(split[1].trim());
            commandRepository.save(command);

            cq.sendGroupMsg(groupId, "设置成功\n发送 " + command.getMsg() + " 执行 " + command.getCommand(), false);
            return MESSAGE_BLOCK;
        }

        // 管理员直接执行指令
        if (msg.startsWith("执行")) {
            if(!permissionService.isOwnerOrAdmin(cq,groupId,userId)){
                cq.sendGroupMsg(groupId,"你没有权限",false);
                return MESSAGE_BLOCK;
            }
            msg = msg.substring("执行".length()).trim();
            String result = rconService.run(msg);
            cq.sendGroupMsg(groupId, result, false);
        }
        return MESSAGE_IGNORE;
    }
}
