package com.hbg.module.libkt.utils.event.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hbg.module.libkt.base.ext.b;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class LiveRedpacketBean implements Parcelable {
    public static final Parcelable.Creator<LiveRedpacketBean> CREATOR = new Creator();
    private Double amount;
    private String amountStr;
    private String avatar;
    private String countdown;
    private String currency;

    /* renamed from: m  reason: collision with root package name */
    private Integer f24883m;
    private String nickname;
    private String packetId;
    private Integer rule;

    /* renamed from: s  reason: collision with root package name */
    private Integer f24884s;
    private String startTime;

    public static final class Creator implements Parcelable.Creator<LiveRedpacketBean> {
        /* renamed from: a */
        public final LiveRedpacketBean createFromParcel(Parcel parcel) {
            return new LiveRedpacketBean(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final LiveRedpacketBean[] newArray(int i11) {
            return new LiveRedpacketBean[i11];
        }
    }

    public LiveRedpacketBean() {
        this((String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Double) null, (String) null, (String) null, 2047, (r) null);
    }

    public LiveRedpacketBean(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Integer num3, Double d11, String str6, String str7) {
        this.packetId = str;
        this.rule = num;
        this.nickname = str2;
        this.startTime = str3;
        this.avatar = str4;
        this.countdown = str5;
        this.f24883m = num2;
        this.f24884s = num3;
        this.amount = d11;
        this.amountStr = str6;
        this.currency = str7;
    }

    public static /* synthetic */ LiveRedpacketBean copy$default(LiveRedpacketBean liveRedpacketBean, String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Integer num3, Double d11, String str6, String str7, int i11, Object obj) {
        LiveRedpacketBean liveRedpacketBean2 = liveRedpacketBean;
        int i12 = i11;
        return liveRedpacketBean.copy((i12 & 1) != 0 ? liveRedpacketBean2.packetId : str, (i12 & 2) != 0 ? liveRedpacketBean2.rule : num, (i12 & 4) != 0 ? liveRedpacketBean2.nickname : str2, (i12 & 8) != 0 ? liveRedpacketBean2.startTime : str3, (i12 & 16) != 0 ? liveRedpacketBean2.avatar : str4, (i12 & 32) != 0 ? liveRedpacketBean2.countdown : str5, (i12 & 64) != 0 ? liveRedpacketBean2.f24883m : num2, (i12 & 128) != 0 ? liveRedpacketBean2.f24884s : num3, (i12 & 256) != 0 ? liveRedpacketBean2.amount : d11, (i12 & 512) != 0 ? liveRedpacketBean2.amountStr : str6, (i12 & 1024) != 0 ? liveRedpacketBean2.currency : str7);
    }

    public final RedpacketRefreshStatus calcRefreshStatus(Object obj) {
        if (b.x(this.packetId)) {
            return RedpacketRefreshStatus.VISIBILITY_GONE;
        }
        if (this == obj) {
            return RedpacketRefreshStatus.ANIMATION_AND_REFRESH;
        }
        if (!x.b(LiveRedpacketBean.class, obj != null ? obj.getClass() : null)) {
            return RedpacketRefreshStatus.ANIMATION_AND_REFRESH;
        }
        LiveRedpacketBean liveRedpacketBean = (LiveRedpacketBean) obj;
        if (x.b(this.packetId, liveRedpacketBean.packetId) && !x.b(this.countdown, liveRedpacketBean.countdown)) {
            return RedpacketRefreshStatus.ONLY_COUNTDOWN_REFRESH;
        }
        if (!x.b(this.packetId, liveRedpacketBean.packetId)) {
            return RedpacketRefreshStatus.ANIMATION_AND_REFRESH;
        }
        return RedpacketRefreshStatus.NO_ACTION;
    }

    public final String component1() {
        return this.packetId;
    }

    public final String component10() {
        return this.amountStr;
    }

    public final String component11() {
        return this.currency;
    }

    public final Integer component2() {
        return this.rule;
    }

    public final String component3() {
        return this.nickname;
    }

    public final String component4() {
        return this.startTime;
    }

    public final String component5() {
        return this.avatar;
    }

    public final String component6() {
        return this.countdown;
    }

    public final Integer component7() {
        return this.f24883m;
    }

    public final Integer component8() {
        return this.f24884s;
    }

    public final Double component9() {
        return this.amount;
    }

    public final LiveRedpacketBean copy(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Integer num3, Double d11, String str6, String str7) {
        return new LiveRedpacketBean(str, num, str2, str3, str4, str5, num2, num3, d11, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveRedpacketBean)) {
            return false;
        }
        LiveRedpacketBean liveRedpacketBean = (LiveRedpacketBean) obj;
        return x.b(this.packetId, liveRedpacketBean.packetId) && x.b(this.rule, liveRedpacketBean.rule) && x.b(this.nickname, liveRedpacketBean.nickname) && x.b(this.startTime, liveRedpacketBean.startTime) && x.b(this.avatar, liveRedpacketBean.avatar) && x.b(this.countdown, liveRedpacketBean.countdown) && x.b(this.f24883m, liveRedpacketBean.f24883m) && x.b(this.f24884s, liveRedpacketBean.f24884s) && x.b(this.amount, liveRedpacketBean.amount) && x.b(this.amountStr, liveRedpacketBean.amountStr) && x.b(this.currency, liveRedpacketBean.currency);
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getAmountStr() {
        return this.amountStr;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCountdown() {
        return this.countdown;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Integer getM() {
        return this.f24883m;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPacketId() {
        return this.packetId;
    }

    public final Integer getRule() {
        return this.rule;
    }

    public final Integer getS() {
        return this.f24884s;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        String str = this.packetId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.rule;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.nickname;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.startTime;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.avatar;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.countdown;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.f24883m;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f24884s;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d11 = this.amount;
        int hashCode9 = (hashCode8 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str6 = this.amountStr;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.currency;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode10 + i11;
    }

    public final void setAmount(Double d11) {
        this.amount = d11;
    }

    public final void setAmountStr(String str) {
        this.amountStr = str;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setCountdown(String str) {
        this.countdown = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setM(Integer num) {
        this.f24883m = num;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setPacketId(String str) {
        this.packetId = str;
    }

    public final void setRule(Integer num) {
        this.rule = num;
    }

    public final void setS(Integer num) {
        this.f24884s = num;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public String toString() {
        return "LiveRedpacketBean(packetId=" + this.packetId + ", rule=" + this.rule + ", nickname=" + this.nickname + ", startTime=" + this.startTime + ", avatar=" + this.avatar + ", countdown=" + this.countdown + ", m=" + this.f24883m + ", s=" + this.f24884s + ", amount=" + this.amount + ", amountStr=" + this.amountStr + ", currency=" + this.currency + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.packetId);
        Integer num = this.rule;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.nickname);
        parcel.writeString(this.startTime);
        parcel.writeString(this.avatar);
        parcel.writeString(this.countdown);
        Integer num2 = this.f24883m;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.f24884s;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Double d11 = this.amount;
        if (d11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d11.doubleValue());
        }
        parcel.writeString(this.amountStr);
        parcel.writeString(this.currency);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LiveRedpacketBean(java.lang.String r13, java.lang.Integer r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.lang.Integer r20, java.lang.Double r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.jvm.internal.r r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r13
        L_0x0009:
            r2 = r0 & 2
            r3 = 1
            if (r2 == 0) goto L_0x0013
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x0014
        L_0x0013:
            r2 = r14
        L_0x0014:
            r4 = r0 & 4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            r4 = r5
            goto L_0x001d
        L_0x001c:
            r4 = r15
        L_0x001d:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0023
            r6 = r5
            goto L_0x0025
        L_0x0023:
            r6 = r16
        L_0x0025:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002b
            r7 = r5
            goto L_0x002d
        L_0x002b:
            r7 = r17
        L_0x002d:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            r8 = r5
            goto L_0x0035
        L_0x0033:
            r8 = r18
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003f
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0041
        L_0x003f:
            r9 = r19
        L_0x0041:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x004c
        L_0x004a:
            r3 = r20
        L_0x004c:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0057
            r10 = 0
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
            goto L_0x0059
        L_0x0057:
            r10 = r21
        L_0x0059:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x005f
            r11 = r5
            goto L_0x0061
        L_0x005f:
            r11 = r22
        L_0x0061:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r5 = r23
        L_0x0068:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r3
            r22 = r10
            r23 = r11
            r24 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
