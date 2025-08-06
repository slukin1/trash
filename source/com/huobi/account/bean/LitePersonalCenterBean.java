package com.huobi.account.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LitePersonalCenterBean implements Serializable {
    @SerializedName("current_version")
    public String currentVersion;
    @SerializedName("is_login")
    public boolean isLogin;
    @SerializedName("is_update")
    public boolean isUpdate;
    @SerializedName("jumpChannel")
    public String jumpChannel;
    @SerializedName("subTag")
    public String subTag;
    @SerializedName("uid")
    public String uid;
    @SerializedName("user_name")
    public String userName;

    public boolean canEqual(Object obj) {
        return obj instanceof LitePersonalCenterBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LitePersonalCenterBean)) {
            return false;
        }
        LitePersonalCenterBean litePersonalCenterBean = (LitePersonalCenterBean) obj;
        if (!litePersonalCenterBean.canEqual(this)) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = litePersonalCenterBean.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = litePersonalCenterBean.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (isLogin() != litePersonalCenterBean.isLogin() || isUpdate() != litePersonalCenterBean.isUpdate()) {
            return false;
        }
        String currentVersion2 = getCurrentVersion();
        String currentVersion3 = litePersonalCenterBean.getCurrentVersion();
        if (currentVersion2 != null ? !currentVersion2.equals(currentVersion3) : currentVersion3 != null) {
            return false;
        }
        String jumpChannel2 = getJumpChannel();
        String jumpChannel3 = litePersonalCenterBean.getJumpChannel();
        if (jumpChannel2 != null ? !jumpChannel2.equals(jumpChannel3) : jumpChannel3 != null) {
            return false;
        }
        String subTag2 = getSubTag();
        String subTag3 = litePersonalCenterBean.getSubTag();
        return subTag2 != null ? subTag2.equals(subTag3) : subTag3 == null;
    }

    public String getCurrentVersion() {
        return this.currentVersion;
    }

    public String getJumpChannel() {
        return this.jumpChannel;
    }

    public String getSubTag() {
        return this.subTag;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String uid2 = getUid();
        int i11 = 43;
        int hashCode = uid2 == null ? 43 : uid2.hashCode();
        String userName2 = getUserName();
        int i12 = 79;
        int hashCode2 = (((((hashCode + 59) * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + (isLogin() ? 79 : 97)) * 59;
        if (!isUpdate()) {
            i12 = 97;
        }
        String currentVersion2 = getCurrentVersion();
        int hashCode3 = ((hashCode2 + i12) * 59) + (currentVersion2 == null ? 43 : currentVersion2.hashCode());
        String jumpChannel2 = getJumpChannel();
        int hashCode4 = (hashCode3 * 59) + (jumpChannel2 == null ? 43 : jumpChannel2.hashCode());
        String subTag2 = getSubTag();
        int i13 = hashCode4 * 59;
        if (subTag2 != null) {
            i11 = subTag2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public boolean isUpdate() {
        return this.isUpdate;
    }

    public void setCurrentVersion(String str) {
        this.currentVersion = str;
    }

    public void setJumpChannel(String str) {
        this.jumpChannel = str;
    }

    public void setLogin(boolean z11) {
        this.isLogin = z11;
    }

    public void setSubTag(String str) {
        this.subTag = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUpdate(boolean z11) {
        this.isUpdate = z11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "LitePersonalCenterBean(uid=" + getUid() + ", userName=" + getUserName() + ", isLogin=" + isLogin() + ", isUpdate=" + isUpdate() + ", currentVersion=" + getCurrentVersion() + ", jumpChannel=" + getJumpChannel() + ", subTag=" + getSubTag() + ")";
    }
}
