package xin.lz1998.mcbot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Command {
    @Id
    private String msg; // 群内消息
    @Column
    private String command; // mc中的指令
}
