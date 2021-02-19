package xin.lz1998.mcbot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lz1998
 */
@Data
@ConfigurationProperties(prefix = "rcon")
public class RconConfig {
    private String host = "";
    private Integer port = 0;
    private String password = "";
}
