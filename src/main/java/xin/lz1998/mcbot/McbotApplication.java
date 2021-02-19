package xin.lz1998.mcbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author lz1998
 */
@ConfigurationPropertiesScan
@SpringBootApplication
public class McbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(McbotApplication.class, args);
    }

}
