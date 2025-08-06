package com.hbg.module.huobi.im.group.ui.active;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.x;

public final class RewardsAnim implements Serializable, Cloneable {
    private ArrayList<String> accounts;
    @SerializedName(alternate = {"avatar"}, value = "avator")
    private String avatar;
    private String gifUrl;
    private String giftId;
    private String giftName;
    private int giftNum;
    private boolean isSelfReward;
    private String nickname;
    private String pngUrl;
    private Integer type;

    public RewardsAnim(String str, String str2, String str3, String str4, int i11, String str5, String str6, Integer num, ArrayList<String> arrayList, boolean z11) {
        this.avatar = str;
        this.nickname = str2;
        this.giftId = str3;
        this.giftName = str4;
        this.giftNum = i11;
        this.pngUrl = str5;
        this.gifUrl = str6;
        this.type = num;
        this.accounts = arrayList;
        this.isSelfReward = z11;
    }

    public static /* synthetic */ RewardsAnim copy$default(RewardsAnim rewardsAnim, String str, String str2, String str3, String str4, int i11, String str5, String str6, Integer num, ArrayList arrayList, boolean z11, int i12, Object obj) {
        RewardsAnim rewardsAnim2 = rewardsAnim;
        int i13 = i12;
        return rewardsAnim.copy((i13 & 1) != 0 ? rewardsAnim2.avatar : str, (i13 & 2) != 0 ? rewardsAnim2.nickname : str2, (i13 & 4) != 0 ? rewardsAnim2.giftId : str3, (i13 & 8) != 0 ? rewardsAnim2.giftName : str4, (i13 & 16) != 0 ? rewardsAnim2.giftNum : i11, (i13 & 32) != 0 ? rewardsAnim2.pngUrl : str5, (i13 & 64) != 0 ? rewardsAnim2.gifUrl : str6, (i13 & 128) != 0 ? rewardsAnim2.type : num, (i13 & 256) != 0 ? rewardsAnim2.accounts : arrayList, (i13 & 512) != 0 ? rewardsAnim2.isSelfReward : z11);
    }

    public Object clone() {
        return super.clone();
    }

    public final String component1() {
        return this.avatar;
    }

    public final boolean component10() {
        return this.isSelfReward;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.giftId;
    }

    public final String component4() {
        return this.giftName;
    }

    public final int component5() {
        return this.giftNum;
    }

    public final String component6() {
        return this.pngUrl;
    }

    public final String component7() {
        return this.gifUrl;
    }

    public final Integer component8() {
        return this.type;
    }

    public final ArrayList<String> component9() {
        return this.accounts;
    }

    public final RewardsAnim copy(String str, String str2, String str3, String str4, int i11, String str5, String str6, Integer num, ArrayList<String> arrayList, boolean z11) {
        return new RewardsAnim(str, str2, str3, str4, i11, str5, str6, num, arrayList, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardsAnim)) {
            return false;
        }
        RewardsAnim rewardsAnim = (RewardsAnim) obj;
        return x.b(this.avatar, rewardsAnim.avatar) && x.b(this.nickname, rewardsAnim.nickname) && x.b(this.giftId, rewardsAnim.giftId) && x.b(this.giftName, rewardsAnim.giftName) && this.giftNum == rewardsAnim.giftNum && x.b(this.pngUrl, rewardsAnim.pngUrl) && x.b(this.gifUrl, rewardsAnim.gifUrl) && x.b(this.type, rewardsAnim.type) && x.b(this.accounts, rewardsAnim.accounts) && this.isSelfReward == rewardsAnim.isSelfReward;
    }

    public final ArrayList<String> getAccounts() {
        return this.accounts;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getGifUrl() {
        return this.gifUrl;
    }

    public final String getGiftId() {
        return this.giftId;
    }

    public final String getGiftName() {
        return this.giftName;
    }

    public final int getGiftNum() {
        return this.giftNum;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPngUrl() {
        return this.pngUrl;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.avatar;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nickname;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.giftId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.giftName;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.giftNum) * 31;
        String str5 = this.pngUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.gifUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.type;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        ArrayList<String> arrayList = this.accounts;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        }
        int i12 = (hashCode7 + i11) * 31;
        boolean z11 = this.isSelfReward;
        if (z11) {
            z11 = true;
        }
        return i12 + (z11 ? 1 : 0);
    }

    public final boolean isSelfReward() {
        return this.isSelfReward;
    }

    public final void setAccounts(ArrayList<String> arrayList) {
        this.accounts = arrayList;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public final void setGiftId(String str) {
        this.giftId = str;
    }

    public final void setGiftName(String str) {
        this.giftName = str;
    }

    public final void setGiftNum(int i11) {
        this.giftNum = i11;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setPngUrl(String str) {
        this.pngUrl = str;
    }

    public final void setSelfReward(boolean z11) {
        this.isSelfReward = z11;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "RewardsAnim(avatar=" + this.avatar + ", nickname=" + this.nickname + ", giftId=" + this.giftId + ", giftName=" + this.giftName + ", giftNum=" + this.giftNum + ", pngUrl=" + this.pngUrl + ", gifUrl=" + this.gifUrl + ", type=" + this.type + ", accounts=" + this.accounts + ", isSelfReward=" + this.isSelfReward + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RewardsAnim(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, java.util.ArrayList r23, boolean r24, int r25, kotlin.jvm.internal.r r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000a
        L_0x0009:
            r4 = r15
        L_0x000a:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0010
            r5 = r2
            goto L_0x0012
        L_0x0010:
            r5 = r16
        L_0x0012:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r1 = 1
            r8 = r1
            goto L_0x001b
        L_0x0019:
            r8 = r19
        L_0x001b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0022
            r0 = 0
            r13 = r0
            goto L_0x0024
        L_0x0022:
            r13 = r24
        L_0x0024:
            r3 = r14
            r6 = r17
            r7 = r18
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.active.RewardsAnim.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.Integer, java.util.ArrayList, boolean, int, kotlin.jvm.internal.r):void");
    }
}
