package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class GroupNoticeItemEntity implements Serializable {
    private Long createTime;
    private String groupId;

    /* renamed from: id  reason: collision with root package name */
    private int f19876id;
    private String notification;
    private String recommend;
    private Long recommendTime;
    private GroupNoticeUserInfoEntity userInfo;

    public GroupNoticeItemEntity() {
        this(0, (Long) null, (Long) null, (String) null, (String) null, (String) null, (GroupNoticeUserInfoEntity) null, 127, (r) null);
    }

    public GroupNoticeItemEntity(int i11, Long l11, Long l12, String str, String str2, String str3, GroupNoticeUserInfoEntity groupNoticeUserInfoEntity) {
        this.f19876id = i11;
        this.createTime = l11;
        this.recommendTime = l12;
        this.recommend = str;
        this.notification = str2;
        this.groupId = str3;
        this.userInfo = groupNoticeUserInfoEntity;
    }

    public static /* synthetic */ GroupNoticeItemEntity copy$default(GroupNoticeItemEntity groupNoticeItemEntity, int i11, Long l11, Long l12, String str, String str2, String str3, GroupNoticeUserInfoEntity groupNoticeUserInfoEntity, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = groupNoticeItemEntity.f19876id;
        }
        if ((i12 & 2) != 0) {
            l11 = groupNoticeItemEntity.createTime;
        }
        Long l13 = l11;
        if ((i12 & 4) != 0) {
            l12 = groupNoticeItemEntity.recommendTime;
        }
        Long l14 = l12;
        if ((i12 & 8) != 0) {
            str = groupNoticeItemEntity.recommend;
        }
        String str4 = str;
        if ((i12 & 16) != 0) {
            str2 = groupNoticeItemEntity.notification;
        }
        String str5 = str2;
        if ((i12 & 32) != 0) {
            str3 = groupNoticeItemEntity.groupId;
        }
        String str6 = str3;
        if ((i12 & 64) != 0) {
            groupNoticeUserInfoEntity = groupNoticeItemEntity.userInfo;
        }
        return groupNoticeItemEntity.copy(i11, l13, l14, str4, str5, str6, groupNoticeUserInfoEntity);
    }

    public final int component1() {
        return this.f19876id;
    }

    public final Long component2() {
        return this.createTime;
    }

    public final Long component3() {
        return this.recommendTime;
    }

    public final String component4() {
        return this.recommend;
    }

    public final String component5() {
        return this.notification;
    }

    public final String component6() {
        return this.groupId;
    }

    public final GroupNoticeUserInfoEntity component7() {
        return this.userInfo;
    }

    public final GroupNoticeItemEntity copy(int i11, Long l11, Long l12, String str, String str2, String str3, GroupNoticeUserInfoEntity groupNoticeUserInfoEntity) {
        return new GroupNoticeItemEntity(i11, l11, l12, str, str2, str3, groupNoticeUserInfoEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupNoticeItemEntity)) {
            return false;
        }
        GroupNoticeItemEntity groupNoticeItemEntity = (GroupNoticeItemEntity) obj;
        return this.f19876id == groupNoticeItemEntity.f19876id && x.b(this.createTime, groupNoticeItemEntity.createTime) && x.b(this.recommendTime, groupNoticeItemEntity.recommendTime) && x.b(this.recommend, groupNoticeItemEntity.recommend) && x.b(this.notification, groupNoticeItemEntity.notification) && x.b(this.groupId, groupNoticeItemEntity.groupId) && x.b(this.userInfo, groupNoticeItemEntity.userInfo);
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.f19876id;
    }

    public final String getNotification() {
        return this.notification;
    }

    public final String getRecommend() {
        return this.recommend;
    }

    public final Long getRecommendTime() {
        return this.recommendTime;
    }

    public final GroupNoticeUserInfoEntity getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        int i11 = this.f19876id * 31;
        Long l11 = this.createTime;
        int i12 = 0;
        int hashCode = (i11 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.recommendTime;
        int hashCode2 = (hashCode + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str = this.recommend;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.notification;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        GroupNoticeUserInfoEntity groupNoticeUserInfoEntity = this.userInfo;
        if (groupNoticeUserInfoEntity != null) {
            i12 = groupNoticeUserInfoEntity.hashCode();
        }
        return hashCode5 + i12;
    }

    public final void setCreateTime(Long l11) {
        this.createTime = l11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setId(int i11) {
        this.f19876id = i11;
    }

    public final void setNotification(String str) {
        this.notification = str;
    }

    public final void setRecommend(String str) {
        this.recommend = str;
    }

    public final void setRecommendTime(Long l11) {
        this.recommendTime = l11;
    }

    public final void setUserInfo(GroupNoticeUserInfoEntity groupNoticeUserInfoEntity) {
        this.userInfo = groupNoticeUserInfoEntity;
    }

    public String toString() {
        return "GroupNoticeItemEntity(id=" + this.f19876id + ", createTime=" + this.createTime + ", recommendTime=" + this.recommendTime + ", recommend=" + this.recommend + ", notification=" + this.notification + ", groupId=" + this.groupId + ", userInfo=" + this.userInfo + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GroupNoticeItemEntity(int r6, java.lang.Long r7, java.lang.Long r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, com.hbg.module.huobi.im.group.bean.GroupNoticeUserInfoEntity r12, int r13, kotlin.jvm.internal.r r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0005
            r6 = 0
        L_0x0005:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x000f
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
        L_0x000f:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0018
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
        L_0x0018:
            r0 = r8
            r7 = r13 & 8
            r8 = 0
            if (r7 == 0) goto L_0x0020
            r1 = r8
            goto L_0x0021
        L_0x0020:
            r1 = r9
        L_0x0021:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0027
            r2 = r8
            goto L_0x0028
        L_0x0027:
            r2 = r10
        L_0x0028:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x002e
            r3 = r8
            goto L_0x002f
        L_0x002e:
            r3 = r11
        L_0x002f:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0035
            r4 = r8
            goto L_0x0036
        L_0x0035:
            r4 = r12
        L_0x0036:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity.<init>(int, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, com.hbg.module.huobi.im.group.bean.GroupNoticeUserInfoEntity, int, kotlin.jvm.internal.r):void");
    }
}
