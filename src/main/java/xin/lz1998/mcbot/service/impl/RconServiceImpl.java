package xin.lz1998.mcbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.lz1998.mcbot.config.Config;
import xin.lz1998.mcbot.rcon.Rcon;
import xin.lz1998.mcbot.rcon.ex.AuthenticationException;
import xin.lz1998.mcbot.service.RconService;

import java.io.IOException;

@Service
public class RconServiceImpl implements RconService {

    @Autowired
    Config config;
    @Override
    public String run(String command){
        String result;
        try {
            Rcon rcon = new Rcon(config.getHost(), config.getPort(), config.getPassword().getBytes());
            result = rcon.command(command).trim();
            rcon.disconnect();
            if(result==null || result.equals("")){
                result="已执行，这条指令没有返回结果";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result="执行错误";
        }
        return result;
    }
}
