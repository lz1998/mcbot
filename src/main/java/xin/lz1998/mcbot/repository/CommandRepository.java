package xin.lz1998.mcbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.lz1998.mcbot.entity.Command;

public interface CommandRepository extends JpaRepository<Command,String> {
    Command findCommandByMsg(String msg);
}
