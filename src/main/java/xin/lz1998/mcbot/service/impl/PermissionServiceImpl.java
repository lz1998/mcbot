package xin.lz1998.mcbot.service.impl;

import net.lz1998.cq.retdata.GroupMemberInfoData;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.stereotype.Service;
import xin.lz1998.mcbot.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public boolean isOwnerOrAdmin(CoolQ coolQ, Long groupId, Long userId) {
        GroupMemberInfoData memberInfo = coolQ.getGroupMemberInfo(groupId, userId, true).getData();
        String role=memberInfo.getRole();
        return (role.equals("admin") || role.equals("owner"));
    }
}
