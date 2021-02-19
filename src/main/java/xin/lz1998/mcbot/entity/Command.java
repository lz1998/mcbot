package xin.lz1998.mcbot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lz1998
 */
@Data
@Entity
@Table
public class Command {

    /**
     * 群内消息
     */
    @Id
    private String msg;


    /**
     * mc中的指令
     */
    @Column
    private String command;
}
