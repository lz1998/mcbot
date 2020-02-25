package xin.lz1998.mcbot.service;

import net.lz1998.cq.robot.CoolQ;

public interface PermissionService {
    boolean isOwnerOrAdmin(CoolQ coolQ,Long groupId,Long userId);
}
