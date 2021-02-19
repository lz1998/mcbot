package xin.lz1998.mcbot.plugin;


import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.lz1998.mcbot.config.BotConfig;
import xin.lz1998.mcbot.entity.Command;
import xin.lz1998.mcbot.repository.CommandRepository;
import xin.lz1998.mcbot.service.RconService;

/**
 * 管理员的功能
 * @author lz1998
 */
@Component
public class AdminPlugin extends BotPlugin {

    /**
     * 指令集（x
     */
    private CommandRepository commandRepository;

    @Autowired
    public void setCommandRepository(CommandRepository commandRepository){
        this.commandRepository = commandRepository;
    }

    /**
     * rcon 服务
     */
    private RconService rconService;

    @Autowired
    public void setRconService(RconService rconService){
        this.rconService = rconService;
    }

    /**
     * Bot 配置
     */
    private BotConfig botConfig;

    @Autowired
    public void setBotConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }


    @Override
    public int onGroupMessage(@NotNull Bot cq, OnebotEvent.GroupMessageEvent event) {
        String msg = event.getRawMessage();
        long groupId = event.getGroupId();
        long userId = event.getUserId();

        if (!botConfig.getWhiteList().contains(groupId) && botConfig.getAdmin() != userId) {
            return MESSAGE_IGNORE;
        }

        // 设置群成员的指令，如list，forge tps等
        if (msg.startsWith("设置指令")) {
            if (!"owner".equals(event.getSender().getRole()) && !"admin".equals(event.getSender().getRole())) {
                cq.sendGroupMsg(groupId, "你没有权限", false);
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

        // 群管理员直接执行指令
        if (msg.startsWith("执行")) {
            if (!"owner".equals(event.getSender().getRole().toLowerCase()) && !"admin".equals(event.getSender().getRole().toLowerCase())) {
                cq.sendGroupMsg(groupId, "你没有权限", false);
                return MESSAGE_BLOCK;
            }
            msg = msg.substring("执行".length()).trim();
            String result = rconService.run(msg);
            cq.sendGroupMsg(groupId, result, false);
        }
        return MESSAGE_IGNORE;
    }
}
