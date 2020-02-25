package xin.lz1998.mcbot.plugin;

import net.lz1998.cq.event.message.CQGroupMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.lz1998.mcbot.entity.Command;
import xin.lz1998.mcbot.repository.CommandRepository;
import xin.lz1998.mcbot.service.RconService;

/**
 * 普通群成员可以使用管理员设置的指令
 */
@Component
public class PlayerPlugin extends CQPlugin {

    @Autowired
    CommandRepository commandRepository;

    @Autowired
    RconService rconService;

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String msg = event.getMessage();
        Long groupId = event.getGroupId();

        Command command = commandRepository.findCommandByMsg(msg);
        if (command == null || command.equals("") || command.equals("null")) {
            return MESSAGE_IGNORE;
        } else {
            String result = rconService.run(command.getCommand());
            cq.sendGroupMsg(groupId, result, false);
            return MESSAGE_BLOCK;
        }
    }
}
