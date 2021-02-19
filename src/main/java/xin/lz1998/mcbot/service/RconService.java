package xin.lz1998.mcbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xin.lz1998.mcbot.config.RconConfig;
import xin.lz1998.mcbot.rcon.Rcon;

/**
 * @author lz1998
 */
@Service
public class RconService {
    /**
     * rcon 配置
     */
    private RconConfig rconConfig;

    @Autowired
    public void setRconConfig(RconConfig rconConfig) {
        this.rconConfig = rconConfig;
    }

    public String run(String command) {
        try {
            Rcon rcon = new Rcon(rconConfig.getHost(), rconConfig.getPort(), rconConfig.getPassword().getBytes());
            String result = rcon.command(command).trim();
            rcon.disconnect();
            if (StringUtils.isEmpty(result)) {
                return "已执行，这条指令没有返回结果";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "执行错误";
        }
    }
}
