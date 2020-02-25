package xin.lz1998.mcbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xin.lz1998.mcbot.config.Config;

@SpringBootApplication
public class McbotApplication {

    public static void main(String[] args) {
        Config.init();
        SpringApplication.run(McbotApplication.class, args);
    }

}
