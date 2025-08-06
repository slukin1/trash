package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class GroupNoticeUserInfoEntity implements Serializable {
    private String avatar;
    private String nickname;

    public GroupNoticeUserInfoEntity() {
        this((String) null, (String) null, 3, (r) null);
    }

    public GroupNoticeUserInfoEntity(String str, String str2) {
        this.nickname = str;
        this.avatar = str2;
    }

    public static /* synthetic */ GroupNoticeUserInfoEntity copy$default(GroupNoticeUserInfoEntity groupNoticeUserInfoEntity, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = groupNoticeUserInfoEntity.nickname;
        }
        if ((i11 & 2) != 0) {
            str2 = groupNoticeUserInfoEntity.avatar;
        }
        return groupNoticeUserInfoEntity.copy(str, str2);
    }

    public final String component1() {
        return this.nickname;
    }

    public final String component2() {
        return this.avatar;
    }

    public final GroupNoticeUserInfoEntity copy(String str, String str2) {
        return new GroupNoticeUserInfoEntity(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupNoticeUserInfoEntity)) {
            return false;
        }
        GroupNoticeUserInfoEntity groupNoticeUserInfoEntity = (GroupNoticeUserInfoEntity) obj;
        return x.b(this.nickname, groupNoticeUserInfoEntity.nickname) && x.b(this.avatar, groupNoticeUserInfoEntity.avatar);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        String str = this.nickname;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.avatar;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public String toString() {
        return "GroupNoticeUserInfoEntity(nickname=" + this.nickname + ", avatar=" + this.avatar + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GroupNoticeUserInfoEntity(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
