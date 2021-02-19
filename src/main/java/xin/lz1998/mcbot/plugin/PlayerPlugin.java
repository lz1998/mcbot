package xin.lz1998.mcbot.plugin;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import xin.lz1998.mcbot.entity.Command;
import xin.lz1998.mcbot.repository.CommandRepository;
import xin.lz1998.mcbot.service.RconService;

/**
 * @author lz1998
 * 普通群成员可以使用管理员设置的指令
 */
@Component
public class PlayerPlugin extends BotPlugin {

    /**
     * 指令集（x
     */
   private CommandRepository commandRepository;

    @Autowired
    public void setCommandRepository(CommandRepository commandRepository){
        this.commandRepository = commandRepository;
    }

    /**
     * rcon服务
     */
    private RconService rconService;

    @Autowired
    public void setRconService(RconService rconService){
        this.rconService = rconService;
    }

    @Override
    public int onGroupMessage(@NotNull Bot cq, OnebotEvent.GroupMessageEvent event) {
        String msg = event.getRawMessage();
        long groupId = event.getGroupId();

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
