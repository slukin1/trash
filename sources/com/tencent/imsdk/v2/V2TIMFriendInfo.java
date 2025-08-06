package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2TIMFriendInfo implements Serializable {
    private static final String FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_SNS_Custom_";
    private static final String FRIEND_PROFILE_TYPE_KEY_REMARK = "Tag_SNS_IM_Remark";
    public static final int V2TIM_FRIEND_TYPE_BOTH = 2;
    public static final int V2TIM_FRIEND_TYPE_SINGLE = 1;
    private FriendInfo friendInfo = new FriendInfo();
    private HashMap<String, Object> modifyFriendProfileHashMap = new HashMap<>();

    public long getFriendAddTime() {
        return this.friendInfo.getAddTime();
    }

    public HashMap<String, byte[]> getFriendCustomInfo() {
        return this.friendInfo.getFriendCustomInfo();
    }

    public List<String> getFriendGroups() {
        return this.friendInfo.getFriendGroups();
    }

    public String getFriendRemark() {
        return this.friendInfo.getRemark();
    }

    public HashMap<String, Object> getModifyFriendInfo() {
        return this.modifyFriendProfileHashMap;
    }

    public String getUserID() {
        return this.friendInfo.getUserInfo().getUserID();
    }

    public V2TIMUserFullInfo getUserProfile() {
        UserInfo userInfo = this.friendInfo.getUserInfo();
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        v2TIMUserFullInfo.setUserInfo(userInfo);
        return v2TIMUserFullInfo;
    }

    public void setFriendCustomInfo(HashMap<String, byte[]> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            if (this.modifyFriendProfileHashMap == null) {
                this.modifyFriendProfileHashMap = new HashMap<>();
            }
            if (hashMap.entrySet() != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    if (((String) next.getKey()).contains(FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX)) {
                        this.modifyFriendProfileHashMap.put(next.getKey(), new String((byte[]) next.getValue()));
                    } else {
                        HashMap<String, Object> hashMap2 = this.modifyFriendProfileHashMap;
                        hashMap2.put(FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX + ((String) next.getKey()), new String((byte[]) next.getValue()));
                    }
                }
            }
        }
    }

    public void setFriendInfo(FriendInfo friendInfo2) {
        this.friendInfo = friendInfo2;
    }

    public void setFriendRemark(String str) {
        this.friendInfo.setRemark(str);
        this.modifyFriendProfileHashMap.put(FRIEND_PROFILE_TYPE_KEY_REMARK, str);
    }

    public void setUserID(String str) {
        this.friendInfo.getUserInfo().setUserID(str);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("V2TIMFriendInfo--->");
        HashMap<String, byte[]> friendCustomInfo = getFriendCustomInfo();
        StringBuilder sb3 = new StringBuilder();
        if (friendCustomInfo != null) {
            sb3.append("\n");
            for (Map.Entry next : friendCustomInfo.entrySet()) {
                sb3.append(" |key:" + ((String) next.getKey()) + ", value:" + new String((byte[]) next.getValue()));
                sb3.append("\n");
            }
        }
        sb2.append("userID:");
        sb2.append(getUserID());
        sb2.append(", remark:");
        sb2.append(getFriendRemark());
        sb2.append(", groupNames:");
        sb2.append(getFriendGroups());
        sb2.append(", friendCustomInfo:");
        sb2.append(sb3.toString());
        sb2.append(", V2TIMUserFullInfo:");
        sb2.append(getUserProfile() == null ? "" : getUserProfile().toString());
        return sb2.toString();
    }
}
