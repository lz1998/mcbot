package xin.lz1998.mcbot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xin.lz1998.mcbot.config.Config;
import xin.lz1998.mcbot.service.RconService;

@SpringBootTest
class McbotApplicationTests {

    @Autowired
    Config config;

    @Autowired
    RconService rconService;
    @Test
    void contextLoads() {
        System.out.println(rconService.run("list"));
    }

}
