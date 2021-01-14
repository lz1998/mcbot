package xin.lz1998.mcbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xin.lz1998.mcbot.config.Config;
import xin.lz1998.mcbot.rcon.Rcon;

@Service
public class RconService {

    @Autowired
    Config config;

    public String run(String command) {
        try {
            Rcon rcon = new Rcon(config.getHost(), config.getPort(), config.getPassword().getBytes());
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
