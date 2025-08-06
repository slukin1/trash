package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class V2TIMGroupTipsElem extends V2TIMElem {
    public static final int GROUP_TIPS_TYPE_INVALID = 0;
    public static final int V2TIM_GROUP_TIPS_TYPE_CANCEL_ADMIN = 6;
    public static final int V2TIM_GROUP_TIPS_TYPE_GROUP_INFO_CHANGE = 7;
    public static final int V2TIM_GROUP_TIPS_TYPE_INVITE = 2;
    public static final int V2TIM_GROUP_TIPS_TYPE_JOIN = 1;
    public static final int V2TIM_GROUP_TIPS_TYPE_KICKED = 4;
    public static final int V2TIM_GROUP_TIPS_TYPE_MEMBER_INFO_CHANGE = 8;
    public static final int V2TIM_GROUP_TIPS_TYPE_QUIT = 3;
    public static final int V2TIM_GROUP_TIPS_TYPE_SET_ADMIN = 5;

    private String getGroupType() {
        if (getElement() == null) {
            return null;
        }
        return ((GroupTipsElement) getElement()).getGroupType();
    }

    public List<V2TIMGroupChangeInfo> getGroupChangeInfoList() {
        if (getElement() == null) {
            return null;
        }
        List<GroupInfoChangeItem> groupInfoChangeItemList = ((GroupTipsElement) getElement()).getGroupInfoChangeItemList();
        ArrayList arrayList = new ArrayList();
        for (GroupInfoChangeItem groupInfoChangeItem : groupInfoChangeItemList) {
            V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
            v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
            arrayList.add(v2TIMGroupChangeInfo);
        }
        return arrayList;
    }

    public String getGroupID() {
        if (getElement() == null) {
            return null;
        }
        return ((GroupTipsElement) getElement()).getGroupID();
    }

    public List<V2TIMGroupMemberChangeInfo> getMemberChangeInfoList() {
        if (getElement() == null) {
            return null;
        }
        List<GroupMemberInfoChangeItem> groupMemberInfoChangeItemList = ((GroupTipsElement) getElement()).getGroupMemberInfoChangeItemList();
        ArrayList arrayList = new ArrayList();
        for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : groupMemberInfoChangeItemList) {
            V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
            v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
            arrayList.add(v2TIMGroupMemberChangeInfo);
        }
        return arrayList;
    }

    public int getMemberCount() {
        if (getElement() == null) {
            return 0;
        }
        return ((GroupTipsElement) getElement()).getGroupMemberCount();
    }

    public List<V2TIMGroupMemberInfo> getMemberList() {
        GroupTipsElement groupTipsElement;
        if (getElement() == null || (groupTipsElement = (GroupTipsElement) getElement()) == null) {
            return null;
        }
        List<GroupMemberInfo> targetGroupMemberInfoList = groupTipsElement.getTargetGroupMemberInfoList();
        List<UserInfo> targetUserInfoList = groupTipsElement.getTargetUserInfoList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (GroupMemberInfo next : targetGroupMemberInfoList) {
            V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
            v2TIMGroupMemberInfo.setGroupMemberInfo(next);
            hashMap.put(next.getUserID(), v2TIMGroupMemberInfo);
        }
        for (UserInfo next2 : targetUserInfoList) {
            V2TIMGroupMemberInfo v2TIMGroupMemberInfo2 = (V2TIMGroupMemberInfo) hashMap.get(next2.getUserID());
            if (v2TIMGroupMemberInfo2 != null) {
                v2TIMGroupMemberInfo2.setUserInfo(next2);
                arrayList.add(v2TIMGroupMemberInfo2);
            }
        }
        return arrayList;
    }

    public V2TIMGroupMemberInfo getOpMember() {
        GroupTipsElement groupTipsElement;
        if (getElement() == null || (groupTipsElement = (GroupTipsElement) getElement()) == null) {
            return null;
        }
        GroupMemberInfo operatorGroupMemberInfo = groupTipsElement.getOperatorGroupMemberInfo();
        UserInfo operatorUserInfo = groupTipsElement.getOperatorUserInfo();
        V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
        v2TIMGroupMemberInfo.setGroupMemberInfo(operatorGroupMemberInfo);
        v2TIMGroupMemberInfo.setUserInfo(operatorUserInfo);
        return v2TIMGroupMemberInfo;
    }

    public int getType() {
        GroupTipsElement groupTipsElement = (GroupTipsElement) getElement();
        if (groupTipsElement == null) {
            return 0;
        }
        int groupTipsType = groupTipsElement.getGroupTipsType();
        if (groupTipsType == 1) {
            return getGroupType().equals("Private") ? 2 : 1;
        }
        if (groupTipsType == 2) {
            return 3;
        }
        if (groupTipsType == 3) {
            return 4;
        }
        if (groupTipsType == 4) {
            return 5;
        }
        if (groupTipsType == 5) {
            return 6;
        }
        if (groupTipsType == 6) {
            return 7;
        }
        if (groupTipsType == 7) {
            return 8;
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (V2TIMGroupChangeInfo next : getGroupChangeInfoList()) {
            sb2.append("sub type:");
            sb2.append(next.getType());
            sb2.append(", key:");
            sb2.append(next.getKey());
            sb2.append(", value:");
            sb2.append(next.getValue());
            sb2.append(", intValue:");
            sb2.append(next.getIntValue());
            sb2.append(", boolValue:");
            sb2.append(next.getBoolValue());
            sb2.append("\n");
        }
        StringBuilder sb3 = new StringBuilder();
        for (V2TIMGroupMemberChangeInfo next2 : getMemberChangeInfoList()) {
            sb3.append("userID:");
            sb3.append(next2.getUserID());
            sb3.append(", muteTime:");
            sb3.append(next2.getMuteTime());
            sb3.append("\n");
        }
        List<V2TIMGroupMemberInfo> memberList = getMemberList();
        StringBuilder sb4 = new StringBuilder();
        for (V2TIMGroupMemberInfo v2TIMGroupMemberInfo : memberList) {
            sb4.append(v2TIMGroupMemberInfo.toString());
            sb4.append("\n");
        }
        V2TIMGroupMemberInfo opMember = getOpMember();
        String v2TIMGroupMemberInfo2 = opMember != null ? opMember.toString() : "";
        return "V2TIMGroupTipsElem--->" + "groupID:" + getGroupID() + ", tips type:" + getType() + ", memberCount:" + getMemberCount() + "\n" + ", memberList:" + "\n" + sb4.toString() + ", groupChangedInfoList:" + "\n" + sb2.toString() + ", memberChangedInfoList:" + "\n" + sb3.toString() + ", opUser:" + v2TIMGroupMemberInfo2;
    }
}
