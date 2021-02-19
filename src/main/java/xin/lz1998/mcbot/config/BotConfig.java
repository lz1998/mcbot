package xin.lz1998.mcbot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Create by Intellij IDEA
 *
 * @author NKDark
 * @date create in 2021/2/19 21:24
 * @description Bot设定
 */

@Data
@ConfigurationProperties(prefix = "bot")
public class BotConfig {
    private Long admin;
    private List<Long> whiteList;
}
