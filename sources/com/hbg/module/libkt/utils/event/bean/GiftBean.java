package com.hbg.module.libkt.utils.event.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.x;

public final class GiftBean implements Parcelable {
    public static final Parcelable.Creator<GiftBean> CREATOR = new Creator();
    private String amount;
    private int combo;
    private String currency;
    private String giftActivityId;
    private int giftGroupId;
    private String giftId;
    private String giftIntroduction;
    private String giftName;
    private int label;
    private String labelTitle;
    private int leftIntegral;
    private int unlockIntegral;
    private String urlGif;
    private String urlJson;
    private String urlPng;

    public static final class Creator implements Parcelable.Creator<GiftBean> {
        /* renamed from: a */
        public final GiftBean createFromParcel(Parcel parcel) {
            return new GiftBean(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b */
        public final GiftBean[] newArray(int i11) {
            return new GiftBean[i11];
        }
    }

    public GiftBean(String str, int i11, String str2, String str3, String str4, String str5, String str6, String str7, int i12, String str8, String str9, String str10, int i13, int i14, int i15) {
        this.giftId = str;
        this.giftGroupId = i11;
        this.giftName = str2;
        this.currency = str3;
        this.amount = str4;
        this.urlPng = str5;
        this.urlGif = str6;
        this.urlJson = str7;
        this.label = i12;
        this.labelTitle = str8;
        this.giftActivityId = str9;
        this.giftIntroduction = str10;
        this.unlockIntegral = i13;
        this.leftIntegral = i14;
        this.combo = i15;
    }

    public static /* synthetic */ GiftBean copy$default(GiftBean giftBean, String str, int i11, String str2, String str3, String str4, String str5, String str6, String str7, int i12, String str8, String str9, String str10, int i13, int i14, int i15, int i16, Object obj) {
        GiftBean giftBean2 = giftBean;
        int i17 = i16;
        return giftBean.copy((i17 & 1) != 0 ? giftBean2.giftId : str, (i17 & 2) != 0 ? giftBean2.giftGroupId : i11, (i17 & 4) != 0 ? giftBean2.giftName : str2, (i17 & 8) != 0 ? giftBean2.currency : str3, (i17 & 16) != 0 ? giftBean2.amount : str4, (i17 & 32) != 0 ? giftBean2.urlPng : str5, (i17 & 64) != 0 ? giftBean2.urlGif : str6, (i17 & 128) != 0 ? giftBean2.urlJson : str7, (i17 & 256) != 0 ? giftBean2.label : i12, (i17 & 512) != 0 ? giftBean2.labelTitle : str8, (i17 & 1024) != 0 ? giftBean2.giftActivityId : str9, (i17 & 2048) != 0 ? giftBean2.giftIntroduction : str10, (i17 & 4096) != 0 ? giftBean2.unlockIntegral : i13, (i17 & 8192) != 0 ? giftBean2.leftIntegral : i14, (i17 & 16384) != 0 ? giftBean2.combo : i15);
    }

    public final String component1() {
        return this.giftId;
    }

    public final String component10() {
        return this.labelTitle;
    }

    public final String component11() {
        return this.giftActivityId;
    }

    public final String component12() {
        return this.giftIntroduction;
    }

    public final int component13() {
        return this.unlockIntegral;
    }

    public final int component14() {
        return this.leftIntegral;
    }

    public final int component15() {
        return this.combo;
    }

    public final int component2() {
        return this.giftGroupId;
    }

    public final String component3() {
        return this.giftName;
    }

    public final String component4() {
        return this.currency;
    }

    public final String component5() {
        return this.amount;
    }

    public final String component6() {
        return this.urlPng;
    }

    public final String component7() {
        return this.urlGif;
    }

    public final String component8() {
        return this.urlJson;
    }

    public final int component9() {
        return this.label;
    }

    public final GiftBean copy(String str, int i11, String str2, String str3, String str4, String str5, String str6, String str7, int i12, String str8, String str9, String str10, int i13, int i14, int i15) {
        return new GiftBean(str, i11, str2, str3, str4, str5, str6, str7, i12, str8, str9, str10, i13, i14, i15);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftBean)) {
            return false;
        }
        GiftBean giftBean = (GiftBean) obj;
        return x.b(this.giftId, giftBean.giftId) && this.giftGroupId == giftBean.giftGroupId && x.b(this.giftName, giftBean.giftName) && x.b(this.currency, giftBean.currency) && x.b(this.amount, giftBean.amount) && x.b(this.urlPng, giftBean.urlPng) && x.b(this.urlGif, giftBean.urlGif) && x.b(this.urlJson, giftBean.urlJson) && this.label == giftBean.label && x.b(this.labelTitle, giftBean.labelTitle) && x.b(this.giftActivityId, giftBean.giftActivityId) && x.b(this.giftIntroduction, giftBean.giftIntroduction) && this.unlockIntegral == giftBean.unlockIntegral && this.leftIntegral == giftBean.leftIntegral && this.combo == giftBean.combo;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final int getCombo() {
        return this.combo;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getGiftActivityId() {
        return this.giftActivityId;
    }

    public final int getGiftGroupId() {
        return this.giftGroupId;
    }

    public final String getGiftId() {
        return this.giftId;
    }

    public final String getGiftIntroduction() {
        return this.giftIntroduction;
    }

    public final String getGiftName() {
        return this.giftName;
    }

    public final int getLabel() {
        return this.label;
    }

    public final String getLabelTitle() {
        return this.labelTitle;
    }

    public final int getLeftIntegral() {
        return this.leftIntegral;
    }

    public final int getUnlockIntegral() {
        return this.unlockIntegral;
    }

    public final String getUrlGif() {
        return this.urlGif;
    }

    public final String getUrlJson() {
        return this.urlJson;
    }

    public final String getUrlPng() {
        return this.urlPng;
    }

    public int hashCode() {
        int hashCode = ((((((((this.giftId.hashCode() * 31) + this.giftGroupId) * 31) + this.giftName.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.amount.hashCode()) * 31;
        String str = this.urlPng;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.urlGif;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.urlJson;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.label) * 31;
        String str4 = this.labelTitle;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.giftActivityId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.giftIntroduction;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return ((((((hashCode6 + i11) * 31) + this.unlockIntegral) * 31) + this.leftIntegral) * 31) + this.combo;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setCombo(int i11) {
        this.combo = i11;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setGiftActivityId(String str) {
        this.giftActivityId = str;
    }

    public final void setGiftGroupId(int i11) {
        this.giftGroupId = i11;
    }

    public final void setGiftId(String str) {
        this.giftId = str;
    }

    public final void setGiftIntroduction(String str) {
        this.giftIntroduction = str;
    }

    public final void setGiftName(String str) {
        this.giftName = str;
    }

    public final void setLabel(int i11) {
        this.label = i11;
    }

    public final void setLabelTitle(String str) {
        this.labelTitle = str;
    }

    public final void setLeftIntegral(int i11) {
        this.leftIntegral = i11;
    }

    public final void setUnlockIntegral(int i11) {
        this.unlockIntegral = i11;
    }

    public final void setUrlGif(String str) {
        this.urlGif = str;
    }

    public final void setUrlJson(String str) {
        this.urlJson = str;
    }

    public final void setUrlPng(String str) {
        this.urlPng = str;
    }

    public String toString() {
        return "GiftBean(giftId=" + this.giftId + ", giftGroupId=" + this.giftGroupId + ", giftName=" + this.giftName + ", currency=" + this.currency + ", amount=" + this.amount + ", urlPng=" + this.urlPng + ", urlGif=" + this.urlGif + ", urlJson=" + this.urlJson + ", label=" + this.label + ", labelTitle=" + this.labelTitle + ", giftActivityId=" + this.giftActivityId + ", giftIntroduction=" + this.giftIntroduction + ", unlockIntegral=" + this.unlockIntegral + ", leftIntegral=" + this.leftIntegral + ", combo=" + this.combo + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.giftId);
        parcel.writeInt(this.giftGroupId);
        parcel.writeString(this.giftName);
        parcel.writeString(this.currency);
        parcel.writeString(this.amount);
        parcel.writeString(this.urlPng);
        parcel.writeString(this.urlGif);
        parcel.writeString(this.urlJson);
        parcel.writeInt(this.label);
        parcel.writeString(this.labelTitle);
        parcel.writeString(this.giftActivityId);
        parcel.writeString(this.giftIntroduction);
        parcel.writeInt(this.unlockIntegral);
        parcel.writeInt(this.leftIntegral);
        parcel.writeInt(this.combo);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GiftBean(java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, int r31, int r32, int r33, int r34, kotlin.jvm.internal.r r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 1
            r11 = r1
            goto L_0x000b
        L_0x0009:
            r11 = r27
        L_0x000b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r15 = r2
            goto L_0x0014
        L_0x0012:
            r15 = r31
        L_0x0014:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x001b
            r16 = r2
            goto L_0x001d
        L_0x001b:
            r16 = r32
        L_0x001d:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0024
            r17 = r2
            goto L_0x0026
        L_0x0024:
            r17 = r33
        L_0x0026:
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r12 = r28
            r13 = r29
            r14 = r30
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.utils.event.bean.GiftBean.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, kotlin.jvm.internal.r):void");
    }
}
