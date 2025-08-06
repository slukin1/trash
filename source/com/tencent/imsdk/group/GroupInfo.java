package com.tencent.imsdk.group;

import android.text.TextUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class GroupInfo implements Serializable {
    public static int GROUP_ADD_OPTION_ALLOW_ANY = 3;
    public static int GROUP_ADD_OPTION_FORBID_ANY = 1;
    public static int GROUP_ADD_OPTION_NEED_AUTHENTICATION = 2;
    public static long GROUP_INFO_MODIFY_FLAG_APPLY_APPROVE_OPTION = 16;
    public static long GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO = 512;
    public static long GROUP_INFO_MODIFY_FLAG_FACE_URL = 8;
    public static long GROUP_INFO_MODIFY_FLAG_GROUP_SEARCHABLE = 128;
    public static long GROUP_INFO_MODIFY_FLAG_INTRODUCTION = 4;
    public static long GROUP_INFO_MODIFY_FLAG_INVITE_APPROVE_OPTION = 4096;
    public static long GROUP_INFO_MODIFY_FLAG_MAX_MEMBER_NUM = 32;
    public static long GROUP_INFO_MODIFY_FLAG_MEMBER_VISIBLE = 64;
    public static long GROUP_INFO_MODIFY_FLAG_NAME = 1;
    public static long GROUP_INFO_MODIFY_FLAG_NONE = 0;
    public static long GROUP_INFO_MODIFY_FLAG_NOTIFICATION = 2;
    public static long GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL = 256;
    public static long TOPIC_INFO_MODIFY_FLAG_CUSTOM_STRING = 2048;
    private int applyApproveOption;
    private String communityID;
    private long createTime;
    private Map<String, byte[]> customInfo = new HashMap();
    private String customString;
    private String faceUrl;
    private String groupID;
    private long groupInfoTimestamp;
    private byte[] groupNameBytes;
    private GroupMemberInfo groupSelfInfo = new GroupMemberInfo();
    private String groupType;
    private byte[] introductionBytes;
    private int inviteApproveOption;
    private boolean isAllShutUp;
    private boolean isGroupMemberVisible;
    private boolean isGroupSearchable;
    private long lastMessageTimestamp;
    private long memberCount;
    private long memberMaxCount;
    private long memberOnlineCount;
    private byte[] notificationBytes;
    private String ownerUserID;
    private boolean supportTopic;

    public int getApplyApproveOption() {
        return this.applyApproveOption;
    }

    public String getCommunityID() {
        return this.communityID;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    public String getCustomString() {
        return this.customString;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public long getGroupInfoTimestamp() {
        return this.groupInfoTimestamp;
    }

    public String getGroupName() {
        byte[] bArr = this.groupNameBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    public GroupMemberInfo getGroupSelfInfo() {
        return this.groupSelfInfo;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getIntroduction() {
        byte[] bArr = this.introductionBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    public int getInviteApproveOption() {
        return this.inviteApproveOption;
    }

    public long getLastMessageTimestamp() {
        return this.lastMessageTimestamp;
    }

    public long getMemberCount() {
        return this.memberCount;
    }

    public long getMemberMaxCount() {
        return this.memberMaxCount;
    }

    public long getMemberOnlineCount() {
        return this.memberOnlineCount;
    }

    public String getNotification() {
        byte[] bArr = this.notificationBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    public String getOwnerUserID() {
        return this.ownerUserID;
    }

    public boolean isAllShutUp() {
        return this.isAllShutUp;
    }

    public boolean isGroupMemberVisible() {
        return this.isGroupMemberVisible;
    }

    public boolean isGroupSearchable() {
        return this.isGroupSearchable;
    }

    public boolean isSupportTopic() {
        return this.supportTopic;
    }

    public void setAllShutUp(boolean z11) {
        this.isAllShutUp = z11;
    }

    public void setApplyApproveOption(int i11) {
        this.applyApproveOption = i11;
    }

    public void setCommunityID(String str) {
        this.communityID = str;
    }

    public void setCreateTime(long j11) {
        this.createTime = j11;
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        this.customInfo = map;
    }

    public void setCustomString(String str) {
        this.customString = str;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setGroupInfoTimestamp(long j11) {
        this.groupInfoTimestamp = j11;
    }

    public void setGroupMemberVisible(boolean z11) {
        this.isGroupMemberVisible = z11;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.groupNameBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setGroupSearchable(boolean z11) {
        this.isGroupSearchable = z11;
    }

    public void setGroupSelfInfo(GroupMemberInfo groupMemberInfo) {
        this.groupSelfInfo = groupMemberInfo;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setIntroduction(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.introductionBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setInviteApproveOption(int i11) {
        this.inviteApproveOption = i11;
    }

    public void setLastMessageTimestamp(long j11) {
        this.lastMessageTimestamp = j11;
    }

    public void setMemberCount(long j11) {
        this.memberCount = j11;
    }

    public void setMemberMaxCount(long j11) {
        this.memberMaxCount = j11;
    }

    public void setMemberOnlineCount(long j11) {
        this.memberOnlineCount = j11;
    }

    public void setNotification(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.notificationBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setOwnerUserID(String str) {
        this.ownerUserID = str;
    }

    public void setSupportTopic(boolean z11) {
        this.supportTopic = z11;
    }
}
