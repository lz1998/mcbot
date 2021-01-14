package xin.lz1998.mcbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import xin.lz1998.mcbot.entity.Command;
import xin.lz1998.mcbot.repository.CommandRepository;
import xin.lz1998.mcbot.service.RconService;

/**
 * 普通群成员可以使用管理员设置的指令
 */
@Component
public class PlayerPlugin extends BotPlugin {

    @Autowired
    CommandRepository commandRepository;

    @Autowired
    RconService rconService;

    @Override
    public int onGroupMessage(Bot cq, OnebotEvent.GroupMessageEvent event) {
        String msg = event.getRawMessage();
        Long groupId = event.getGroupId();

        Command command = commandRepository.findCommandByMsg(msg);
        if (command == null || StringUtils.isEmpty(command.getCommand())) {
            return MESSAGE_IGNORE;
        } else {
            String result = rconService.run(command.getCommand());
            cq.sendGroupMsg(groupId, result, false);
            return MESSAGE_BLOCK;
        }
    }
}
