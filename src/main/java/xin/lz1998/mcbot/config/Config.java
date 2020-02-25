package xin.lz1998.mcbot.config;


import lombok.Data;
import net.lz1998.cq.CQGlobal;
import net.lz1998.cq.EnableCQ;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import xin.lz1998.mcbot.plugin.AdminPlugin;
import xin.lz1998.mcbot.plugin.PlayerPlugin;

@Data
@ConfigurationProperties(prefix = "rcon")
@EnableCQ
public class Config {
    private String host = "";
    private Integer port = 0;
    private String password = "";
    public static void init(){
        CQGlobal.pluginList.add(AdminPlugin.class);
        CQGlobal.pluginList.add(PlayerPlugin.class);

    }
}
