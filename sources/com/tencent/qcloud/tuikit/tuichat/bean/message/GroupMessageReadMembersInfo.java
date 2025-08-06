package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMGroupMessageReadMemberList;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import java.util.ArrayList;
import java.util.List;

public class GroupMessageReadMembersInfo {
    private List<GroupMemberInfo> groupMemberInfoList;
    private V2TIMGroupMessageReadMemberList readMembers;

    public List<GroupMemberInfo> getGroupMemberInfoList() {
        return this.groupMemberInfoList;
    }

    public long getNextSeq() {
        this.readMembers.getMemberInfoList();
        return this.readMembers.getNextSeq();
    }

    public boolean isFinished() {
        return this.readMembers.isFinished();
    }

    public void setReadMembers(V2TIMGroupMessageReadMemberList v2TIMGroupMessageReadMemberList) {
        this.readMembers = v2TIMGroupMessageReadMemberList;
        this.groupMemberInfoList = new ArrayList();
        for (V2TIMGroupMemberInfo covertTIMGroupMemberInfo : v2TIMGroupMessageReadMemberList.getMemberInfoList()) {
            GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
            groupMemberInfo.covertTIMGroupMemberInfo(covertTIMGroupMemberInfo);
            this.groupMemberInfoList.add(groupMemberInfo);
        }
    }
}
