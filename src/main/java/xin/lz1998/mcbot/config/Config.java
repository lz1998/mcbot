package xin.lz1998.mcbot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rcon")
public class Config {
    private String host = "";
    private Integer port = 0;
    private String password = "";

}
