package xin.lz1998.mcbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.lz1998.mcbot.entity.Command;

/**
 * @author lz1998
 */
public interface CommandRepository extends JpaRepository<Command,String> {
    /**
     * 根据消息查找指令
     * @param msg 消息内容
     * @return 消息对应指令
     */
    Command findCommandByMsg(String msg);
}
